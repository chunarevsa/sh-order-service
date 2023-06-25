package com.smarthome.shorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.smarthome.shorderservice.repo")
@EntityScan(basePackageClasses = {
        ShOrderServiceApplication.class,
        Jsr310JpaConverters.class
})
public class ShOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShOrderServiceApplication.class, args);
    }

}
