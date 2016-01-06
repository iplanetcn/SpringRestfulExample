package com.phenix.springrestful.dao;

import com.phenix.springrestful.domain.Account;

/**
 * Created by john on 1/7/16.
 */


public interface AccountDao {
    void register(Account account);
    boolean login(String username,String password);
}
