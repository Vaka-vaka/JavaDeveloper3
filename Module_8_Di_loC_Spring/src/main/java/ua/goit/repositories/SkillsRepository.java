package ua.goit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.goit.model.Skills;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Long> {
}
