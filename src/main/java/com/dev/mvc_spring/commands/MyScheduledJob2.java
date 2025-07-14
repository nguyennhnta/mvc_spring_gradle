package com.dev.mvc_spring.commands;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class MyScheduledJob2 {
    @Scheduled(fixedRate = 7000) // chạy mỗi 7 giây
    public void runEvery5Seconds() {
        System.out.println("Chạy 2 lúc: " + LocalDateTime.now());
    }

}