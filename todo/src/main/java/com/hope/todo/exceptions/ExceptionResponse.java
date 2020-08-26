package com.hope.todo.exceptions;

import java.util.Date;

public class ExceptionResponse {
    private Date errorTimesStamp;
    private String errorMessage;
    private String errorDetail;

    public ExceptionResponse(Date errorTimesStamp, String errorMessage, String errorDetail) {
        super();
        this.errorTimesStamp = errorTimesStamp;
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
    }

    public Date getErrorTimesStamp() {
        return errorTimesStamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorDetail() {
        return errorDetail;
    }
}
