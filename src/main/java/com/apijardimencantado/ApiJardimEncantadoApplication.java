package com.apijardimencantado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ApiJardimEncantadoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiJardimEncantadoApplication.class, args);
    }

}
