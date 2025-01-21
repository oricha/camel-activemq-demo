package com.example.camelactivemqdemo.stepdefinitions;

import io.cucumber.java.en.*;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestToQueueSteps {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private ConsumerTemplate consumerTemplate;

    private String message;

    @Given("un mensaje {string}")
    public void unMensaje(String mensaje) {
        this.message = mensaje;
    }

    @When("lo envío al endpoint REST {string}")
    public void loEnvioAlEndpointREST(String endpoint) {
        producerTemplate.sendBody("direct:restToQueue", message);
    }

    @Then("debería estar en la cola {string}")
    public void deberiaEstarEnLaCola(String queue) {
        String messageFromQueue = consumerTemplate.receiveBody("activemq:" + queue, String.class);
        assertEquals(message, messageFromQueue);
    }
}
