package com.exception_poc.demo.exception;

public class DatabaseException extends RuntimeException{

    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }

}
