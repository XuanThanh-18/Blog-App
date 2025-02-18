package com.xuanthanh.blog_app.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private String timesStamp;
    private String message;
    private Map<String,String> details;

    public ErrorResponse(String message, Map<String, String> details) {
        this.timesStamp = LocalDateTime.now().toString();
        this.message = message;
        this.details = details;
    }
}
