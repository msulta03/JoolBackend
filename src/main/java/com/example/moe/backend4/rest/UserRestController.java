package com.example.moe.backend4.rest;

import java.util.List;

import javax.management.RuntimeErrorException;

import com.example.moe.backend4.entity.User;
import com.example.moe.backend4.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRestController { 


    private UserService userve;
    

    @Autowired
     UserRestController(UserService theUserService){
        this.userve = theUserService;
    }

    //expose "/user" and return list of employees
    @GetMapping("/Users")
    public List<User> findAll (){
        System.out.println("find all method");
        return  userve.findAll();
    }

    //expose mapping for GET /User/{userId} READ
    @GetMapping("/Users/{id_user}")
   public User getUser(@PathVariable int id_user){
        User theUser = userve.findById(id_user);

        if (theUser == null){
            throw new RuntimeException("the employee Id was not found - "+ id_user);
        }
        return theUser;
   } 

   //CREATE
	@PostMapping("/Users")
	public User addEmployee(@RequestBody User theUser) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theUser.setId(0);
		
		userve.saveUser(theUser);
		
		return theUser;
    }
    

	// add mapping for PUT /employees - update existing employee
	
	@PutMapping("/Users")
	public User updateUser(@RequestBody User theUser) {
		
		userve.saveUser(theUser);
		
		return theUser;
	}
	
	// add mapping for DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/Users/{id_user}")
	public String deleteUser(@PathVariable int id_user) {
		
		User tempUser = userve.findById(id_user);
		
		// throw exception if null
		
		if (tempUser == null) {
			throw new RuntimeException("User id not found - " + id_user);
		}
		
		userve.delUser(id_user);
		
		return "Deleted User id - " + id_user;
	}

}