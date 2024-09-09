package com.appvenir.resumehelper.http;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData {

    private LocalDateTime timeStamp = LocalDateTime.now();
    private Integer status;
    private String message;
    private String path;
    private Object data;
    
    public ResponseData(int status, Object data)
    {
        this.status = status;
        this.data = data;
        this.message = "Success";
    }

    public ResponseData(Object data)
    {
        this.data = data;
    }
    
}
