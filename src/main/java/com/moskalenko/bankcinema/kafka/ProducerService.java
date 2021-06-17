package com.moskalenko.bankcinema.kafka;

import com.moskalenko.bankcinema.api.beans.Director;
import com.moskalenko.bankcinema.api.beans.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    private static final Logger log = LoggerFactory.getLogger(ProducerService.class);

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void produce(User user) {
        log.info("Producing the user " + user);
        kafkaTemplate.send("users", user);
    }
}
