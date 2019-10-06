package com.example.moe.backend4.entity;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "User" , schema = "Joole", uniqueConstraints = {
    @UniqueConstraint(columnNames = {
        "user_email"
    })
})
public class User {

    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id;

    @NotBlank
    @Size(min=3, max = 50)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(min=3, max = 50)
    @Column(name = "last_name")
    private String lastName;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    @Column(name = "user_email")
    private String email;

  
    //TODO: fix this
    @NotBlank
    @Size(min=6, max = 100)
    @Column(name = "user_password")
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", 
      joinColumns = @JoinColumn(name = "user_id"), 
      inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    //define constructors
    public User() {

    }
    public User(String firstName, String lastName, String email, String password, int cart){
        this.email = email;
        this.password =  password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //getter/setter
    public void setId (int theId){
        this.id = theId;
    }
    public int getID (){
        return this.id;
    }
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

    public Set<Role> getRoles() {
        return roles;
    }
 
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
   
    //toString method
    @Override
    public String toString(){
        return "User: [id = " + this.id + ", first name = " +this.firstName + ", last name = " + this.lastName + ", email = " + this.email + "testPass = " +this.password+"]";

    }
}