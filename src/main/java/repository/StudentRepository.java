package repository;

import model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StudentRepository extends JpaRepository {
    Optional findByStudentNumber(String studentNumber);
    Optional findByEmail(String email);
}