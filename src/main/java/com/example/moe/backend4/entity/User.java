package com.example.moe.backend4.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser")
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "userEmail")
    private String email;

  
    //TODO: fix this
    @Column(name = "userPassword")
    private String password;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Cart_idCart")
    private int cartId;
    //define constructors
    public User() {

    }
    public User(String firstName, String lastName, String email, String password, int cart){
        this.email = email;
        this.password =  password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cartId = cart;
    }
    //getter/setter
    
    public Object getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    };

    public Object getName() {
        return this.firstName + ' ' + this.lastName;
    }

    public void setName(String name) {
        String[] fullName = name.split("\b \b");
        this.firstName = fullName[0];
        this.lastName = fullName[1];
    };
    public Object getPass() {
        return this.password;
    }

    public void setPass(String pass) {
        this.password = pass;
    };

   
    //toString method
    @Override
    public String toString(){
        return "User: [id = " + this.id + ", first name = " +this.firstName + ", last name = " + this.lastName + ", email = " + this.email + ", cartID = " + this.cartId + "testPass = " +this.password+"]";
        
    }
}