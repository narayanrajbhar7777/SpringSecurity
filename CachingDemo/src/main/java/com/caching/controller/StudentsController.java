package com.caching.controller;

import com.caching.entities.Student;
import com.caching.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentsController {

    @Autowired
    private StudentService service;

    @PostMapping("/")
    public ResponseEntity<Student> get(@RequestBody Student student) {
        System.out.println(student.toString());
        return ResponseEntity.ok(service.add(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable("id") int id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable("id") int id, @RequestBody Student student) {
        return ResponseEntity.ok(service.update(id, student));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") int id) {
        service.delete(id);
    }

}
