package com.example.pipeline.producer;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class KafkaOutputProducer {

    @Channel("output-topic")
    Emitter<String> emitter;

    public void send(String message) {
        emitter.send(message);
        System.out.println("Produced to output-topic: " + message);
    }
}