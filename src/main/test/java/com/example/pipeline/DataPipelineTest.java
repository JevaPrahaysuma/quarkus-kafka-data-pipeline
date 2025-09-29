package com.example.pipeline;

import com.example.pipeline.model.DataEntity;
import com.example.pipeline.repository.DataRepository;
import com.example.pipeline.service.DataProcessingService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class DataPipelineTest {

    @Inject
    DataProcessingService service;

    @Inject
    DataRepository repository;

    @Test
    public void testProcessAndSave() {
        String testMessage = "hello-test";

        // Process & save message
        service.processAndSave(testMessage);

        // Fetch data
        DataEntity entity = repository.find("name", "KafkaMessage").firstResult();

        assertNotNull(entity, "Entity should not be null");
        assertEquals("KafkaMessage", entity.getName());
        assertEquals(testMessage.hashCode(), entity.getValue());
    }
}