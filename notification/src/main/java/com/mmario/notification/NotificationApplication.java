package com.mmario.notification;


import com.mmario.amqp.RabbitMQMessageProducer;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
        scanBasePackages = {
                "com.mmario.notification",
                "com.mmario.amqp"
        }
)@EnableEurekaClient
@EnableFeignClients(
        basePackages = {"com.mmario.client"})

public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(
//            RabbitMQMessageProducer producer,
//            NotificationConfiguration notificationConfiguration
//    ) {
//        return args -> {
//
//            producer.publish(new Person("Daniel",28),
//                    notificationConfiguration.getInternalExchange(),
//                    notificationConfiguration.getInternalNotificationRoutingKeys());
//
//
//        };
//    }
//
//   record Person(String name , int age){}
}

