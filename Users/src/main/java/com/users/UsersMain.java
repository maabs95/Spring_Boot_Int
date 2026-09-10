package com.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.users", "com.util"})
@EnableJpaRepositories(basePackages = "com.util.repository")
@EntityScan(basePackages = "com.util.model")
public class UsersMain {
    static void main(String[] args) {
        SpringApplication.run(UsersMain.class, args);
    }
}
