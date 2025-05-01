package com.caching.services;

import com.caching.entities.Student;

import java.util.List;

public interface StudentService {
    public Student add(Student student);
    public Student get(int id);
    public List<Student> getAll();
    public Student update(int id, Student student);
    public void delete(int id);
}
