package pe.com.bikerent.backend.servicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.bikerent.backend.entities.Bicicleta;
import pe.com.bikerent.backend.exceptions.ResourceNotFoundException;
import pe.com.bikerent.backend.repositories.BicicletaRepository;
import pe.com.bikerent.backend.services.BicicletaService;

import java.util.List;

@Service
public class BicicletaServiceImpl implements BicicletaService {

    @Autowired
    BicicletaRepository bicicletaRepository;

    public List<Bicicleta> getAllBicicletasS(){
        List<Bicicleta> bicicletas = bicicletaRepository.findAll();
        for (Bicicleta b : bicicletas) {
            b.setEmpresa(null);
            b.setAlquileres(null);
        }
        return bicicletas;
    }

    public Bicicleta getBicicletaByIdS(Long id){
        Bicicleta bicicleta = bicicletaRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found bicicleta with id="+id));;
        bicicleta.getEmpresa().setBicicletas(null);
        bicicleta.setAlquileres(null);
        return bicicleta;
    }

    public List<Bicicleta> getAllBicicletasByModeloS(String modelo){
        List<Bicicleta> bicicletas = bicicletaRepository.findByModeloSQL(modelo);
        for (Bicicleta b : bicicletas) {
            b.setEmpresa(null);
            b.setAlquileres(null);
        }
        return bicicletas;
    }

    public List<Bicicleta> getAllBicicletasByMarcaS(String marca){
        List<Bicicleta> bicicletas = bicicletaRepository.findByMarcaSQL(marca);
        for (Bicicleta b : bicicletas) {
            b.setEmpresa(null);
            b.setAlquileres(null);
        }
        return bicicletas;
    }

    public List<Bicicleta> getAllBicicletasByColorS(String color){
        List<Bicicleta> bicicletas = bicicletaRepository.findByColorSQL(color);
        for (Bicicleta b : bicicletas) {
            b.setEmpresa(null);
            b.setAlquileres(null);
        }
        return bicicletas;
    }

    public List<Bicicleta> getAllBicicletasByTipoS(String tipo){
        List<Bicicleta> bicicletas = bicicletaRepository.findByTipoSQL(tipo);
        for (Bicicleta b : bicicletas) {
            b.setEmpresa(null);
            b.setAlquileres(null);
        }
        return bicicletas;
    }
}
