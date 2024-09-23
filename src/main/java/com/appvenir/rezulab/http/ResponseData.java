package com.appvenir.rezulab.http;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData<T> {

    private LocalDateTime timeStamp = LocalDateTime.now();
    private Integer status;
    private String message;
    private String path;
    private T data;
    
    public ResponseData(int status, T data)
    {
        this.status = status;
        this.data = data;
        this.message = "Success";
    }

    public ResponseData(T data)
    {
        this.data = data;
    }

    public static <T> ResponseData<T> set(T data) {
        return new ResponseData<>(data);
    }
    
}
