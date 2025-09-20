package com.exception_poc.demo.exception;

public class OrderNotFoundException extends RuntimeException{

public OrderNotFoundException(String message) {
        super(message);
    }

}
