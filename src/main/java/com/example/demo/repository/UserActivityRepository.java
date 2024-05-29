package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserActivity;

public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {

}
