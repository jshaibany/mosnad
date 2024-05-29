package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserActivity;

import com.example.demo.entity.UserRoleAssign;
import com.example.demo.repository.UserActivityRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserRoleAssignRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final UserActivityRepository userActivityRepository;
	private final UserRoleAssignRepository userRoleRepository;

    public UserService(UserRepository userRepository, 
    		UserActivityRepository userActivityRepository, 
    		UserRoleAssignRepository userRoleRepository) {
        this.userRepository = userRepository;
		this.userActivityRepository = userActivityRepository;
		this.userRoleRepository = userRoleRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
    
    public UserActivity createUserActivity(UserActivity userActivity) {
        return userActivityRepository.save(userActivity);
    }
    
    public UserRoleAssign assignUserRole(UserRoleAssign userRoleAssign) {
        return userRoleRepository.save(userRoleAssign);
    }
    
    public UserRoleAssign getUserRole(Long userId) {
        return userRoleRepository.findByUserid(userId);
    }
    
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByUsernameAndPassword(String username,String password) {
        Optional<User> userOptional = Optional.of(userRepository.findByUsernameAndPassword(username,password));
        return userOptional.orElse(null);
    }
    
    public User getUserByEmailAndPassword(String email,String password) {
        Optional<User> userOptional = Optional.of(userRepository.findByEmailAndPassword(email,password));
        return userOptional.orElse(null);
    }
    
}
