package com.shipunovm.skblab.service.messaging.message;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@EqualsAndHashCode
@Getter
public class MessageId {

    private final UUID uuid;

    public MessageId(UUID uuid) {
        this.uuid = uuid;
    }

}
