package com.stream.employeemanagement.controller;

import com.stream.employeemanagement.pojo.Employee;
import com.stream.employeemanagement.pojo.Page;
import com.stream.employeemanagement.pojo.Response;
import com.stream.employeemanagement.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/employees")
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public Response getAll()
    {
        log.info("GetAll");
        return Response.builder()
                       .success(true)
                       .message("Get Employees")
                       .data(employeeService.getAll())
                       .build();
    }

    @GetMapping("/paged")
    public Response getByPage(@RequestParam(defaultValue = "0") int index,
                              @RequestParam(defaultValue = "5") int size)
    {
        log.info("GetByPage:index={},size={}", index, size);
        return Response.builder()
                       .success(true)
                       .message("Get Employees By Page")
                       .data(Page.builder()
                                 .index(index)
                                 .size(size)
                                 .data(employeeService.getByPage(index, size))
                                 .build())
                       .build();
    }

    @DeleteMapping("/{id}")
    public Response deleteById(@PathVariable int id)
    {
        log.info("DeleteById");
        return Response.builder()
                       .success(true)
                       .message("Delete Employee")
                       .data(employeeService.deleteById(id))
                       .build();
    }

    @PostMapping
    public Response add(@RequestBody Employee employee)
    {
        log.info("AddEmployee");
        return Response.builder()
                       .success(true)
                       .message("Add Employee")
                       .data(employeeService.add(employee))
                       .build();
    }
}
