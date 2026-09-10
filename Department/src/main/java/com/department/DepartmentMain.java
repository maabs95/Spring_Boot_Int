package com.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.department", "com.util"})
@EnableJpaRepositories(basePackages = "com.util.repository")
@EntityScan(basePackages = "com.util.model")
public class DepartmentMain {
    static void main(String[] args) {
        SpringApplication.run(DepartmentMain.class, args);
    }
}
