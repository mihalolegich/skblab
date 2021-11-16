package com.shipunovm.skblab.domain.account;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String login;
    private String pass;
    private String email;
    private String name;
    private String lastName;
    private String patronymic;

    public Account(String login, String pass, String email, String name, String lastName, String patronymic) {
        this.login = login;
        this.pass = pass;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    public Account(String login, String pass, String email, String name, String lastName) {
        this(login, pass, email, name, lastName, null);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return 1; //constant because id is generated in database and changed from null after persist()
    }

}
