package com.serversidefileupload.FileUploadDiskDatabase.Exception;
import com.serversidefileupload.FileUploadDiskDatabase.POJO.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import javax.naming.SizeLimitExceededException;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({StorageException.class})
    public ResponseEntity<ErrorResponse> handleStorageFileNotFound(StorageException e, HttpServletRequest request) {
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(new Timestamp(System.currentTimeMillis()),e.getMessage(),"Error in uploading file",request.getRequestURL().toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MultipartException.class})
    public ResponseEntity<ErrorResponse> handleSizeLimitExceededException(MultipartException e, HttpServletRequest request) {
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(new Timestamp(System.currentTimeMillis()),e.getMessage().split(":")[2].trim(),"Maximum size accepted is 4kB",request.getRequestURL().toString()), HttpStatus.PAYLOAD_TOO_LARGE);
    }

    @ExceptionHandler({MissingServletRequestPartException.class})
    public ResponseEntity<ErrorResponse> handleMissingServletRequestPartException(MissingServletRequestPartException e, HttpServletRequest request) {
        return new ResponseEntity<ErrorResponse>(new ErrorResponse(new Timestamp(System.currentTimeMillis()),e.getMessage(),"Minimum one file required",request.getRequestURL().toString()), HttpStatus.BAD_REQUEST);
    }
}
