package pe.com.bikerent.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.bikerent.backend.entities.Plan;

public interface PlanRepository extends JpaRepository<Plan,Long> {
}
