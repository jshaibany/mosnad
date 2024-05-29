package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserRoleAssign;

public interface UserRoleAssignRepository extends JpaRepository<UserRoleAssign, Long> {

	UserRoleAssign findByUserid(Long userid);
}


