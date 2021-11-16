package com.shipunovm.skblab.formbeans;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountFormBean {

    private String login;
    private String pass;
    private String email;
    private String name;
    private String lastName;
    private String patronymic;

}
