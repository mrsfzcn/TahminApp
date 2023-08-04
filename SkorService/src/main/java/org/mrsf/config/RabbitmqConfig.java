package org.mrsf.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    

    @Value("${rabbitmq.skorqueue}")
    private String queueSkor;
    @Bean
    public Queue skorQueue(){
        return new Queue(queueSkor);
    }

}
