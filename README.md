# Sample for Spring JMS with Azure Service Bus Topic Spring Boot client library for Java

This sample project demonstrates how to enable shared subscription using Spring JMS Topic for Azure Service Bus via Spring Boot Starter `azure-spring-boot-starter-servicebus-jms`.
 
### Enable shared subscription
1. Add below code snippet in `AzureSpringBootSampleServicebusJmsTopicApplication.java` to get the bean of `topicJmsListenerContainerFactory` and modify its configuration.

    ```java
    @Autowired
    private ApplicationContext applicationContext;
    
    @PostConstruct
    public void registerResources() {
        ((DefaultJmsListenerContainerFactory)applicationContext.getBean("topicJmsListenerContainerFactory"))
        .setSubscriptionShared(Boolean.TRUE);
    }
    ```
### Config the project
1. Update [application.properties](https://github.com/Azure/azure-sdk-for-java/blob/master/sdk/spring/azure-spring-boot-samples/azure-spring-boot-sample-servicebus-jms-topic/src/main/resources/application.properties)

    ```properties
    # Fill service bus namespace connection string copied from portal
    spring.jms.servicebus.connection-string=[servicebus-namespace-connection-string]
    
    # The JMS client id needs to be specified when using topic and durable subscription
    # Default is empty string
    spring.jms.servicebus.topic-client-id=[topic-client-id]
    
    # The idle timeout in milliseconds after which the connection will be failed if the peer sends no AMQP frames
    # Default is 1800000
    spring.jms.servicebus.idle-timeout=[idle-timeout]
   
    #Fill service bus pricing tier according to the one you created. Supported values are premium and standard.
    spring.jms.servicebus.pricing-tier=[pricing-tier]
    ```

2. Specify your topic name and subscription name. Update `TOPIC_NAME` in [TopicSendController] and [TopicReceiveController], and `SUBSCRIPTION_NAME` in [TopicReceiveController].

### How to run
1. Run with Maven:
    ```
    mvn spring-boot:run
    ```

2. Send a POST request to service bus topic.
    ```
    $ curl -X POST localhost:8080/topic?message=hello
    ```

3. Verify in your app's logs that a similar message was posted:
    ```
    Sending message
    Received message from topic: hello
    ```
    

<!-- LINKS -->
[environment_checklist]: https://github.com/Azure/azure-sdk-for-java/blob/master/sdk/spring/ENVIRONMENT_CHECKLIST.md#ready-to-run-checklist
[TopicSendController]: https://github.com/Azure/azure-sdk-for-java/blob/master/sdk/spring/azure-spring-boot-samples/azure-spring-boot-sample-servicebus-jms-topic/src/main/java/com/azure/spring/sample/jms/topic/TopicSendController.java
[TopicReceiveController]: https://github.com/Azure/azure-sdk-for-java/blob/master/sdk/spring/azure-spring-boot-samples/azure-spring-boot-sample-servicebus-jms-topic/src/main/java/com/azure/spring/sample/jms/topic/TopicReceiveController.java
