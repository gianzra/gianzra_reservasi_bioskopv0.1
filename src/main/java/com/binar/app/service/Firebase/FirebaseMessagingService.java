package com.binar.app.service.Firebase;

import com.binar.app.service.Firebase.model.FirebaseNote;
import com.binar.app.service.SeatServiceImpl;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirebaseMessagingService {
    private static final Logger logger = LoggerFactory.getLogger(FirebaseMessagingService.class);
    @Autowired
    private final FirebaseMessaging firebaseMessaging;

    public FirebaseMessagingService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }

    public String sendNotification(FirebaseNote note, String topic) throws FirebaseMessagingException {
        Notification notification = Notification
                .builder()
                .setTitle(note.getSubject())
                .setBody(note.getContent())
                .setImage(note.getImage())
                .build();

        Message message = Message
                .builder()
//                .setToken(topic)
                .setTopic(topic)
                .setNotification(notification)
                .putAllData(note.getData())
                .build();
        logger.info(firebaseMessaging.send(message));
        logger.info("Notification has been sent");
        return firebaseMessaging.send(message);
    }
}