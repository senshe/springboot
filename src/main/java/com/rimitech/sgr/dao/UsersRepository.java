package com.rimitech.sgr.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rimitech.sgr.models.Users;




public interface UsersRepository extends JpaRepository<com.rimitech.sgr.models.Users, String>{
	
	 Users getUserByEmail(String email);
	
}
