package com.leo.henry.messenger.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.leo.henry.messenger.utils.DateSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

@Data
@NoArgsConstructor
@XmlRootElement
public class Message {
    private Long id;
    private String message;
//    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    @JsonSerialize(using = DateSerializer.class)
    private Date createdAt =new Date();
    private Date updatedAt;
    private String author;
    private List<Link> links = new ArrayList<>();
    @XmlTransient
    private Map<Long,Comment> comments = new HashMap<>();
    public Message(Long id, String message,String author) {
        this.id = id;
        this.message = message;
        this.author = author;
    }

    public void addLinks(String url,String rel)
    {
        Link link = new Link();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
    }
}
