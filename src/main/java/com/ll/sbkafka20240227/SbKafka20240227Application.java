package com.ll.sbkafka20240227;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class SbKafka20240227Application {

    public static void main(String[] args) {
        SpringApplication.run(SbKafka20240227Application.class, args);
    }

}
