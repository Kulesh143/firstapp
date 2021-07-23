package com.kulesh.firstapp.firstapp.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
           student Kulesh=new student(
                    "Kulesh",
                    "kulesh@yahoo.com",
                    LocalDate.of(1994, Month.JUNE,11)

            );
            student KalEl=new student(
                    "KalEl",
                    "kalel1994@yahoo.com",
                    LocalDate.of(2004, Month.JUNE,11)

            );
            repository.saveAll(List.of(Kulesh,KalEl));
        };
    }
}
