package com.mahiiru.messagerestapi.services;

import com.mahiiru.messagerestapi.models.User;
import com.mahiiru.messagerestapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public User updateUser(Long id, User user) {
        User existingUser = repository.findById(id).orElseThrow();
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setUrl_image_profile(user.getUrl_image_profile());
        return repository.save(existingUser);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
