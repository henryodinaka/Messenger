package com.leo.henry.messenger.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
public class ErrorMessage {
    private String errorMessage;
    private int errorCode;
    private String documention;

    public ErrorMessage(String errorMessage, int errorCode, String documention) {
        super();
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.documention = documention;
    }
}
