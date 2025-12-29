package repository;

import model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByStudentId(Long studentId);

    List<Registration> findByModuleId(Long moduleId);

    Optional<Registration> findByStudentIdAndModuleId(Long studentId, Long moduleId);
}