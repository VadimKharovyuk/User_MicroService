package com.example.user_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "notification-service", url = "http://localhost:4001")
public interface NotificationClient {
    @PostMapping("/notifications")
    void sendNotification(@RequestBody NotificationRequest request);


    @GetMapping("/notifications/all")
    List<Notification> getAll();


    @GetMapping("notifications/{id}")
    Notification findByid(@PathVariable long id ) ;
}
