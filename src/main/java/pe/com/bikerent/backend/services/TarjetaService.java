package pe.com.bikerent.backend.services;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pe.com.bikerent.backend.entities.Tarjeta;

import java.util.List;

public interface TarjetaService {
    public Tarjeta createTarjetaS(Tarjeta tarjeta);
    public Tarjeta updateTarjetaByIdS(Long id, Tarjeta tarjeta);
    public List<Tarjeta> getAllTarjetasS();
    public Tarjeta getTarjetaByIdS(Long id);
}
