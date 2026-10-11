package com.example.collegeservice;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

    private final CollegeRepository collegeRepository;

    public CollegeController(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    // GET /colleges  -> all colleges
    @GetMapping
    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    // GET /colleges/1  -> one college
    @GetMapping("/{id}")
    public College getCollegeById(@PathVariable Long id) {
        return collegeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "College not found"));
    }

    // POST /colleges  -> add a college
    @PostMapping
    public College addCollege(@RequestBody College college) {
        return collegeRepository.save(college);
    }
}
