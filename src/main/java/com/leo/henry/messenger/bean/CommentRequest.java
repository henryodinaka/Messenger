package com.leo.henry.messenger.bean;

import lombok.Data;

@Data
public class CommentRequest {
    private Long id;
    private String comment;

    private Long messageId;
    private Long userId;
}
