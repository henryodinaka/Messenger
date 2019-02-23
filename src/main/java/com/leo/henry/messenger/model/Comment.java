package com.leo.henry.messenger.model;

import com.leo.henry.messenger.enums.Constants;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@Entity
@Table(schema = Constants.SCHEMA_NAME,name = "Comments")
@NoArgsConstructor
@XmlRootElement
public class Comment extends SuperModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Long id;

    @NotNull(message = "Comment body cannot be null")
    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name = "message_Id")
    private Message message;

//    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
//    private Date createdAt;
//    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
//    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "Author_Id",referencedColumnName = "Id")
    private User author;

    public Comment(Long id, String comment, User author) {
        this.id = id;
        this.comment = comment;
        this.author = author;
    }
}
