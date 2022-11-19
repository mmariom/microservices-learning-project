package com.mmario.notification;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfiguration {

    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;


    @Value("${rabbitmq.queues.notification}")
    private String notificationQueues;

    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String internalNotificationRoutingKeys;


    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(internalExchange);
    }
    @Bean
    public Queue notificationQueues() {
        return new Queue(notificationQueues);
    }
    @Bean
    public Binding internalToNotificationBinding() {
        return BindingBuilder.bind(notificationQueues()).to(internalTopicExchange())
                .with(internalNotificationRoutingKeys);
    }



    public String getInternalExchange() {
        return internalExchange;
    }

    public String getNotificationQueues() {
        return notificationQueues;
    }

    public String getInternalNotificationRoutingKeys() {
        return internalNotificationRoutingKeys;
    }
}
