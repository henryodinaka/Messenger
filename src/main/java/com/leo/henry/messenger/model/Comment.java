package com.leo.henry.messenger.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@NoArgsConstructor
@XmlRootElement
public class Comment {
    private Long id;
    private String comment;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createdAt;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date updatedAt;
    private String author;

    public Comment(Long id, String comment, Date createdAt, String author) {
        this.id = id;
        this.comment = comment;
        this.createdAt = createdAt;
        this.author = author;
    }
}
