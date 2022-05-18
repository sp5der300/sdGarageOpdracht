package nl.bd.sdbackendeindopdracht.repos;

import nl.bd.sdbackendeindopdracht.models.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments, Long> {
}
