package org.cameroncreates.components;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerComponent {

    @Scheduled(fixedRate = 60000) // Run every 60 seconds
    public void checkUptime() {
    }
}
