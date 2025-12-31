package com.universitysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universitysystem.model.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByStudentNumber(String studentNumber);

    Optional<Student> findByEmail(String email);
}