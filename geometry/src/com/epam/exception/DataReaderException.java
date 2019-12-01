package com.epam.exception;


public class DataReaderException extends Exception {
    public DataReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataReaderException(String message) {
        super(message);
    }

    public DataReaderException() {
    }
}
