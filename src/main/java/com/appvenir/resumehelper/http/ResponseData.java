package com.appvenir.resumehelper.http;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ResponseData {

    private LocalDateTime timeStamp = LocalDateTime.now();
    private String message;
    private Object data;
    private String path;

    public ResponseData(Object data)
    {
        this.data = data;
        this.message = "Success";
    }
    
}
