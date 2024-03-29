package com.example.moe.backend4.dao;

import java.util.List;

import com.example.moe.backend4.entity.User;


public interface UserDAO {
    
    public List<User> findAll ();

    //CRUD methods
    public User findById(int theId);

    public void saveUser(User theUser);

    public void delUser(int theId);
}