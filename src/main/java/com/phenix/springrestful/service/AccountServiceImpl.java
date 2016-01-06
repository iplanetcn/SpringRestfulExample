package com.phenix.springrestful.service;

import com.phenix.springrestful.dao.AccountDao;
import com.phenix.springrestful.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by john on 1/7/16.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;


    @Override
    @Transactional
    public void register(Account account) {
        accountDao.register(account);
    }

    @Override
    @Transactional
    public boolean login(String username,String password) {
        return accountDao.login(username,password);
    }

}
