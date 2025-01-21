package com.example.camelactivemqdemo.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    private final ProducerTemplate producerTemplate;

    public RestApiController(ProducerTemplate producerTemplate) {
        this.producerTemplate = producerTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody String message) {
        producerTemplate.sendBody("direct:restToQueue", message);
        return "Mensaje enviado a la cola!";
    }
}
