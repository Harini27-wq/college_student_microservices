package com.example.studentservice;

// What we send back: student info + the full college info
public record StudentDetailsResponse(Long id, String name, String course, CollegeDto college) {
}
