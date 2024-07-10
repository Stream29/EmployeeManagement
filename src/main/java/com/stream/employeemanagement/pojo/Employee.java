package com.stream.employeemanagement.pojo;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class Employee
{
    private int id;
    private String name;
    private String sex;
    private String phone;
    private Instant createTime;
    private Instant updateTime;
}
