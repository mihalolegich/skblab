package com.shipunovm.skblab.service.account;

import com.shipunovm.skblab.dao.AccountDao;
import com.shipunovm.skblab.domain.account.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private final AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Transactional
    public Account save(Account account) {
        return accountDao.save(account);
    }

}
