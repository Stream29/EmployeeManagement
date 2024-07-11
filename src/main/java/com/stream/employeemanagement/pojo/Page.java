package com.stream.employeemanagement.pojo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Page
{
    private int index;
    private int size;
    private List<Employee> data;
}
