package com.leo.henry.messenger.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Data
@XmlRootElement
@NoArgsConstructor
public class ErrorMessage {
    private String errorMessage;
    List<String> errors;
    private int errorCode;
    private String error;
    private String path;
    private String documention;

    public ErrorMessage(String errorMessage, int errorCode, String documention) {
        super();
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.documention = documention;
    }
}
