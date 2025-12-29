package repository;

import model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface RegistrationRepository extends JpaRepository {
    List findByStudentId(Long studentId);
    List findByModuleId(Long moduleId);
    Optional findByStudentIdAndModuleId(Long studentId, Long moduleId);
}