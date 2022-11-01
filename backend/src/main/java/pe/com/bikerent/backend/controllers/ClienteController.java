package pe.com.bikerent.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.bikerent.backend.entities.Alquiler;
import pe.com.bikerent.backend.entities.Bicicleta;
import pe.com.bikerent.backend.entities.Cliente;
import pe.com.bikerent.backend.entities.Empresa;
import pe.com.bikerent.backend.exceptions.ResourceNotFoundException;
import pe.com.bikerent.backend.repositories.ClienteRepository;
import pe.com.bikerent.backend.repositories.EmpresaRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;


    /*----------------------------------------------------- ACTUALIZAR CLIENTE -----------------------------------------------------*/
    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> updateClienteById(@PathVariable("id") Long id, @RequestBody Cliente cliente) {

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

        Cliente updatedCliente = clienteRepository.save(foundCliente);
        return new ResponseEntity<Cliente>(updatedCliente, HttpStatus.OK);
    }


    //---------------------- MOSTRAR EMPRESA SEGUN EL ID ---------------------
    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Long id){
        Cliente cliente = clienteRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found cliente with id="+id));;
        cliente.setAlquileres(null);
        return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
    }


    /*----------------------------------------------------- LISTAS CLIENTES -----------------------------------------------------*/
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAllClientes(){
        List<Cliente> clientes = clienteRepository.findAll();
        if(clientes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Cliente c : clientes) {
            c.setAlquileres(null);
            //for (Bicicleta b : c.getBicicletas()) {
                //b.setAlquileres(null);
              //  b.setEmpresa(null);
            //}
        }
        return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);
    }


    /*----------------------------------------------------- LISTA DE CLIENTES CON SUS ALQUILERES -----------------------------------------------------*/
    @GetMapping("/clientes/alquileres")
    public ResponseEntity<List<Cliente>> getAllClientesAndAlquileres(){
        List<Cliente> clientes = clienteRepository.findAll();
        if(clientes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Cliente c : clientes) {
            for (Alquiler a : c.getAlquileres()) {
                /*a.set
                a.setEmpresa(null);*/
            }
        }
        return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);
    }








    /*---------------------- MOSTRAR CLIENTE SEGUN DIRECCION ---------------------*/
    @GetMapping("/clientes/direccion/{direccion}")
    public ResponseEntity<List<Cliente>> getClienteByDireccion(@PathVariable("direccion") String direccion){
        List<Cliente> clientes = clienteRepository.findByDireccionContaining(direccion);
        for (Cliente c : clientes) {
            c.setAlquileres(null);
        }
        return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);
    }


    /*---------------------- MOSTRAR CLIENTE SEGUN DNI ---------------------*/
    @GetMapping("/clientes/dni/{dni}")
    public ResponseEntity<Cliente> getClienteByDni(@PathVariable("dni") String dni){
        Cliente cliente = clienteRepository.findByDNISQL(dni);
        cliente.setAlquileres(null);
        return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
    }


    /*---------------------- MOSTRAR CLIENTE SEGUN NOMBRE ---------------------*/
    @GetMapping("/clientes/nombre/{nombre}")
    public ResponseEntity<Cliente> getClienteByNombre(@PathVariable("nombre") String nombre){
        Cliente cliente = clienteRepository.findByRUCJPQL(nombre);
        cliente.setAlquileres(null);
        return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
    }


    /*---------------------- MOSTRAR CLIENTE SEGUN CORREO ---------------------*/
    @GetMapping("/clientes/correo/{correo}")
    public ResponseEntity<Cliente> getClienteByCorreo(@PathVariable("correo") String correo){
        Cliente cliente = clienteRepository.findByCorreoSQL(correo);
        cliente.setAlquileres(null);
        return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
    }

}