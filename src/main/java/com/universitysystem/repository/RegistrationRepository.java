package com.universitysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universitysystem.model.Registration;

import java.util.List;
import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByStudentId(Long studentId);

    List<Registration> findByModuleId(Long moduleId);

    Optional<Registration> findByStudentIdAndModuleId(Long studentId, Long moduleId);
}