package pe.com.bikerent.backend.servicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.bikerent.backend.entities.Plan;
import pe.com.bikerent.backend.repositories.PlanRepository;
import pe.com.bikerent.backend.services.PlanService;
import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    PlanRepository planRepository;

    public List<Plan> getAllPlanesS(){
        List<Plan> planes = planRepository.findAll();
        return planes;
    }
}
