package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
