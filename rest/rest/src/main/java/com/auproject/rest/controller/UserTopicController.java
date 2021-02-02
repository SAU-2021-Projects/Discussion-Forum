package com.auproject.rest.controller;


import com.auproject.rest.dao.Topic;
import com.auproject.rest.dao.UserTopic;
import com.auproject.rest.service.UserTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserTopicController {

    @Autowired
    private UserTopicService userTopicService;



    @PostMapping("/topic/subscribe/{userid}")
    @CrossOrigin("*")
    public ResponseEntity<Boolean> setTopic(@RequestBody List<Topic> topics,@PathVariable int userid){
        return new ResponseEntity<>(this.userTopicService.set(topics,userid),HttpStatus.OK);
    }

    @DeleteMapping("/topic/unsubscribe")
    @CrossOrigin("*")
    public ResponseEntity<Boolean> deleteTopic(@RequestBody List<UserTopic> userTopic ){
        return new ResponseEntity<>(this.userTopicService.delete(userTopic), HttpStatus.OK);
    }



}

