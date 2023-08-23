package com.utilities.services;
import org.springframework.http.HttpStatus;

public class ExceptionHandler {

    public static HttpStatus resolveHttpStatus(Exception exception) {
        HttpStatus status;

        switch (exception.getClass().getSimpleName()) {
            case "ResourceNotFoundException":
                status = HttpStatus.NOT_FOUND;
                break;
            case "UnauthorizedException":
                status = HttpStatus.UNAUTHORIZED;
                break;
            case "IllegalArgumentException":
                status = HttpStatus.BAD_REQUEST;
                break;
            default:
                status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return status;
    }
}
