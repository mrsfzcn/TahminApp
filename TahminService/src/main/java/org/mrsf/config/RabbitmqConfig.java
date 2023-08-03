package org.mrsf.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    private String exchange="tahmin-exchange";
    private String queueSkor="skor-queue";
    private String skorbindingKey="skor-key";

    @Bean
    public DirectExchange exchangeTahmin(){
        return new DirectExchange(exchange);
    }
    @Bean
    public Queue skorQueue(){
        return new Queue(queueSkor);
    }
    @Bean
    public Binding bindingSkor(final Queue skorQueue, final DirectExchange exchangeTahmin){
        return BindingBuilder.bind(skorQueue).to(exchangeTahmin).with(skorbindingKey);
    }

}
