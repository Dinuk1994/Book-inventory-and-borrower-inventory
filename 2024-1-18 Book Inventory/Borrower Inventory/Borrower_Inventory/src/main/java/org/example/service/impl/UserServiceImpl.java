package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.entity.UserEntity;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;
    final ModelMapper modelMapper;

    @Override
    public List<UserEntity> getAll() {
       return userRepository.findAll();
    }
}
