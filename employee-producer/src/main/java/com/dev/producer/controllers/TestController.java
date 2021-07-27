package com.dev.producer.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.producer.model.Employee;
import com.dev.producer.model.Status;
import com.dev.producer.model.Users;
import com.dev.producer.repository.UserRepository;
import com.dev.producer.service.UserService;


@RestController
@RequestMapping(path="/employee-producer")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", exposedHeaders = "Authorization")
public class TestController {
	
//	@RequestMapping(value = "/employee", method = RequestMethod.GET)  //Previous
//	public Employee firstPage() {
//
//		Employee emp = new Employee();
//		emp.setName("emp1");
//		emp.setDesignation("manager");
//		emp.setEmpId("1");
//		emp.setSalary(3000);
//
//		return emp;
//	}
	
	@Autowired
	private UserService userService;
	
	 @Autowired
	    UserRepository userRepository;
	 

	    @PostMapping("/users/register")
	    public Status registerUser(@Valid @RequestBody Users newUser) {
	        List<Users> users = userRepository.findAll();
	        System.out.println("New user: " + newUser.toString());
	        for (Users user : users) {
	            System.out.println("Registered user: " + newUser.toString());
	            if (user.equals(newUser)) {
	                System.out.println("User Already exists!");
	                return Status.USER_ALREADY_EXISTS;
	            }
	        }
	        userRepository.save(newUser);
	        return Status.SUCCESS;
	    }
	    
	    
	    @PostMapping("/users/login")
	    public Status loginUser(@Valid @RequestBody Users user) {
	        List<Users> users = userRepository.findAll();
	        for (Users other : users) {
	            if (other.equals(user)) {
	                user.setLoggedIn(true);
	                return Status.SUCCESS;
	            }
	        }
	        return Status.FAILURE;
	    }
	    
	    
	    @PostMapping("/users/logout")
	    public Status logUserOut(@Valid @RequestBody Users user) {
	        List<Users> users = userRepository.findAll();
	        for (Users other : users) {
	            if (other.equals(user)) {
	                user.setLoggedIn(false);
	                return Status.SUCCESS;
	            }
	        }
	        return Status.FAILURE;
	    }
	    
	    @DeleteMapping("/users/deleteAll")
	    public Status deleteUsers() {
	        userRepository.deleteAll();
	        return Status.SUCCESS;
	    }
	    
	    
	    @DeleteMapping("/users/delete/{id}")  
	    private Status deleteUserById(@PathVariable("id") int id)   
	    {  
	    	userRepository.deleteById(id);  
	    return Status.SUCCESS;
	    } 
	   
	    
	    @GetMapping(path="/users/all")
		 public Iterable<Users> getAllUsers() {
			 return userRepository.findAll();
	    }
	    
	    @GetMapping("/users/getbyid/{id}")  
	    private Optional<Users> getByUserId(@PathVariable("id") int id)   
	    {  
	    return userRepository.findById(id); 
	    }
	    
//	    @PostMapping("/users/forgot-password")
//		public String forgotPassword(@RequestParam String email) {
//
//			String response = userService.forgotPassword(email);
//
//			if (!response.startsWith("Invalid")) {
//				response = "http://localhost:8080/employee-producer/users/reset-password?token=" + response;
//			}
//			return response;
//		}
//
//		@PutMapping("/users/reset-password")
//		public String resetPassword(@RequestParam String token,
//				@RequestParam String password) {
//
//			return userService.resetPassword(token, password);
//		}
		

}
