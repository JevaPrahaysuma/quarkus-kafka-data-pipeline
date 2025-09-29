package com.example.pipeline.controller;

import com.example.pipeline.model.DataEntity;
import com.example.pipeline.repository.DataRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/data")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DataController {

    @Inject
    DataRepository repository;

    @POST
    @Transactional   // ✅ tambahkan ini agar persist dibungkus transaction
    public Response create(DataEntity entity) {
        repository.persist(entity);
        return Response.ok(entity).build();
    }

    @GET
    public Response list() {
        return Response.ok(repository.listAll()).build();
    }
}
