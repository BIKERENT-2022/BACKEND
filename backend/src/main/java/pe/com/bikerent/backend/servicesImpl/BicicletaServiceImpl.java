package pe.com.bikerent.backend.servicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.bikerent.backend.entities.Bicicleta;
import pe.com.bikerent.backend.entities.Empresa;
import pe.com.bikerent.backend.exceptions.ResourceNotFoundException;
import pe.com.bikerent.backend.repositories.BicicletaRepository;
import pe.com.bikerent.backend.services.BicicletaService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BicicletaServiceImpl implements BicicletaService {

    @Autowired
    BicicletaRepository bicicletaRepository;

    @Transactional
    public Bicicleta createBicicletaS(Bicicleta bicicleta){
        Bicicleta newBicicleta = bicicletaRepository.save(new Bicicleta(
                bicicleta.getModelo(),
                bicicleta.getMarca(),
                bicicleta.getColor(),
                bicicleta.getTipo(),
                bicicleta.getImagen(),
                bicicleta.getEmpresa()));

        return newBicicleta;
    }

    @Transactional
    public Bicicleta updatebicicletasByIdS(Long id, Bicicleta bicicleta){
        Bicicleta foundBicicleta = bicicletaRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found bicicleta with id="+id));

        if (bicicleta.getModelo()!=null)
            foundBicicleta.setModelo(bicicleta.getModelo());
        if (bicicleta.getMarca()!=null)
            foundBicicleta.setMarca(bicicleta.getMarca());
        if (bicicleta.getColor()!=null)
            foundBicicleta.setColor(bicicleta.getColor());
        if (bicicleta.getTipo()!=null)
            foundBicicleta.setTipo(bicicleta.getTipo());
        if (bicicleta.getImagen()!=null)
            foundBicicleta.setImagen(bicicleta.getImagen());
        if (bicicleta.getEmpresa()!=null)
            foundBicicleta.setEmpresa(bicicleta.getEmpresa());

        Bicicleta foundBicicleta1 = bicicletaRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found bicicleta with id="+id));
        foundBicicleta1.setAlquileres(null);

        Bicicleta updatedBicicleta = bicicletaRepository.save(foundBicicleta);
        return updatedBicicleta;
    }

    @Transactional
    public void deleteBicicletaByIdS(Long id){
        bicicletaRepository.deleteById(id);
    }

    public List<Bicicleta> getAllBicicletasS(){
        List<Bicicleta> bicicletas = bicicletaRepository.findAll();
        for (Bicicleta b : bicicletas) {
            //b.setEmpresa(null);
            //b.setAlquileres(null);
        }
        return bicicletas;
    }

    public Bicicleta getBicicletaByIdS(Long id){
        Bicicleta bicicleta = bicicletaRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found bicicleta with id="+id));;
        //bicicleta.getEmpresa().setBicicletas(null);
        //bicicleta.setAlquileres(null);
        return bicicleta;
    }

    public List<Bicicleta> getAllBicicletasByModeloS(String modelo){
        List<Bicicleta> bicicletas = bicicletaRepository.findByModeloSQL(modelo);
        for (Bicicleta b : bicicletas) {
            //b.setEmpresa(null);
            //b.setAlquileres(null);
        }
        return bicicletas;
    }

    public List<Bicicleta> getAllBicicletasByMarcaS(String marca){
        List<Bicicleta> bicicletas = bicicletaRepository.findByMarcaSQL(marca);
        for (Bicicleta b : bicicletas) {
            //b.setEmpresa(null);
            //b.setAlquileres(null);
        }
        return bicicletas;
    }

    public List<Bicicleta> getAllBicicletasByColorS(String color){
        List<Bicicleta> bicicletas = bicicletaRepository.findByColorSQL(color);
        for (Bicicleta b : bicicletas) {
            //b.setEmpresa(null);
            //b.setAlquileres(null);
        }
        return bicicletas;
    }

    public List<Bicicleta> getAllBicicletasByTipoS(String tipo){
        List<Bicicleta> bicicletas = bicicletaRepository.findByTipoSQL(tipo);
        for (Bicicleta b : bicicletas) {
            //b.setEmpresa(null);
            //b.setAlquileres(null);
        }
        return bicicletas;
    }
}
