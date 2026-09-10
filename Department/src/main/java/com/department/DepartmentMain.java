package com.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.department", "com.util"})
public class DepartmentMain {
    static void main(String[] args) {
        SpringApplication.run(DepartmentMain.class, args);
    }
}
