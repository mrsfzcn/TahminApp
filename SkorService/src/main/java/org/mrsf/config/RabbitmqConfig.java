package org.mrsf.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    private String queueSkor="skor-queue";

    @Bean
    public Queue skorQueue(){
        return new Queue(queueSkor);
    }


}
