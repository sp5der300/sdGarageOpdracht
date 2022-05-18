package nl.bd.sdbackendeindopdracht.repos;

import nl.bd.sdbackendeindopdracht.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
