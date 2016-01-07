package com.phenix.springrestful.dao;

import com.phenix.springrestful.domain.Account;

import java.util.List;

/**
 * Created by john on 1/7/16.
 */


public interface AccountDao {
    void createAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(int accountId);
    Account getAccount(int id);
    List<Account> getAllAccounts();
}
