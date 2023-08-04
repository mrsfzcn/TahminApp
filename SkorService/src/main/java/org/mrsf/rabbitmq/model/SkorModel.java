package org.mrsf.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkorModel implements Serializable {

    private int skor;
    private Long userId;

}
