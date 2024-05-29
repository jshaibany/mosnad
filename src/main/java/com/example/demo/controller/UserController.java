package com.example.demo.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.entity.UserActivity;
import com.example.demo.entity.UserRoleAssign;
import com.example.demo.helper.Cypher;
import com.example.demo.service.UserService;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @RequestMapping("/api/users")
    @ResponseBody
    public HashMap<String,Object> createUser(@RequestBody User user) {
    	
    	HashMap<String,Object> response = new HashMap<>();
    	
    	try {
			user.setPassword(Cypher.hashText(user.getPassword(), "SHA-256"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.put("message", String.format("User creation has failed, exception %s",e.getMessage()));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.put("message", String.format("User creation has failed, exception %s",e.getMessage()));
		}
    	
    	try {
			
    		User u= userService.createUser(user);
    		
    		response.put("username", u.getUsername());
    		response.put("message", String.format("Username:%s is created successfully", u.getUsername()));
    		
    		//Assign client role by default
    		UserRoleAssign ura = new UserRoleAssign();
    		ura.setUserid(u.getId());
    		ura.setRoleid(3L);
    		
    		userService.assignUserRole(ura);
    		System.out.println("User is assigned client role by default");
    		
    		return response;
    		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.put("message", String.format("User creation has failed, please contact system admin"));
			
			return response;
			
		}
        
    }
    
    @PostMapping
    @RequestMapping("/api/users/auth")
    @ResponseBody
    public HashMap<String,Object> authenticateUser(@RequestBody User user) {
    	
    	HashMap<String,Object> response = new HashMap<>();
    	
    	try {
    		//Hash the password before lookinup the user entity
			user.setPassword(Cypher.hashText(user.getPassword(), "SHA-256"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.put("message", String.format("Encryption error, exception %s",e.getMessage()));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.put("message", String.format("Encryption error, exception %s",e.getMessage()));
		}
    	
    	try {
			
    		//Call the service function to locate the user
    		User u= userService.getUserByEmailAndPassword(user.getUsername(),user.getPassword());
    		
    		if(u!=null) {
    			
    			//Add user activity
    			UserActivity ua = new UserActivity();
    			ua.setUserid(u.getId());
    			ua.setActivity_name("LOGIN");
    			
    			userService.createUserActivity(ua);
    			
    			response.put("username", u.getUsername());
        		response.put("message", String.format("User authenticated", u.getUsername()));
        		
        		return response;
    		}
    		
    		throw new Exception();
    		
    		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.put("message", String.format("User authentication has failed, please check your credentials and try again"));
			
			return response;
			
		}
        
    }
    
    @PostMapping
    @RequestMapping("/api/users/changepassword")
    @ResponseBody
    public HashMap<String,Object> changeUserPassword(@RequestBody HashMap<String,String> user) {
    	
    	HashMap<String,Object> response = new HashMap<>();
    	
    	//Check current credentials if valid
    	
    	try {
			
    		//Call the service function to locate the user
    		System.out.println(user.get("username"));
    		System.out.println(user.get("password"));
    		
    		User u= userService.getUserByUsernameAndPassword(user.get("username"),Cypher.hashText(user.get("password"), "SHA-256"));
    		
    		System.out.println("Get user OK!");
    		
    		if(u==null) {
    			
    			System.out.println("User credentials incorrect!");
    			throw new Exception();
    		}
    		
    		//Else continue
    		
    		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.put("message", String.format("User authentication has failed, please check your credentials and try again"));
			
			return response;
			
		}
    	
    	//Compare the new password with the confirmed passwords
    	
    	if(!user.get("newpassword").contentEquals(user.get("confirmedpassword"))){
    		
    		response.put("message", String.format("New password and confimred not matched"));
			
			return response;
    	}
    	
    	
    	//Hash the new password
    	String userNewPasswordHashed;
    	String userOldPasswordHashed;
		try {
			userNewPasswordHashed = Cypher.hashText(user.get("newpassword"), "SHA-256");
			userOldPasswordHashed = Cypher.hashText(user.get("password"), "SHA-256");
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			response.put("message", String.format("Cypher error"));
    		
    		return response;
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			response.put("message", String.format("Cypher error"));
    		
    		return response;
		}
    	
    	try {
			
    		//Call the service function to update the user
    		User u= userService.getUserByUsernameAndPassword(user.get("username"),userOldPasswordHashed);
    		u.setPassword(userNewPasswordHashed);
    		u=userService.updateUser(u);
    		
    		if(u!=null) {
    			
    			response.put("username", u.getUsername());
        		response.put("message", String.format("User updated", u.getUsername()));
        		
        		return response;
    		}
    		
    		throw new Exception();
    		
    		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.put("message", String.format("User change password has failed, please check the logs"));
			
			return response;
			
		}
        
    }
    
    @PostMapping
    @RequestMapping("/api/role/assign")
    @ResponseBody
    public HashMap<String,Object> assignUserRole(@RequestBody UserRoleAssign userRoleAssign) {
    	
    	HashMap<String,Object> response = new HashMap<>();
    	
    	//Check current credentials if valid
    	
    	try {
    		
    		UserRoleAssign u= userService.assignUserRole(userRoleAssign);
    		
    		if(u==null) {
    			
    			System.out.println("User credentials incorrect!");
    			throw new Exception();
    		}
    		
    		//Else continue
    		
    		response.put("message", String.format("User Role assignment done successfully"));
			
			return response;
    		
    		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.put("message", String.format("User Role assignment has failed"));
			
			return response;
			
		}
    	
    	
        
    }

    
}
