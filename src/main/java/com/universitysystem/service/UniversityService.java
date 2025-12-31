package com.universitysystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.universitysystem.model.Module;
import com.universitysystem.model.Registration;
import com.universitysystem.model.Student;
import com.universitysystem.repository.ModuleRepository;
import com.universitysystem.repository.RegistrationRepository;
import com.universitysystem.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UniversityService {
    
    private final StudentRepository studentRepository;
    private final ModuleRepository moduleRepository;
    private final RegistrationRepository registrationRepository;
    
    // ========== STUDENT OPERATIONS ==========
    
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    
    public List<Student> getAllStudents() {  
        return studentRepository.findAll();
    }
    
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }
    
    // ========== MODULE OPERATIONS ==========
    
    public Module createModule(Module module) {
        return moduleRepository.save(module);
    }
    
    public List<Module> getAllModules() {  
        return moduleRepository.findAll();
    }
    
    public Module getModuleById(Long id) {
        return moduleRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Module not found with id: " + id));
    }
    
    // ========== REGISTRATION OPERATIONS ==========
    
    public Registration registerStudentForModule(Long studentId, Long moduleId, String semester) {
        Student student = getStudentById(studentId);
        Module module = getModuleById(moduleId);
        
        // Check if already registered
        registrationRepository.findByStudentIdAndModuleId(studentId, moduleId)
            .ifPresent(r -> {
                throw new RuntimeException("Student already registered for this module");
            });
        
        Registration registration = new Registration();
        registration.setStudent(student);
        registration.setModule(module);
        registration.setSemester(semester);
        
        return registrationRepository.save(registration);
    }
    
    public Registration updateMark(Long registrationId, Double mark) {
        Registration registration = registrationRepository.findById(registrationId)
            .orElseThrow(() -> new RuntimeException("Registration not found"));
        
        registration.setMark(mark);
        return registrationRepository.save(registration);
    }
    
    public List<Registration> getStudentRegistrations(Long studentId) {  
        return registrationRepository.findByStudentId(studentId);
    }
    
    public List<Registration> getModuleRegistrations(Long moduleId) {  
        return registrationRepository.findByModuleId(moduleId);
    }
}