package com.example.finshot_first.controller;

import com.example.finshot_first.domain.Employees;
import com.example.finshot_first.service.EmplsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmplsController {
    @Autowired
    private EmplsService emplsService;

    @GetMapping("/employees/manage")
    public String employeesManage(Model model){
        model.addAttribute("employees", emplsService.getAllEmployees());
        return "emplsManage";
    }
    @GetMapping("/employees/add")
    public String addEmployee(){
        return "addEmployee";
    }
    @PostMapping("/employees/add")
    public String addEmployee(Employees employees){
        emplsService.addEmployee(employees);
        return "redirect:/employees/manage";
    }

    @PostMapping("/employees/update")
    public String updateEmployee(Employees employees){
        emplsService.updateEmployee(employees);
        return "redirect:/employees/manage";
    }
    @PostMapping("/employees/delete")
    public String deleteEmployee(@RequestParam("id") int id){
        emplsService.deleteEmployee(id);
        return "redirect:/employees/manage";
    }
}
