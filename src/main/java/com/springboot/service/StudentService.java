package com.springboot.service;

import com.springboot.model.Student;
import com.springboot.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// business logic goes in services
@Service
public class StudentService {

    @Autowired
    StudentRepository repo;

    public List<Student> getAllStudents(){

        List<Student> studentList = repo.findAll();

        //repo.findByName("B");
        //repo.findByNameAndId("B", 2);

        return studentList;
    }
}
