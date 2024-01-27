package com.heroku.java;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Visitor {
    private Integer visitorId;
    private String visitorName;
    private String visitorEmail;

    public Visitor(Integer visitorId, String visitorName, String visitorEmail) {
        this.visitorId = visitorId;
        this.visitorName = visitorName;
        this.visitorEmail = visitorEmail;
    }
}