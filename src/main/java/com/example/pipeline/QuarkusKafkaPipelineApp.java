package com.example.pipeline;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class QuarkusKafkaPipelineApp {
    public static void main(String[] args) {
        Quarkus.run(args);
    }
}