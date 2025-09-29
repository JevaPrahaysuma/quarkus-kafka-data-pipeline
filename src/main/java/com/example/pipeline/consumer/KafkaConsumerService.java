package com.example.pipeline.consumer;

import com.example.pipeline.service.DataProcessingService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class KafkaConsumerService {

    @Inject
    DataProcessingService service;

    @Incoming("data-in") // sesuai dengan application.properties
    public void consume(String message) {
        System.out.println("Received from Kafka: " + message);
        service.processAndSave(message);
    }
}