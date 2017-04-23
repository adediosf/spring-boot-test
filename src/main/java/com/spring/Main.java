package com.spring;

import com.spring.dao.EmployeeRepository;
import com.spring.dao.SalaryRepository;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;


/**
 * Created by test on 23.04.17.
 */
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner init( SalaryRepository salaryRepository){
        System.out.println("Init here");
        return null ;
//        return (evt) -> Arrays.asList("Siamak,DeForest,Navin,Dekang,Berhard,Zito,Patricia,Sachin".split(",")).
//                forEach(a -> { System.out.println(salaryRepository.findByEmployeeFirstName(a)); });
    }

}
