package com.binar.user.controller;

import com.binar.user.dto.UserDTO;
import com.binar.user.model.User;
import com.binar.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public UserDTO create(@RequestBody UserDTO request) {
        final User user = userService.mapToEntity(request);
        final User result = userService.create(user);
        return userService.mapToDto(result);
    }

    @PutMapping("update/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody UserDTO request) {
        final User user = userService.mapToEntity(request);
        final User result = userService.update(id, user);
        return userService.mapToDto(result);
    }

    @GetMapping("/all")
    public List<UserDTO> findAll() {
        return userService.findAll().stream().map(user -> userService.mapToDto(user)).toList();
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id) {
        return userService.delete(id);
    }

}
