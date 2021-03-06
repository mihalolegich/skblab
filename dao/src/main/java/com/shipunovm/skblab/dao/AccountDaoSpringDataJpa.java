package com.shipunovm.skblab.dao;

import com.shipunovm.skblab.dao.repository.AccountRepository;
import com.shipunovm.skblab.domain.account.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class AccountDaoSpringDataJpa implements AccountDao {

    private final AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

}
