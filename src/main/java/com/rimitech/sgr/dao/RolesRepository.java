package com.rimitech.sgr.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rimitech.sgr.models.Role;




public interface RolesRepository extends JpaRepository<Role, String> {
	Role findByCode(String code);
}
