package com.example.camelactivemqdemo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("direct:restToQueue")
                .log("Mensaje recibido: ${body}")
                .to("activemq:demo-queue")
                .log("Mensaje enviado a la cola demo-queue");
    }
}
