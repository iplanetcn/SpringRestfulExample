package com.phenix.springrestful.dao;

import com.phenix.springrestful.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by john on 1/7/16.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

}
