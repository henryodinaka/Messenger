package com.leo.henry.messenger.model;

import com.leo.henry.messenger.enums.Constants;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@Entity
@Table(schema = Constants.SCHEMA_NAME)
@XmlRootElement
public class User extends SuperModel{
  
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String uri;

    @Column
    private String firstName;

    @Column
    private String lastName;

}