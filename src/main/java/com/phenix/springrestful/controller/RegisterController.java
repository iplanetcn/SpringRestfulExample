package com.phenix.springrestful.controller;

import com.phenix.springrestful.domain.Account;
import com.phenix.springrestful.domain.User;
import com.phenix.springrestful.service.AccountService;
import com.phenix.springrestful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by john on 1/7/16.
 */

@Controller
public class RegisterController {
    public static final String REGISTER_PATTERN = "/user/register";

    public static final String LOGIN_PATTERN = "/user/login";

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = REGISTER_PATTERN, method = RequestMethod.POST)
    public @ResponseBody
    String accountRegister(@RequestBody Account account) {
        System.out.println(account.getUsername() + "\n" + account.getPassword());
        if (null!=account && !account.getUsername().isEmpty() && !account.getPassword().isEmpty()){
            userService.insert(new User("john",28));
            accountService.register(new Account(account.getUsername(),account.getPassword()));
        }

        return "failure";
    }


    @RequestMapping(value = LOGIN_PATTERN, method = RequestMethod.POST)
    public @ResponseBody
    String accountLogin(@RequestBody Account account) {
        System.out.println(account.getUsername() + "\n" + account.getPassword());
        if (!account.getUsername().isEmpty() && !account.getPassword().isEmpty()){
            return accountService.login(account.getUsername(),account.getPassword())?"success":"failure";
        }
        return "failure";
    }
}
