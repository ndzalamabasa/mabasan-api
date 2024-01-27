package com.heroku.java;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Message {
    public Message(Integer messageId, Integer visitorId, String message) {
        this.messageId = messageId;
        this.visitorId = visitorId;
        this.message = message;
    }

    private Integer messageId;
    private Integer visitorId;
    private String message;

}