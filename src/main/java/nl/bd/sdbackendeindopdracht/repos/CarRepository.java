package nl.bd.sdbackendeindopdracht.repos;

import nl.bd.sdbackendeindopdracht.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
