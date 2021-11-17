package com.shipunovm.skblab.dao;

import com.shipunovm.skblab.domain.account.Account;

import java.util.List;

public interface AccountDao {

    public Account save(Account account);

    public List<Account> getAll();

}
