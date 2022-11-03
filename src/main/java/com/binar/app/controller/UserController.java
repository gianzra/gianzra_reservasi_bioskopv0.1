package com.binar.app.controller;

import com.binar.app.dto.UserDTO;
import com.binar.app.model.User;
import com.binar.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
