package com.api.servicios;

import java.util.List;
import java.util.Optional;

import com.api.entities.entity_user;
import com.api.repositories.repository_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class service_user {

    @Autowired
    private repository_user repository_user;

    public List<entity_user> getAll(){
        return (List<entity_user>) repository_user.getAll();
    }

    public Optional<entity_user> getUser(int id) {
        return (Optional<entity_user>) repository_user.getUser(id);
    }

    public entity_user registro(entity_user user){
        if(!repository_user.existeEmail(user.getEmail())){
            repository_user.save(user);
            return new entity_user();
        }else{            
            return user;
        }       
    } 
    
    public boolean existeEmail(String email) {
        return repository_user.existeEmail(email);
    }

    public entity_user autenticarUsuario(String email, String password) {
        Optional<entity_user> usuario = repository_user.autenticarUsuario(email, password);
        entity_user usEntity_user = new entity_user();

        if (usuario.isEmpty()) {            
            usEntity_user.setEmail(email);
            usEntity_user.setPassword(password);
            usEntity_user.setName("NO DEFINIDO");
            return usEntity_user;
        } else {
            return usuario.get();
        }
    }
}
