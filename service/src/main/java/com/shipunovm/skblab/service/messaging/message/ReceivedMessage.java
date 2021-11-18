package com.shipunovm.skblab.service.messaging.message;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ReceivedMessage extends Message<String> {

    public ReceivedMessage(String body) {
        super(body);
    }

}
