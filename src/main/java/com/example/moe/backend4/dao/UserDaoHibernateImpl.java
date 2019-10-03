package com.example.moe.backend4.dao;

import com.example.moe.backend4.dao.UserDAO;
import com.example.moe.backend4.entity.User;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;



public class UserDaoHibernateImpl implements UserDAO {
    


// define field for entity manager
    private EntityManager entityManager;
//set up constructor injection
    @Autowired
    public UserDaoHibernateImpl (EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }
//Implement interface

    @Transactional
    public List<User> findAll(){
        //get the current hibernate session
        Session currentSesh = this.entityManager.unwrap(Session.class);
        //create query
        Query<User> queryAllUsers = currentSesh.createQuery("from User", User.class);
        //execute query and get result list
        List<User> users = queryAllUsers.getResultList();
        //return results
        return users;
    }
}