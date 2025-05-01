package com.spring.security.controller;
import com.spring.security.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<Student> students = new ArrayList<>(
            List.of(
                    new Student(1, "Mukesh", 60),
                    new Student(2, "Rahul", 65)
            ));

    @GetMapping
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}