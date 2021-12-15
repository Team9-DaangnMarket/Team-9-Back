package com.sparta.team9back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Team9BackApplication {

    public static void main(String[] args) {
        SpringApplication.run(Team9BackApplication.class, args);
    }

}
