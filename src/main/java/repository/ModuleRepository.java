package repository;

import model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ModuleRepository extends JpaRepository {
    Optional findByModuleCode(String moduleCode);
}