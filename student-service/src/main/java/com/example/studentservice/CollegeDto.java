package com.example.studentservice;

// Holds the college data we receive from college-service
public record CollegeDto(Long id, String name, String city) {
}
