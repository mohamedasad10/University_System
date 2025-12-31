package com.universitysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universitysystem.model.Module;

import java.util.Optional;

public interface ModuleRepository extends JpaRepository<Module, Long> {
    Optional<Module> findByModuleCode(String moduleCode);
}