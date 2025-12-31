package com.universitysystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.universitysystem.model.Module;
import com.universitysystem.model.Registration;
import com.universitysystem.model.Student;
import com.universitysystem.service.UniversityService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityService universityService;

    // ========== STUDENT ENDPOINTS ==========

    @PostMapping("/students")
    public ResponseEntity createStudent(@RequestBody Student student) {
        Student created = universityService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/students")
    public ResponseEntity<List> getAllStudents() {
        return ResponseEntity.ok(universityService.getAllStudents());
    }

    @GetMapping("/students/{id}")
    public ResponseEntity getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(universityService.getStudentById(id));
    }

    // ========== MODULE ENDPOINTS ==========

    @PostMapping("/modules")
    public ResponseEntity createModule(@RequestBody Module module) {
        Module created = universityService.createModule(module);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/modules")
    public ResponseEntity<List> getAllModules() {
        return ResponseEntity.ok(universityService.getAllModules());
    }

    // ========== REGISTRATION ENDPOINTS ==========

    @PostMapping("/registrations")
    public ResponseEntity registerStudent(
            @RequestParam Long studentId,
            @RequestParam Long moduleId,
            @RequestParam String semester) {
        Registration registration = universityService.registerStudentForModule(
                studentId, moduleId, semester);
        return ResponseEntity.status(HttpStatus.CREATED).body(registration);
    }

    @PutMapping("/registrations/{id}/mark")
    public ResponseEntity updateMark(
            @PathVariable Long id,
            @RequestParam Double mark) {
        Registration updated = universityService.updateMark(id, mark);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/students/{studentId}/registrations")
    public ResponseEntity<List> getStudentRegistrations(
            @PathVariable Long studentId) {
        return ResponseEntity.ok(universityService.getStudentRegistrations(studentId));
    }

    @GetMapping("/modules/{moduleId}/registrations")
    public ResponseEntity<List> getModuleRegistrations(
            @PathVariable Long moduleId) {
        return ResponseEntity.ok(universityService.getModuleRegistrations(moduleId));
    }
}