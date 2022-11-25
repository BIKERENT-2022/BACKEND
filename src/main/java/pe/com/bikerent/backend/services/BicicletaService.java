package pe.com.bikerent.backend.services;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pe.com.bikerent.backend.entities.Bicicleta;
import java.util.List;

public interface BicicletaService {
    public Bicicleta createBicicletaS(Bicicleta bicicleta);
    public Bicicleta updatebicicletasByIdS(Long id, Bicicleta bicicleta);
    public void deleteBicicletaByIdS(Long id);
    public List<Bicicleta> getAllBicicletasS();
    public Bicicleta getBicicletaByIdS(Long id);
    public List<Bicicleta> getAllBicicletasByModeloS(String modelo);
    public List<Bicicleta> getAllBicicletasByMarcaS(String marca);
    public List<Bicicleta> getAllBicicletasByColorS(String color);
    public List<Bicicleta> getAllBicicletasByTipoS(String tipo);
}
