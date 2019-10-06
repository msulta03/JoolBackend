package com.example.moe.backend4.service;

import java.util.List;

import com.example.moe.backend4.dao.UserDAO;
import com.example.moe.backend4.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService{

    private UserDAO userDao;

//constructor injection
    @Autowired
    UserServiceImpl(UserDAO theUserDao){
        this.userDao = theUserDao;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        
        return userDao.findAll();
    }

    @Override
    @Transactional
    public User findById(int theId) {
        
        return userDao.findById(theId);
    }

    @Override
    @Transactional
    public void saveUser(User theUser) {
        userDao.saveUser(theUser);

    }

    @Override
    @Transactional
    public void delUser(int theId) {
       userDao.delUser(theId);

    }
    
}