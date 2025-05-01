package com.caching.services.impl;

import com.caching.entities.Student;
import com.caching.exceptions.StudentException;
import com.caching.repository.StudentRepository;
import com.caching.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @CachePut(value = "student", key = "#student.id")
    public Student add(Student student) {
        return studentRepository.save(student);
    }

    @Cacheable(value = "student", key = "#id")
    public Student get(int id) throws StudentException {
        return studentRepository.findById(id).orElseThrow(() -> new StudentException("No Student Found."));
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student update(int id, Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        Student oldStudent = null;
        if (optionalStudent.isPresent()) {
            oldStudent = optionalStudent.get();
            oldStudent.setFirstName(student.getFirstName());
            oldStudent.setLastName(student.getLastName());
            oldStudent.setEmail(student.getEmail());
            oldStudent.setPhoneNo(student.getPhoneNo());
            return studentRepository.save(oldStudent);
        } else {
            return oldStudent;
        }
    }

    @CacheEvict(value = "student", key = "#id")
    public void delete(int id) {
        studentRepository.deleteById(id);
    }
}
