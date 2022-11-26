package com.javamaster.rest_controller;

import com.javamaster.model.User;
import com.javamaster.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserControllerV1 {
    private final UserServiceImpl userService;

    @Autowired
    public UserControllerV1(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        var createdUser = userService.create(user);
        return createdUser;
    }

    @GetMapping("/{id}")
    ResponseEntity<?> findById(@PathVariable Long id) {
        var user = userService.findById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(String.format("user with id=%s is not presented", id),
                HttpStatus.NOT_FOUND);
    }

    @GetMapping("/")
    ResponseEntity<?> findAll() {
        var users = userService.findAll();
        if (!users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        return new ResponseEntity<>("database doesn't contain users",
                HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteById(@PathVariable Long id) {
        boolean deleted = userService.deleteById(id);
        if (deleted) {
            return new ResponseEntity<>(String.format("user with id=%s was deleted", id) ,
                    HttpStatus.OK);
        }
        return new  ResponseEntity<>(String.format("user with id=%s wasn't deleted", id),
                HttpStatus.CONFLICT);
    }
}
