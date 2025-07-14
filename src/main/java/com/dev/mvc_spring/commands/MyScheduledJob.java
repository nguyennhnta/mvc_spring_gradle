package com.dev.mvc_spring.commands;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class MyScheduledJob {
    @Scheduled(fixedRate = 5000) // chạy mỗi 5 giây
    public void runEvery5Seconds() {
        System.out.println("Chạy job lúc: " + LocalDateTime.now());
    }

}
