package com.leo.henry.messenger.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String uri;
    private String firstName;
    private String lastName;
    private String profileName;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createdAt;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date updatedAt;

    public Profile(Long id,String firstName, String lastName, String profileName, Date createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileName = profileName;
        this.createdAt = createdAt;
    }
}
