package com.example.moe.backend4.service;

import java.util.List;

import com.example.moe.backend4.entity.User;



public interface UserService{

    public List<User> findAll ();

    //CRUD methods
    public User findById(int theId);

    public void saveUser(User theUser);

    public void delUser(int theId);
}









