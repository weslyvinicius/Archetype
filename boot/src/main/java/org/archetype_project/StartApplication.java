package org.archetype_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:rest-application.yml",
                         "classpath:repository-application.yml",
                         "classpath:clients-application.yml",
                         "classpath:boot-application.yml"})

public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }
}
