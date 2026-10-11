package com.example.studentservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// "college-service" is the name registered in Eureka (naming server)
@FeignClient(name = "college-service")
public interface CollegeClient {

    @GetMapping("/colleges/{id}")
    CollegeDto getCollegeById(@PathVariable("id") Long id);
}
