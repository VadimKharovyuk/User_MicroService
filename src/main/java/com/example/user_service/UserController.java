package com.example.user_service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final NotificationClient notificationClient;

    @PostMapping("/users/{userId}/notify")
    public void notifyUser(@PathVariable String userId, @RequestBody String message) {
        NotificationRequest request = new NotificationRequest(userId, message);
        notificationClient.sendNotification(request);
    }
    @GetMapping("/all")
    public List<Notification> notificationRequests(){
      return   notificationClient.getAll();
    }
    @GetMapping("/{id}")
    public Notification getById(@PathVariable  long id){
       return notificationClient.findByid(id);
    }
}
