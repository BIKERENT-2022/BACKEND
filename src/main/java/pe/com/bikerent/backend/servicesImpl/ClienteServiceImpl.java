package pe.com.bikerent.backend.servicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.bikerent.backend.entities.Alquiler;
import pe.com.bikerent.backend.entities.Cliente;
import pe.com.bikerent.backend.exceptions.ResourceNotFoundException;
import pe.com.bikerent.backend.repositories.ClienteRepository;
import pe.com.bikerent.backend.services.ClienteService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    @Transactional
    public Cliente updateClienteByIdS(Long id, Cliente cliente){
        Cliente foundCliente = clienteRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found Cliente with id="+id));

        if (cliente.getDni()!=null)
            foundCliente.setDni(cliente.getDni());
        if (cliente.getNombre()!=null)
            foundCliente.setNombre(cliente.getNombre());
        if (cliente.getCorreo()!=null)
            foundCliente.setCorreo(cliente.getCorreo());
        if (cliente.getDireccion()!=null)
            foundCliente.setDireccion(cliente.getDireccion());
        if (cliente.getTelefono()!=null)
            foundCliente.setTelefono(cliente.getTelefono());
        if (cliente.getImagen()!=null)
            foundCliente.setImagen(cliente.getImagen());

        Cliente foundCliente1 = clienteRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found bicicleta with id="+id));
        foundCliente1.setAlquileres(null);

        Cliente updatedCliente = clienteRepository.save(foundCliente);
        return updatedCliente;
    }

    @Transactional
    public void deleteClienteByIdS(Long id){
        clienteRepository.deleteById(id);
    }

    public List<Cliente> getAllClientesS(){
        List<Cliente> clientes = clienteRepository.findAll();
        for (Cliente c : clientes) {
            c.setAlquileres(null);
        }
        return clientes;
    }

    public List<Cliente> getAllClientesAndAlquileresS(){
        List<Cliente> clientes = clienteRepository.findAll();
        for (Cliente c : clientes) {
            for (Alquiler a : c.getAlquileres()) {
                a.setCliente(null);
                a.setBicicleta(null);
            }
        }
        return clientes;
    }

    public Cliente getClienteByIdS(Long id){
        Cliente cliente = clienteRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found cliente with id="+id));;
        cliente.setAlquileres(null);
        return cliente;
    }

    public List<Cliente> getClienteByDireccionS(String direccion){
        List<Cliente> clientes = clienteRepository.findByDireccionContaining(direccion);
        for (Cliente c : clientes) {
            c.setAlquileres(null);
        }
        return clientes;
    }

    public Cliente getClienteByDniS(String dni){
        Cliente cliente = clienteRepository.findByDNISQL(dni);
        cliente.setAlquileres(null);
        return cliente;
    }

    public Cliente getClienteByNombreS(String nombre){
        Cliente cliente = clienteRepository.findByRUCJPQL(nombre);
        cliente.setAlquileres(null);
        return cliente;
    }

    public Cliente getClienteByCorreoS(String correo){
        Cliente cliente = clienteRepository.findByCorreoSQL(correo);
        cliente.setAlquileres(null);
        return cliente;
    }

}
