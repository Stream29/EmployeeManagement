package com.stream.employeemanagement.controller;

import com.stream.employeemanagement.pojo.Employee;
import com.stream.employeemanagement.pojo.PagedSearchParameters;
import com.stream.employeemanagement.pojo.Response;
import com.stream.employeemanagement.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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

    @GetMapping("/search")
    public Response pagedSearch(int index,
                                int size,
                                Integer id,
                                String name,
                                String sex,
                                String phone,
                                @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate createTimeFrom,
                                @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate createTimeTo)

    {
        val parameters = new PagedSearchParameters(index,
                                                   size,
                                                   id,
                                                   name,
                                                   sex,
                                                   phone,
                                                   createTimeFrom,
                                                   createTimeTo);
        log.info("PagedSearch: {}", parameters);
        return Response.success(employeeService.pagedSearch(parameters));
    }

    @DeleteMapping("/{ids}")
    public Response deleteByIds(@PathVariable List<Integer> ids)
    {
        log.info("DeleteByIds: {}", ids);
        return Response.success(employeeService.deleteByIds(ids));
    }

    @PostMapping
    public Response add(@RequestBody Employee employee)
    {
        log.info("AddEmployee: {}", employee);
        return Response.builder()
                       .success(true)
                       .message("Add Employee")
                       .data(employeeService.add(employee))
                       .build();
    }
}
