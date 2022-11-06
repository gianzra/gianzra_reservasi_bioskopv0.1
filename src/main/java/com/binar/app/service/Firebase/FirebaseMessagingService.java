//package com.binar.app.service.Firebase;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.messaging.FirebaseMessaging;
//import com.google.firebase.messaging.FirebaseMessagingException;
//import com.google.firebase.messaging.Message;
//import com.google.firebase.messaging.Notification;
//import lombok.extern.slf4j.Slf4j;
//import com.binar.app.service.Firebase.model.FirebaseNote;
//
//import org.springframework.stereotype.Service;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Arrays;
//
//@Service
//@Slf4j
//public class FirebaseMessagingService {
//
//    private final FirebaseMessaging firebaseMessaging;
//
//    public FirebaseMessagingService(FirebaseMessaging firebaseMessaging) {
//        this.firebaseMessaging = firebaseMessaging;
//    }
//
//
//    public String sendNotification(FirebaseNote note, String topic) throws FirebaseMessagingException {
//        Notification notification = Notification
//                .builder()
//                .setTitle(note.getSubject())
//                .setBody(note.getContent())
//                .setImage(note.getImage())
//                .build();
//
//        Message message = Message
//                .builder()
////                .setToken(topic)
//                .setTopic(topic)
//                .setNotification(notification)
//                .putAllData(note.getData())
//                .build();
//        log.info(firebaseMessaging.send(message));
//        log.info("Send Firebase Messaging");
//        return firebaseMessaging.send(message);
//    }
//}