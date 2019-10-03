package com.example.moe.backend4.dao;

import java.util.List;

import com.example.moe.backend4.entity.User;


public interface UserDAO {
    
    public List<User> findAll ();
}