package com.leo.henry.messenger.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@XmlRootElement
public class User implements Serializable {
  
    private static final long serialVersionUID = 1L;

    private int id;

    private String uri;

    private String firstName;

    private String lastName;

}