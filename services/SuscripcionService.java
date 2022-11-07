package pe.com.bikerent.backend.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pe.com.bikerent.backend.entities.Suscripcion;

import java.util.List;

public interface SuscripcionService {
    public Suscripcion createSuscripcionS(Suscripcion suscripcion);
    public Suscripcion updateSuscripcionByIdS(Suscripcion foundSuscripcion);
    public void deleteSuscripcionByIdS(Long id);
    public List<Suscripcion> getAllSuscripcionesS();
    public Suscripcion getSuscripcionesByIdS(Long id);
}
