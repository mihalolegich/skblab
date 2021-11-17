package com.shipunovm.skblab.service.account;

import com.shipunovm.skblab.dao.AccountDao;
import com.shipunovm.skblab.dao.AccountDaoSpringDataJpa;
import com.shipunovm.skblab.domain.account.Account;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AccountServiceTest {

    @Test
    void save() {
        Account account = new Account();
        AccountDao dao = Mockito.mock(AccountDaoSpringDataJpa.class);
        when(dao.save(account)).then((invocation) -> {
            account.setId(1L);
            return account;
        });
        AccountService accountService = new AccountService(dao);
        accountService.save(account);
        verify(dao, times(1)).save(account);
        assertEquals(1L, account.getId());
    }

}