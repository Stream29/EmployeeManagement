package com.stream.employeemanagement.service;

import com.stream.employeemanagement.mapper.EmployeeMapper;
import com.stream.employeemanagement.pojo.Employee;
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

    public List<Employee> getByPage(int index, int size)
    {
        return employeeMapper.selectByPage(index * size, size);
    }

    public int deleteById(int id)
    {
        return employeeMapper.deleteById(id);
    }

    public int add(Employee employee)
    {
        return employeeMapper.insert(employee);
    }
}
