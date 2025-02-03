package org.klesse;

import lombok.AllArgsConstructor;
import org.klesse.service.CreditAnalysisService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CreditAnalysisApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditAnalysisApplication.class, args);
    }
}