package com.auproject.rest.controller;

import com.auproject.rest.dao.Notification;
import com.auproject.rest.service.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAsync
public class EmailNotificationController {

    @Autowired
    private EmailNotificationService emailNotificationService;


    @Async
    @GetMapping("/notify/ans/{questionId}")
    @CrossOrigin("*")
    public void newAnswer( @PathVariable int questionId) {
        this.emailNotificationService.addAnswerNotification( questionId);
    }

    @Async
    @GetMapping("/notify/ques/{topicId}/{topicName}")
    @CrossOrigin("*")
    public void newQuestion(@PathVariable int topicId,@PathVariable String topicName){
        this.emailNotificationService.newQuestion(topicId,topicName);
    }

    @GetMapping("/notify/{userId}")
    @CrossOrigin("*")
    public List<Notification> showNotification(@PathVariable int userId){
        return this.emailNotificationService.showNotifications(userId);
    }

}
