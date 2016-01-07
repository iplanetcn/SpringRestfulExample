package com.phenix.springrestful.dao;

import com.phenix.springrestful.domain.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void createAccount(Account account) {
        getCurrentSession().save(account);
    }

    @Override
    public void updateAccount(Account account) {
        getCurrentSession().update(account);
    }

    @Override
    public void deleteAccount(int id) {
        Account account = getAccount(id);
        if (null!=account){
            getCurrentSession().delete(account);
        }
    }

    @Override
    public Account getAccount(int id) {
        return (Account) getCurrentSession().get(Account.class,id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Account> getAllAccounts() {
        return getCurrentSession().createQuery("from Account").list();
    }
}
