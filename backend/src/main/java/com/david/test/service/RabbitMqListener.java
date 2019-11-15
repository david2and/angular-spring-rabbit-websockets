package com.david.test.service;

import com.david.test.model.UrlValidationResponse;
import com.david.test.model.UrlValidationRequest;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RabbitMqListener {

    private final SimpMessagingTemplate template;

    private Gson gson;

    public RabbitMqListener(SimpMessagingTemplate template) {
        this.template = template;
    }

    @RabbitListener(queues="${rabbitmq.queueName}")
    public void listen(UrlValidationRequest message) throws Exception {
        //String msg = new String(message);
        //HelloMessage not = new Gson().fromJson(message, HelloMessage.class);
        System.out.println("Received a new notification...");
        Thread.sleep(1000);
        System.out.println(message.toString());
        System.out.println(message.getText());

        //template.setMessageConverter(new MappingJackson2MessageConverter());
        Random rand = new Random();


        template.convertAndSend("/topic/responses",
                new UrlValidationResponse(message.getText()+" - Value: "+ rand.nextFloat()));
    }

    //@SendTo("/topic/greetings")

}
