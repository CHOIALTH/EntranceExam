package com.example.test_gradle.controller;

import com.example.test_gradle.entity.Employee;
import com.example.test_gradle.exception.EmployeeNotFoundException;
import com.example.test_gradle.repository.EmployeeRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/employees")
    List<Employee> all(){
        return employeeRepository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee){
        return employeeRepository.save(newEmployee);
    }
    // Single item

//    @GetMapping("/employees/{id}")
//    Employee one(@PathVariable Long id){
//        return employeeRepository.findById(id)
//                .orElseThrow(()-> new EmployeeNotFoundException(id));
//    }
    @GetMapping("/employees/{id}")
    EntityModel<Employee> one(@PathVariable Long id){

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException(id));

        return EntityModel.of(employee,
                // asks that Spring HATEOAS build a link to the EmployeeController's one() method, and flag it as a self link.
                linkTo(methodOn(EmployeeController.class).one(id)).withSelfRel(),
                // asks Spring HATEOAS to build a link to the aggregate root, all(), and call it "employees".
                linkTo(methodOn(EmployeeController.class).all()).withRel("employees")
                // build a link : One of Spring HATEOAS's core types in Link. It includes a URI and a rel(relation).
        );
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id){
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return employeeRepository.save(employee);
                })
                .orElseGet(()->{
                    newEmployee.setId(id);
                    return employeeRepository.save(newEmployee);
                });
    }
    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id){
        employeeRepository.deleteById(id);
    }

}
