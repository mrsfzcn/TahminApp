package org.mrsf.rabbitmq.consumer;

import lombok.RequiredArgsConstructor;
import org.mrsf.rabbitmq.model.SkorModel;
import org.mrsf.service.SkorService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkorConsumer {

    private final SkorService skorService;

    @RabbitListener(queues = "skor-queue")
    public void updateSkor(SkorModel model){
        skorService.saveOrUpdateSkor(model);
    }

}
