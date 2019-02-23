package com.leo.henry.messenger.model;

import com.leo.henry.messenger.enums.Constants;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

@Data
@Entity
@Table(schema = Constants.SCHEMA_NAME)
@NoArgsConstructor
@XmlRootElement
public class Message extends SuperModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "message body cannot be null")
    @Column
    private String message;

    @ManyToOne
    @JoinColumn(name = "Author_Id")
    private User author;
//
//    @Column
//    private List<Link> links = new ArrayList<>();

//    @Column
//    @XmlTransient
//    private Set<Comment> comments ;

    public Message(Long id, String message,User author) {
        this.id = id;
        this.message = message;
        this.author = author;
    }

//    public void addLinks(String url,String rel)
//    {
//        Link link = new Link();
//        link.setLink(url);
//        link.setRel(rel);
//        links.add(link);
//    }
}
