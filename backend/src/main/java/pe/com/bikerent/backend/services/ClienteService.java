package pe.com.bikerent.backend.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pe.com.bikerent.backend.entities.Cliente;

import java.util.List;

public interface ClienteService {
    public Cliente updateClienteByIdS(Long id, Cliente cliente);
    public void deleteClienteByIdS(Long id);
    public List<Cliente> getAllClientesS();
    public List<Cliente> getAllClientesAndAlquileresS();
    public Cliente getClienteByIdS(Long id);
    public List<Cliente> getClienteByDireccionS(String direccion);
    public Cliente getClienteByDniS(String dni);
    public Cliente getClienteByNombreS(String nombre);
    public Cliente getClienteByCorreoS(String correo);
}
