package com.kosmos.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
	
	User findByUserName(String userID);

}
