package com.serversidefileupload.FileUploadDiskDatabase.POJO;

import java.sql.Timestamp;

public class ErrorResponse {
    Timestamp timestamp;
    String error;
    String message;
    String requestURL;

    public ErrorResponse() {
    }


    public ErrorResponse(Timestamp timestamp, String error, String message, String requestURL) {
        this.timestamp = timestamp;
        this.error = error;
        this.message = message;
        this.requestURL = requestURL;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getRequestURL() {
        return requestURL;
    }
}
