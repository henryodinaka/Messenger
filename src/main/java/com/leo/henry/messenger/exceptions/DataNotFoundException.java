package com.leo.henry.messenger.exceptions;

import lombok.Data;

@Data
public class DataNotFoundException extends RuntimeException{


    private int code;
    private String refDocumention;

    public DataNotFoundException(String message, int code,String refDocumention)
    {
        super(message);
        this.code = code;
        this.refDocumention = refDocumention;
    }
}
