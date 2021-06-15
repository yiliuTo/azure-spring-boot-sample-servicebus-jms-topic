package com.azure.spring.sample.jms.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiveController {
    private static final String TOPIC_NAME = "tpc001";

    private static final String SUBSCRIPTION_NAME = "sub001";

    private final Logger logger = LoggerFactory.getLogger(TopicReceiveController.class);

    @JmsListener(destination = TOPIC_NAME, containerFactory = "topicJmsListenerContainerFactory",
        subscription = SUBSCRIPTION_NAME, concurrency = "4")
    public void receiveMessage(User user) {

        logger.info("Received message from topic: {}", user.getName());

    }
}
