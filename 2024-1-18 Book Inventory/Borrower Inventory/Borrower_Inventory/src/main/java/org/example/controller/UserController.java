package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.User;
import org.example.entity.UserEntity;
import org.example.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public List<UserEntity> getAll(){
       return userService.getAll();
    }

    @PostMapping("/add-new-user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/find-by-user-name/{userName}")
    public User findByUserName(@PathVariable String userName){
        return userService.findByUserName(userName);
    }

    @GetMapping("/is-exist-user/{userName}")
    public Boolean isExistsUser(@PathVariable String userName){
        return userService.isExistsUser(userName);
    }

}
