package com.binar.app.controller;

import com.binar.app.response.Respon;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.binar.app.service.Firebase.FirebaseMessagingService;
import com.binar.app.service.Firebase.model.FirebaseNote;
import org.springframework.web.bind.annotation.*;


@RestController
public class FirebaseController {

    private final FirebaseMessagingService firebaseService;

    public FirebaseController(FirebaseMessagingService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @RequestMapping("/send-notification")
    @ResponseBody
    public String sendNotification(@RequestBody FirebaseNote note,
                                   @RequestParam String token) throws FirebaseMessagingException {

        Respon ress = new Respon();
        ress.setResponCode("200");
        ress.setMessage("succes");
        ress.setData(firebaseService.sendNotification(note,token));
        return null;
    }

}

