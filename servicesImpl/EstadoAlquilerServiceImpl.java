package pe.com.bikerent.backend.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.bikerent.backend.entities.EstadoAlquiler;
import pe.com.bikerent.backend.repositories.EstadoAlquilerRepository;
import pe.com.bikerent.backend.services.EstadoAlquilerService;

import java.util.List;

@Service
public class EstadoAlquilerServiceImpl implements EstadoAlquilerService {
    @Autowired
    EstadoAlquilerRepository estadoAlquilerRepository;


    public List<EstadoAlquiler> getAllEstadosAlquileresS(){
        List<EstadoAlquiler> estados = estadoAlquilerRepository.findAll();
        return estados;
    }
}
