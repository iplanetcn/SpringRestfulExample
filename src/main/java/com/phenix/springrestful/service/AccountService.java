package com.phenix.springrestful.service;

import com.phenix.springrestful.domain.Account;

/**
 * Created by john on 1/7/16.
 */
public interface AccountService {

    boolean isExists(Account account);
    boolean register(Account account);
    boolean login(Account account);
    boolean alterPassword(Account account, String newPassword);
}
