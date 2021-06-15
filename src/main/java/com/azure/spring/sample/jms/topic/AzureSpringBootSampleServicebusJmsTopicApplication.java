package com.azure.spring.sample.jms.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class AzureSpringBootSampleServicebusJmsTopicApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureSpringBootSampleServicebusJmsTopicApplication.class, args);
	}

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void registerResources() {
        ((DefaultJmsListenerContainerFactory)applicationContext.getBean("topicJmsListenerContainerFactory"))
            .setSubscriptionShared(Boolean.TRUE);
    }

}
