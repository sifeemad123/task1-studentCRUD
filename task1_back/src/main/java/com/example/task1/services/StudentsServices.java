package com.example.task1.services;

import com.example.task1.DTOs.StudentDTO;
import com.example.task1.entities.StudentEntity;
import com.example.task1.repos.StudentsRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Request;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentsServices {
    private final StudentsRepo studentsRepo;

    public List<StudentEntity> getAllStudents(){
        log.info("Requist To Retrieving All Students");
        List<StudentEntity> students = studentsRepo.findAll();
        if(students.isEmpty()){
            log.warn("No Students Found");
            return new ArrayList<>();
        }
        log.info("Retrieved All Students Successfully");
        return students;
    }

    public HttpStatus createStudents(StudentDTO student){
        log.info("Requist To Creating Student");
        if(studentsRepo.existsByEmail(student.getEmail())){
            log.warn("Student Already Exists");
            return HttpStatus.CONFLICT;
        }
        StudentEntity newStudent = new StudentEntity();
        newStudent.setEmail(student.getEmail());
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setPassword(student.getPassword());
        studentsRepo.save(newStudent);
        log.info("Student Created Successfully");
        return HttpStatus.CREATED;
    }

    public HttpStatus deleteStudent(Long id){
        log.info("Requist To Delete Student");
        if(studentsRepo.existsById(id)){
            log.info("Student Deleted Successfully");
            studentsRepo.deleteById(id);
            return HttpStatus.OK;
        }
        log.info("Student Not Found");
        return HttpStatus.NOT_FOUND;
    }

    public HttpStatus updateStudent(Long id, StudentDTO student){
        log.info("Requist To Update Student");
        if(studentsRepo.existsById(id)){
            log.info("Student Updated Successfully");
            StudentEntity updatedStudent = studentsRepo.findById(id).get();
            updatedStudent.setFirstName(student.getFirstName());
            updatedStudent.setLastName(student.getLastName());
            updatedStudent.setPassword(student.getPassword());
            updatedStudent.setEmail(student.getEmail());
            log.info("Student Updated Successfully");
            studentsRepo.save(updatedStudent);
            return HttpStatus.OK;
        }
        log.info("Student Not Found");
        return HttpStatus.NOT_FOUND;
    }
}
