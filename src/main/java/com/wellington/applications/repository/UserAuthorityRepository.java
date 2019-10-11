package com.wellington.applications.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wellington.applications.entity.UserAuthority;

public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Long> {

}