package com.epam.exception;

import java.io.IOException;

public class TxtReaderException extends Exception {
    public TxtReaderException(IOException e){
        initCause(e);
    }
}
