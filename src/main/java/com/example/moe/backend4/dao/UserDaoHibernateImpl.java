package com.example.moe.backend4.dao;

import com.example.moe.backend4.dao.UserDAO;
import com.example.moe.backend4.entity.User;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;



@Repository
public class UserDaoHibernateImpl implements UserDAO {
    


// define field for entity manager

    private EntityManager entityManager;
//set up constructor injection
    @Autowired
    public UserDaoHibernateImpl (EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }
//Implement interface
    @Override
   
    public List<User> findAll(){
        //get the current hibernate session
        Session currentSesh = this.entityManager.unwrap(Session.class);
        //create query
        Query<User> queryAllUsers = currentSesh.createQuery("from User", User.class);
        //execute query and get result list
        List<User> users = (List<User>) queryAllUsers.getResultList();
        //return results
        return users;
    }

    @Override
    public User findById(int theId) {
        //get current Sesh
        Session currentSesh = this.entityManager.unwrap(Session.class);
        //getEmployee
        User requestedUser = currentSesh.get(User.class, theId);
        //
        return requestedUser;
    }

    @Override
    public void saveUser(User theUser) {
        //get current sesh
        Session currentSesh = this.entityManager.unwrap(Session.class);
        //save/update if the value is 0 it'll do an insert, if the value isn't it'll do an update
        currentSesh.saveOrUpdate(theUser);

    }

    @Override
    public void delUser(int theId) {
        //get sesh
        Session currentSesh = this.entityManager.unwrap(Session.class);

        Query query = currentSesh.createQuery("delete from User where user_id=: userId");

        query.setParameter("userId", theId);

        query.executeUpdate();


    }
    
}