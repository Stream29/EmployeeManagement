package com.stream.employeemanagement.mapper;

import com.stream.employeemanagement.pojo.Employee;
import com.stream.employeemanagement.pojo.PagedSearchParameters;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper
{
    @Select("select * from employees")
    List<Employee> selectAll();

    @Select("select count(*) from employees")
    int count();

    List<Employee> pagedSearch(PagedSearchParameters parameters);

    int deleteByIds(List<Integer> ids);

    @Insert("""
                        insert into employees(name,sex,phone,create_time,update_time)
            values(#{name},#{sex},#{phone},now(),now())""")
    int insert(Employee employee);
}
