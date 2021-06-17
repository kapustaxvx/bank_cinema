/*package com.moskalenko.bankcinema.kafka;

import com.moskalenko.bankcinema.api.beans.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    private static final Logger log = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "users", groupId = "user_group_id")
    public void consume (User user){
        log.info("Consuming is user " + user);
    }
}*/
