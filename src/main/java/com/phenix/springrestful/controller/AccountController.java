package com.phenix.springrestful.controller;

import com.phenix.springrestful.domain.Account;
import com.phenix.springrestful.entity.Resp;
import com.phenix.springrestful.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AccountController {
    public static final String REGISTER_PATTERN = "/user/register";

    public static final String LOGIN_PATTERN = "/user/login";

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = REGISTER_PATTERN, method = RequestMethod.POST)
    public @ResponseBody
    Resp accountRegister(@RequestBody Account account) {
        System.out.println(account.getUsername() + "\n" + account.getPassword());

        if (account.getUsername().isEmpty() || account.getPassword().isEmpty()){
            return Resp.failure("username or password null");
        }

        if (accountService.register(account)){
            return Resp.success("register success");
        }else {
            return Resp.failure("register failure");
        }

    }


    @RequestMapping(value = LOGIN_PATTERN, method = RequestMethod.POST)
    public @ResponseBody
    Resp accountLogin(@RequestBody Account account) {
        System.out.println(account.getUsername() + "\n" + account.getPassword());

        if (account.getUsername().isEmpty() || account.getPassword().isEmpty()){
            return Resp.failure("username or password null");
        }

        if (accountService.login(account)){
            return Resp.success("login success");
        }else {
            return Resp.failure("login failure");
        }
    }
}
