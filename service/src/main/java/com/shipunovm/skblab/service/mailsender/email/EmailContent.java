package com.shipunovm.skblab.service.mailsender.email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmailContent {

    private String data;

    @Override
    public String toString() {
        return "EmailContent{" +
                "data='" + data + '\'' +
                '}';
    }

}
