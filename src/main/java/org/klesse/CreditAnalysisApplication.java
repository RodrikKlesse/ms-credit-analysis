package org.klesse;

import lombok.AllArgsConstructor;
import org.klesse.service.CreditAnalysisService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@AllArgsConstructor
@SpringBootApplication
public class CreditAnalysisApplication {

    private CreditAnalysisService creditAnalysisService;

    public static void main(String[] args) {
        SpringApplication.run(CreditAnalysisApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            creditAnalysisService.analyze(null);
        };
    }
}