package com.api.repositories;

import java.util.List;
import java.util.Optional;

import com.api.entities.entity_user;
import com.api.interfaces.interface_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class repository_user {

    @Autowired
    private interface_user repoUser;

    public List<entity_user> getAll() {
        return (List<entity_user>) repoUser.findAll();
    }

    public Optional<entity_user> getUser(int id) {
        return (Optional<entity_user>) repoUser.findById(id);
    }

    public entity_user save(entity_user user) {
        return repoUser.save(user);
    }

    /*public entity_user buscarXEmail(String email) {
        Optional<entity_user> user = repoUser.findEmail(email);
        entity_user  usuario = user.get();
        return usuario;
    }*/

    public boolean existeEmail(String email) {
        Optional<entity_user> user;
        user = repoUser.findByEmail(email);
        return !user.isEmpty();
    }

    public Optional<entity_user> autenticarUsuario(String email, String password) {
        return (Optional <entity_user>) repoUser.findByEmailAndPassword(email, password);
    }
}
