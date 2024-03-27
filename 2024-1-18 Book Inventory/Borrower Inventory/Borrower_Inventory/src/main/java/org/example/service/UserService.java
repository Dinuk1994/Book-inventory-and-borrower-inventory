package org.example.service;

import org.example.dto.User;
import org.example.entity.UserEntity;

import java.util.List;

public interface UserService {
    public List<UserEntity> getAll();

    public void addUser(User user);

    void deleteUser(Long id);

    public User findByUserName(String userName);

    Boolean isExistsUser(String userName);
}
