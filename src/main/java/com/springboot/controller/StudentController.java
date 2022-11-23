package com.springboot.controller;

import com.springboot.model.Student;
import com.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// contents of this method are to be exposed as REST endpoints
@RestController
public class StudentController {

    @Autowired
    StudentService service;

    // creates end point of "/students"
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        // fetch all the students
        
        List<Student> re = service.getAllStudents();
        
        return new ResponseEntity(re, HttpStatus.OK);
    }
}
