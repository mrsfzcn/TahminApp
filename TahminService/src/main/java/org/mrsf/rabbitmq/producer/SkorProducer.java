package org.mrsf.rabbitmq.producer;

import lombok.RequiredArgsConstructor;
import org.mrsf.rabbitmq.model.SkorModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkorProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;
    @Value("${rabbitmq.skorkey}")
    private String key;
    public void sendSkor(SkorModel model){
        rabbitTemplate.convertAndSend(exchange, key, model);
    }
}
