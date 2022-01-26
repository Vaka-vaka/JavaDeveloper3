package ua.goit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.goit.model.Developers;

@Repository
public interface UserRepository extends JpaRepository<Developers, Long> {
}
