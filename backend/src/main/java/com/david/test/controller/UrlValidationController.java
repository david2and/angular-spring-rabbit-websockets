package com.david.test.controller;

import com.david.test.model.UrlValidationResponse;
import com.david.test.model.UrlValidationRequest;
import com.david.test.service.AMQPProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class UrlValidationController {

    @Autowired
    AMQPProducer rabbitMQSender;


    @MessageMapping("/urlresp")
    public UrlValidationResponse greeting(UrlValidationRequest message) throws Exception {
        rabbitMQSender.sendMessage(message);

        return new UrlValidationResponse("Hello, " + HtmlUtils.htmlEscape(message.getText()) + "!");
    }

}
