package com.api.interfaces;

import java.util.Optional;

import com.api.entities.entity_user;

import org.springframework.data.repository.CrudRepository;

public interface interface_user extends CrudRepository<entity_user,Integer>{
   Optional <entity_user> findByEmail(String email);
   Optional <entity_user> findByEmailAndPassword(String email, String password);  
}
