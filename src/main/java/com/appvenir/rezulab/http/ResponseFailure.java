package com.appvenir.rezulab.http;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ResponseFailure {
    private LocalDateTime timeStamp = LocalDateTime.now();
    private String simpleClassName;
    private String className;
    private String message;
    private String path;
   
    private String[] stackTrace;
    
    public ResponseFailure(int status, Exception ex)
    {

        this.simpleClassName = ex.getClass().getSimpleName();
        this.className = ex.getClass().getName();
        this.stackTrace = getStackTrace(ex);
        this.message = ex.getMessage();
    }

    public ResponseFailure(Exception ex)
    {
        this.simpleClassName = ex.getClass().getSimpleName();
        this.className = ex.getClass().getName();
        this.stackTrace = getStackTrace(ex);
        this.message = ex.getMessage();
    }

    public ResponseFailure(Exception ex, String path)
    {
        this.simpleClassName = ex.getClass().getSimpleName();
        this.className = ex.getClass().getName();
        this.message = ex.getMessage();
        this.path = path;
        this.stackTrace = getStackTrace(ex);
        
    }

    public static ResponseFailure set(Exception data, String path) {
        return new ResponseFailure(data, path);
    }

    private String[] getStackTrace(Exception ex) {
        StackTraceElement[] stackTraceElements = ex.getStackTrace();
        String[] stackTraceStrings = new String[stackTraceElements.length];
        
        for (int i = 0; i < stackTraceElements.length; i++) {
            stackTraceStrings[i] = stackTraceElements[i].toString();
        }
        
        return stackTraceStrings;
    }
    
}
