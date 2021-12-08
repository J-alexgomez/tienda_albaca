package com.api.controller_user;

import java.util.List;

import com.api.entities.entity_user;
import com.api.servicios.service_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class controller_user {

    @Autowired
    public service_user service_user;

    @GetMapping("/all")
    public List<entity_user> getAll(){
        return service_user.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public String registrar(@RequestBody entity_user usuario ) {
        service_user.registro(usuario);
        return "";
    }

    @GetMapping("/{email}/{password}")
    public entity_user autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return service_user.autenticarUsuario(email, password);
    }

    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return service_user.existeEmail(email);
    }

}
