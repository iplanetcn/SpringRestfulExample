package com.phenix.springrestful.service;

import com.phenix.springrestful.dao.UserDao;
import com.phenix.springrestful.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by john on 1/7/16.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void insert(User user) {
        userDao.insert(user);
    }
}
