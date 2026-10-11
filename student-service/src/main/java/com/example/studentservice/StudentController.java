package com.example.studentservice;

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
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;
    private final CollegeClient collegeClient;

    public StudentController(StudentRepository studentRepository, CollegeClient collegeClient) {
        this.studentRepository = studentRepository;
        this.collegeClient = collegeClient;
    }

    // GET /students -> all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // GET /students/1 -> one student
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return findStudent(id);
    }

    // POST /students -> add a student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // GET /students/1/details -> student + college (calls college-service)
    @GetMapping("/{id}/details")
    public StudentDetailsResponse getStudentDetails(@PathVariable Long id) {
        Student student = findStudent(id);
        CollegeDto college = collegeClient.getCollegeById(student.getCollegeId());
        return new StudentDetailsResponse(student.getId(), student.getName(), student.getCourse(), college);
    }

    private Student findStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }
}
