package com.acerta.rest.config.middlewares.template;

import java.time.LocalDateTime;

public class ExceptionModelTemplate {
    private LocalDateTime timestamp;
    private int status;
    private String title;
    private String detail;
    private String userMessage;
    
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public String getUserMessage() {
        return userMessage;
    }
    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }
    public ExceptionModelTemplate(LocalDateTime timestamp, int status, String title, String detail,
            String userMessage) {
        this.timestamp = timestamp;
        this.status = status;
        this.title = title;
        this.detail = detail;
        this.userMessage = userMessage;
    }
    
    public ExceptionModelTemplate() {
    }

    


}
