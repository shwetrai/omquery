package com.ba.infy.omquery.omquery.api.model;

import org.springframework.stereotype.Component;

@Component
public class RespMessage {

    private String respMessage;

    public String getRespMessage() {
        return respMessage;
    }

    public void setRespMessage(String respMessage) {
        this.respMessage = respMessage;
    }
}
