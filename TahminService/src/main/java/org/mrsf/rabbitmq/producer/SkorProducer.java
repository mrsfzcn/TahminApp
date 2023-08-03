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

    @Value("${rabbitmq.tahmin-exchange}")
    private String directExchange;
    @Value("${rabbitmq.skor-key}")
    private String sehirBindingKey;

    public void sendSkor(SkorModel model){
        rabbitTemplate.convertAndSend(directExchange, sehirBindingKey, model);
    }
}
