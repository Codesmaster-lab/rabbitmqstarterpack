package com.codesmaster.RabbitMqdemo.publisher;


import com.codesmaster.RabbitMqdemo.config.FileConfig;
import com.codesmaster.RabbitMqdemo.entity.Element;
import com.codesmaster.RabbitMqdemo.entity.Status;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class ElemPublish {
    @Autowired
    private RabbitTemplate template;

    @PostMapping("/{quesid}")
    public String submit(@RequestBody Element order, @PathVariable String quesid) {
         order.setID(UUID.randomUUID().toString());
         Status orderStatus = new Status(order, "PROCESS", "order placed succesfully for " + quesid);
        template.convertAndSend(FileConfig.EXCHANGE, FileConfig.ROUTING_KEY, orderStatus);
        return "Success !!";
    }
}
