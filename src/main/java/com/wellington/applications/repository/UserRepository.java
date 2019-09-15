package com.wellington.applications.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellington.applications.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
