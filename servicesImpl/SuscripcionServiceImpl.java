package pe.com.bikerent.backend.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.bikerent.backend.entities.Suscripcion;
import pe.com.bikerent.backend.exceptions.ResourceNotFoundException;
import pe.com.bikerent.backend.repositories.SuscripcionesRepository;
import pe.com.bikerent.backend.services.SuscripcionService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SuscripcionServiceImpl implements SuscripcionService {
    @Autowired
    SuscripcionesRepository suscripcionesRepository;

    @Transactional
    public Suscripcion createSuscripcionS(Suscripcion suscripcion){
        Suscripcion newSuscripcion = suscripcionesRepository.save(new Suscripcion(
                suscripcion.getTarjeta(),
                suscripcion.getPlan(),
                suscripcion.getUsuario(),
                suscripcion.getFechaInicio(),
                suscripcion.getFechaFin()));


        return newSuscripcion;
    }

    @Transactional
    public Suscripcion updateSuscripcionByIdS(Suscripcion foundSuscripcion){
        Suscripcion updatedSuscripcion = suscripcionesRepository.save(foundSuscripcion);
        return updatedSuscripcion;
    }

    @Transactional
    public void deleteSuscripcionByIdS(Long id){
        suscripcionesRepository.deleteById(id);
    }

    public List<Suscripcion> getAllSuscripcionesS(){
        List<Suscripcion> suscripciones = suscripcionesRepository.findAll();
        return suscripciones;
    }

    public Suscripcion getSuscripcionesByIdS(Long id){
        Suscripcion suscripcion = suscripcionesRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found Suscripcion with id="+id));;
        return suscripcion;
    }

}
