package com.example.pipeline.repository;

import com.example.pipeline.model.DataEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DataRepository implements PanacheRepository<DataEntity> {
}