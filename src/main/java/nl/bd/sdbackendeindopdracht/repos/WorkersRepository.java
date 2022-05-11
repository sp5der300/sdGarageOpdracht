package nl.bd.sdbackendeindopdracht.repos;

import nl.bd.sdbackendeindopdracht.models.Workers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkersRepository extends JpaRepository<Workers, Long> {
}
