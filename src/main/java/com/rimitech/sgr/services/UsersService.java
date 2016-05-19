package com.rimitech.sgr.services;

import java.util.List;


import com.rimitech.sgr.models.Users;

public interface UsersService {
Users add(Users users,String roleCode);
Users update(Users users);
List<Users> findAll();
Users findOne(String nni);
void delete(String id);
Users addRoleToUser(Users user, String roleCode);
}
