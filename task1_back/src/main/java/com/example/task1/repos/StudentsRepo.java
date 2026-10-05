package com.example.task1.repos;

import com.example.task1.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepo extends JpaRepository<StudentEntity, Long> {
    String findByEmail(String email);
    boolean existsByEmail(String email);
}
