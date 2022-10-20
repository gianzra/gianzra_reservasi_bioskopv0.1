package com.binar.app.service;

import com.binar.app.dto.UserDTO;
import com.binar.app.model.User;

import java.util.List;

public interface UserService {

    User create(User user);
    User update(Long id, User user);
    Boolean delete(Long id);
    List<User> findAll();
    User findById(Long id);

    UserDTO mapToDto(User user);
    User mapToEntity(UserDTO userDTO);

}
