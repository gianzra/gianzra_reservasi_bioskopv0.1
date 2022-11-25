package com.binar.app.controller;

import com.binar.app.dto.AppUserDTO;
import com.binar.app.dto.ResponseDTO;
import com.binar.app.model.AppUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.binar.app.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping("register")
    public ResponseEntity<ResponseDTO<AppUser>> register(@RequestBody AppUserDTO userData) {
        ResponseDTO<AppUser> response = new ResponseDTO<>();
        ObjectMapper mapper = new ObjectMapper();
        AppUser appUser = mapper.convertValue(userData, AppUser.class);
        response.setPayload(appUserService.registerAppUser(appUser));
        response.setStatus(true);
        response.getMessasges().add("AppUser Saved!");
        return ResponseEntity.ok(response);
    }

}
