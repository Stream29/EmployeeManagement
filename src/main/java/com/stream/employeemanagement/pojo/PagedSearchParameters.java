package com.stream.employeemanagement.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

@Data
public class PagedSearchParameters
{
    public PagedSearchParameters(int index,
                                 int size,
                                 Integer id,
                                 String name,
                                 String sex,
                                 String phone,
                                 LocalDate createTimeFrom,
                                 LocalDate createTimeTo)
    {
        this.offset = index * size;
        this.limit = size;
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.createTimeFrom = atStartOfDay(createTimeFrom);
        this.createTimeTo = atStartOfDay(createTimeTo);
    }
    private int offset;
    private int limit;
    private Integer id;
    private String name;
    private String sex;
    private String phone;
    private Instant createTimeFrom;
    private Instant createTimeTo;
    private static Instant atStartOfDay(LocalDate localDate)
    {
        return Optional.ofNullable(localDate)
                       .map(o -> o.atStartOfDay(ZoneId.systemDefault())
                                  .toInstant())
                       .orElse(null);
    }
}
