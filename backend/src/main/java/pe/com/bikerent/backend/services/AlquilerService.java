package pe.com.bikerent.backend.services;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pe.com.bikerent.backend.entities.Alquiler;
import java.util.List;

public interface AlquilerService {

    public Alquiler save(Alquiler alquiler);
    public Alquiler save2(Alquiler foundCliente);
    public void deleteAlquilerByIdS(Long id);
    public List<Alquiler> getAllAlquileresS();
    public Alquiler getAlquilerByIdS(Long id);
}
