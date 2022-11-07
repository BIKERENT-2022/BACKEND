package pe.com.bikerent.backend.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import pe.com.bikerent.backend.entities.Alquiler;
import pe.com.bikerent.backend.exceptions.ResourceNotFoundException;
import pe.com.bikerent.backend.repositories.AlquilerRepository;
import pe.com.bikerent.backend.services.AlquilerService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AlquilerServiceImpl implements AlquilerService {

    @Autowired
    AlquilerRepository alquilerRepository;


    @Transactional
    public Alquiler save(Alquiler alquiler){
        Alquiler newAlquiler = alquilerRepository.save(new Alquiler(
                alquiler.getPlazo(),
                alquiler.getFecha(),
                alquiler.getHora(),
                alquiler.getCliente(),
                alquiler.getBicicleta(),
                alquiler.getEstadoAlquiler(),
                alquiler.getDelivery()));
        return newAlquiler;
    }

    @Transactional
    public Alquiler save2(Alquiler foundCliente){
        Alquiler updatedAlquiler = alquilerRepository.save(foundCliente);
        return updatedAlquiler;
    }

    @Transactional
    public void deleteAlquilerByIdS(Long id){
        alquilerRepository.deleteById(id);
    }

    public List<Alquiler> getAllAlquileresS(){
        List<Alquiler> alquileres = alquilerRepository.findAll();
        for (Alquiler a : alquileres) {
            a.getCliente().setAlquileres(null);
            a.getBicicleta().setEmpresa(null);
            a.getBicicleta().setAlquileres(null);
        }
        return alquileres;
    }

    public Alquiler getAlquilerByIdS(Long id){
        Alquiler alquiler = alquilerRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found Alquiler with id="+id));

        alquiler.getCliente().setAlquileres(null);
        alquiler.getBicicleta().setEmpresa(null);
        alquiler.getBicicleta().setAlquileres(null);

        return alquiler;
    }


}