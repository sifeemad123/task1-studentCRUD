package com.example.task1.controllers;

import com.example.task1.DTOs.StudentDTO;
import com.example.task1.entities.StudentEntity;
import com.example.task1.services.StudentsServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/API/students")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class StudentsController {
    private final StudentsServices studentsServices;

    @GetMapping
    public List<StudentEntity> getAllStudents(){
        log.info("Request To Get All Students form Controller");
        List<StudentEntity> students = studentsServices.getAllStudents();
        return students;
    }

    @PostMapping
    public HttpStatus createStudent(@Valid @RequestBody StudentDTO student){
        log.info("Request To Create Student form Controller");
        HttpStatus newStudent = studentsServices.createStudents(student);
        log.info("Response To Create Student form Controller");
        return newStudent;
    }
    @PutMapping("/{id}")
    public HttpStatus updateStudent( @PathVariable Long id , @Valid @RequestBody StudentDTO student){
        log.info("Request To Update Student form Controller");
        HttpStatus updated =  studentsServices.updateStudent(id, student);
        log.info("Response To Update Student form Controller");
        return updated;
    }
    @DeleteMapping("/{id}")
    public HttpStatus deleteStudent(@PathVariable Long id){
        log.info("Request To Delete Student form Controller");
        HttpStatus newStudent = studentsServices.deleteStudent(id);
        log.info("Response To Delete Student form Controller");
        return newStudent;
    }
}
