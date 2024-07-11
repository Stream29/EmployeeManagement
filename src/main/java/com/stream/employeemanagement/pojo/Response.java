package com.stream.employeemanagement.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response
{
    private boolean success;
    private String message;
    private Object data;
    public static Response success(Object data)
    {
        return Response.builder()
                       .success(true)
                       .message("Success")
                       .data(data)
                       .build();
    }
}
