package com.stream.employeemanagement.service;

import com.stream.employeemanagement.mapper.EmployeeMapper;
import com.stream.employeemanagement.pojo.Employee;
import com.stream.employeemanagement.pojo.PagedSearchParameters;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class EmployeeService
{
    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getAll()
    {
        return employeeMapper.selectAll();
    }

    public int count()
    {
        return employeeMapper.count();
    }

    public List<Employee> pagedSearch(PagedSearchParameters parameters)
    {
        return employeeMapper.pagedSearch(parameters);
    }

    public int deleteByIds(List<Integer> ids)
    {
        return employeeMapper.deleteByIds(ids);
    }

    public int add(Employee employee)
    {
        return employeeMapper.insert(employee);
    }
}
