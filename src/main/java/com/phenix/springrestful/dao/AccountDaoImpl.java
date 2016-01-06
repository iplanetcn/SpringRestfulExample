package com.phenix.springrestful.dao;

import com.phenix.springrestful.domain.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by john on 1/7/16.
 */
@Repository
public class AccountDaoImpl implements AccountDao{
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public boolean login(String username, String password) {
        if(username==null){
            username="";
        }
        if(password==null){
            password="";
        }
        List<Account> list = null;
        String hql="from Account as acc where acc.username='"+username+"' and acc.password = '"+password+"'";

        try {
            list = sessionFactory.getCurrentSession().createQuery(hql).list();

        } catch (DataAccessException e) {
            // TODO: handle exception
            return false;
        }

        if(list.isEmpty()){
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public void register(Account account) {
        sessionFactory.getCurrentSession().saveOrUpdate(account);
    }
}
