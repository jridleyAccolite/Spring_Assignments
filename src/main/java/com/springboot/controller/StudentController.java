package com.springboot.controller;

import com.springboot.model.Student;
import com.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/addstudent")
    public String addStudent(@RequestBody Student student){
        return service.addStudent(student);
    }

    @PutMapping("/student/{studentId}")
    public String updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student student){
        return service.updateStudent(studentId, student);
    }

    @DeleteMapping("/delete/{rollno}")
    public String deleteStudent(@PathVariable("rollno") int rollno){
        return service.deleteStudent(rollno);
    }
}
