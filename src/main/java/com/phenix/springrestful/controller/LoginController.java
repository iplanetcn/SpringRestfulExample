package com.phenix.springrestful.controller;

import com.phenix.springrestful.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author john
 * @version 1.0
 * @date 2015-12-25 10:17
 */
@Controller
public class LoginController {
    @RequestMapping(value = LoginRestURIConstants.POST_LOGIN, method = RequestMethod.POST)
    public @ResponseBody
    String createEmployee(@RequestBody User user) {
        System.out.println(user.getUsername()+"\n"+user.getPassword());;
        return "success";
    }
}
