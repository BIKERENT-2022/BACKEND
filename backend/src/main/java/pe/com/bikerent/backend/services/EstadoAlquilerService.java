package pe.com.bikerent.backend.services;

import org.springframework.http.ResponseEntity;
import pe.com.bikerent.backend.entities.EstadoAlquiler;

import java.util.List;

public interface EstadoAlquilerService {
    public List<EstadoAlquiler> getAllEstadosAlquileresS();
}
