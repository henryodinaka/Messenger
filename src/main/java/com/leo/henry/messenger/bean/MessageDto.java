package com.leo.henry.messenger.bean;

import com.leo.henry.messenger.model.User;
import lombok.Data;

@Data
public class MessageDto {
    private Long id;
    private String message;
    private User author;

}
