package com.heroku.java;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Message {
    public Message(Integer messageId, String message) {
        this.messageId = messageId;
        this.message = message;
    }

    private Integer messageId;
    private String message;

}