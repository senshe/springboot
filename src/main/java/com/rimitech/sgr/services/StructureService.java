package com.rimitech.sgr.services;

import java.util.List;

import com.rimitech.sgr.models.Structure;
import com.rimitech.sgr.models.Users;

public interface StructureService {
Structure add(Structure structure,Users admin);
Structure update(Structure structure);
List<Structure> findAll();
Structure findOne(Long id);
Users finAdmin(Long idSructure);
void delete(Long id);
}
