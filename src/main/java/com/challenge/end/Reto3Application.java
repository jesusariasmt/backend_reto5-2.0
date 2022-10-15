package com.challenge.end;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages={"com.challenge.end.Controller", "com.challenge.end.Model", "com.challenge.end.Repository", "com.challenge.end.Repository.CrudRepository", "com.challenge.end.Service"})
@EntityScan("com.challenge.end.Model")
@EnableJpaRepositories("com.challenge.end.Repository")
//@ComponentScan({"com.challenge.end"})
public class Reto3Application {

    public static void main(String[] args) {
        SpringApplication.run(Reto3Application.class, args);
    }

}
