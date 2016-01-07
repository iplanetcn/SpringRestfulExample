package com.phenix.springrestful.service;

import com.phenix.springrestful.dao.AccountDao;
import com.phenix.springrestful.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional(readOnly = true)
    public boolean isExists(Account account) {
        List<Account> accounts = accountDao.getAllAccounts();
        if (accounts.size() > 0) {
            for (Account temp : accounts) {
                if (temp.getUsername().equals(account.getUsername())) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean register(Account account) {
        if (isExists(account)) {
            return false;
        } else {
            accountDao.createAccount(account);
            return true;
        }
    }

    @Override
    @Transactional
    public boolean login(Account account) {
        if (!isExists(account)) {
            return false;
        }

        List<Account> accounts = accountDao.getAllAccounts();
        for (Account temp : accounts) {
            if (temp.getUsername().equals(account.getUsername())
                    && temp.getPassword().equals(account.getPassword())) {
                return true;
            }
        }

        return false;
    }

    @Override
    @Transactional
    public boolean alterPassword(Account account, String newPassword) {
        return false;
    }
}
