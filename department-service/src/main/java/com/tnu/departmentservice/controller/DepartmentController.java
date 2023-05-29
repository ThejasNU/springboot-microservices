package com.tnu.departmentservice.controller;

import com.tnu.departmentservice.client.EmployeeClient;
import com.tnu.departmentservice.model.Department;
import com.tnu.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private EmployeeClient employeeClient;

    @GetMapping
    public List<Department> getAll(){
        LOGGER.info("Department find");
        return repository.findAll();
    }

    @PostMapping
    public Department add(@RequestBody Department department){
        LOGGER.info("Department add: {}",department);
        return repository.addDepartment(department);
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id){
        LOGGER.info("Department find: id={}",id);
        return repository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> getAllWithEmployees(){
        LOGGER.info("Department find");
        List<Department> departments = repository.findAll();
        departments.forEach(department -> department.setEmployees(
                employeeClient.findByDepartment(department.getId())
        ));
        return departments;
    }
}
