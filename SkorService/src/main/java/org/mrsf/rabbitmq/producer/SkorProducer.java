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

    public void sendSkor(SkorModel model){
        rabbitTemplate.convertAndSend("tahmin-exchange", "skor-key", model);
    }
}
