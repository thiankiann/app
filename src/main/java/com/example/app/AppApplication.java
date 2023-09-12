package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableFeignClients
public class AppApplication {

    @Autowired
    ShawnMendesProxy shownMendesClient;

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
    @EventListener(ApplicationStartedEvent.class)
    public void makeRequestToShawnMendesEndpoint(){
        String response = shownMendesClient.makeSearchRequest("shawnmendes",1);
        System.out.println(response);
    }
}
