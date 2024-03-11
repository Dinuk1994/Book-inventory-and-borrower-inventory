package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.UserEntity;
import org.example.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/User")
public class UserController {
    private final UserService userService;
    public List<UserEntity> getAll(){
       return userService.getAll();
    }

}
