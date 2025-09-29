package com.example.pipeline.service;

import com.example.pipeline.model.DataEntity;
import com.example.pipeline.repository.DataRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class DataProcessingService {

    @Inject
    DataRepository repository;

    @Transactional
    public void processAndSave(String message) {
        DataEntity entity = new DataEntity();
        entity.setName("KafkaMessage");
        entity.setValue(message.hashCode()); // convert message ke angka
        repository.persist(entity);
    }
}
