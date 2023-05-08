package com.example.finshot_first.mapper;

import com.example.finshot_first.domain.Employees;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeesMapper {
    // 직원 정보 등록
    @Insert("INSERT INTO employees(id, name, department, position, phone, email) VALUES (#{id}, #{name}, #{department}, #{position}, #{phone}, #{email})")
    void insert(Employees employees);
    // 직원 리스트 출력
    @Select("SELECT * FROM employees ORDER BY id")
    List<Employees> findAll();

    // 직원 검색
    // 각 필드별로 검색할 수 있도록 동적 query 작성함
    List<Employees> search(@Param("field") String field, @Param("value") String value);

    // 직원 정보 수정
    @Update("UPDATE employees SET name = #{name}, department = #{department}, position = #{position}, phone = #{phone}, email = #{email}")
    void update(Employees employees);
    // 직원 정보 삭제
    @Delete(" DELETE FROM employees WHERE id = #{id}")
    void delete(int id);
}
