package com.codesmaster.RabbitMqdemo.consumer;

import com.codesmaster.RabbitMqdemo.config.FileConfig;
import com.codesmaster.RabbitMqdemo.entity.Status;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class consume {

    @RabbitListener(queues = FileConfig.QUEUE)
    public void consumethemessagefromqueue(Status st){
        System.out.println("Message recieved from queue"+ st);
    }
}
