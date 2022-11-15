package pe.com.bikerent.backend.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.bikerent.backend.entities.Tarjeta;
import pe.com.bikerent.backend.exceptions.ResourceNotFoundException;
import pe.com.bikerent.backend.repositories.TarjetaRepository;
import pe.com.bikerent.backend.services.TarjetaService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TarjetaServiceImpl implements TarjetaService {
    @Autowired
    TarjetaRepository tarjetaRepository;


    @Transactional
    public Tarjeta createTarjetaS(Tarjeta tarjeta){
        Tarjeta newTarjeta = tarjetaRepository.save(new Tarjeta(
                tarjeta.getNumero(),
                tarjeta.getNombreCompleto(),
                tarjeta.getFechaCaducidad(),
                tarjeta.getCvv()));

        return newTarjeta;
    }

    @Transactional
    public Tarjeta updateTarjetaByIdS(Long id, Tarjeta tarjeta){
        Tarjeta foundTarjeta = tarjetaRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found Tarjeta with id="+id));

        if (tarjeta.getNumero()!=null)
            foundTarjeta.setNumero(tarjeta.getNumero());
        if (tarjeta.getNombreCompleto()!=null)
            foundTarjeta.setNombreCompleto(tarjeta.getNombreCompleto());
        if (tarjeta.getFechaCaducidad()!=null)
            foundTarjeta.setFechaCaducidad(tarjeta.getFechaCaducidad());
        if (tarjeta.getCvv()!=null)
            foundTarjeta.setCvv(tarjeta.getCvv());

        Tarjeta updatedTarjeta = tarjetaRepository.save(foundTarjeta);
        return updatedTarjeta;
    }

    public List<Tarjeta> getAllTarjetasS(){
        List<Tarjeta> tarjetas = tarjetaRepository.findAll();
        return tarjetas;
    }

    public Tarjeta getTarjetaByIdS(Long id){
        Tarjeta tarjeta = tarjetaRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found tarjeta with id="+id));;
        return tarjeta;
    }
}
