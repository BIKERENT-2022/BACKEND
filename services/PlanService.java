package pe.com.bikerent.backend.services;

import org.springframework.http.ResponseEntity;
import pe.com.bikerent.backend.entities.Plan;

import java.util.List;

public interface PlanService {
    public List<Plan> getAllPlanesS();
}
