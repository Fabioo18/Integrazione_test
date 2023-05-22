package org.example;

public class NullNameException extends RuntimeException {
    public NullNameException(String errorMessage) {
        super(errorMessage);
    }
}