package com.example.pipeline.producer;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class KafkaProducerService {

    @Channel("data-out")
    Emitter<String> emitter;

    public void sendMessage(String message) {
        emitter.send(message);
    }
}