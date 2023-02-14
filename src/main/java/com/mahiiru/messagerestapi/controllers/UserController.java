package com.mahiiru.messagerestapi.controllers;


import com.mahiiru.messagerestapi.models.User;
import com.mahiiru.messagerestapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        //HTTP 200
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id){
        //HTTP 200
        return ResponseEntity.ok(service.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser = service.createUser(user);
        //HTTP 201
        return ResponseEntity.created(URI.create("/" + createdUser.getId())).body(createdUser);
    }

    @PutMapping
    @RequestMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        User updatedUser = service.updateUser(id,user);
        //HTTP 200
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        service.deleteUser(id);
        //HTTP 204
        return ResponseEntity.noContent().build();
    }
}
