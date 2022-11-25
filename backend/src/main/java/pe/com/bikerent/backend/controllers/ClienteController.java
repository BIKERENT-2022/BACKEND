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
import pe.com.bikerent.backend.exporters.ClientesExporterExcel;
import pe.com.bikerent.backend.repositories.ClienteRepository;
import pe.com.bikerent.backend.repositories.EmpresaRepository;
import pe.com.bikerent.backend.services.ClienteService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;


    /*----------------------------------------------------- ACTUALIZAR CLIENTE -----------------------------------------------------*/
    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> updateClienteById(@PathVariable("id") Long id, @RequestBody Cliente cliente)
    {

        Cliente foundCliente = clienteService.updateClienteByIdS(id, cliente);
        return new ResponseEntity<Cliente>(foundCliente, HttpStatus.OK);

        /*
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
        return new ResponseEntity<Cliente>(updatedCliente, HttpStatus.OK);
        */
    }



    /* ---------------------- BORRAR CLIENTE SEGUN EL ID --------------------- */
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<HttpStatus>deleteClienteById(@PathVariable("id") Long id){
        clienteService.deleteClienteByIdS(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    /*----------------------------------------------------- LISTAS CLIENTES -----------------------------------------------------*/
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAllClientes(){

        List<Cliente> clientes = clienteService.getAllClientesS();
        if(clientes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);

        /*
        List<Cliente> clientes = clienteRepository.findAll();
        if(clientes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Cliente c : clientes) {
            c.setAlquileres(null);
        }
        return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);
        */
    }


    /*----------------------------------------------------- LISTA DE CLIENTES CON SUS ALQUILERES -----------------------------------------------------*/
    @GetMapping("/clientes/alquileres")
    public ResponseEntity<List<Cliente>> getAllClientesAndAlquileres(){
        List<Cliente> clientes = clienteService.getAllClientesAndAlquileresS();
        if(clientes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);

        /*
        List<Cliente> clientes = clienteRepository.findAll();
        if(clientes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Cliente c : clientes) {
            for (Alquiler a : c.getAlquileres()) {
                a.setCliente(null);
                a.setBicicleta(null);
            }
        }
        return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);
        */
    }



    /* ---------------------- MOSTRAR CLIENTE SEGUN EL ID --------------------- */
    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable("id") Long id){
        Cliente cliente = clienteService.getClienteByIdS(id);
        return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);

        /*
        Cliente cliente = clienteRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found cliente with id="+id));;
        cliente.setAlquileres(null);
        return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
        */
    }



    /*---------------------- MOSTRAR CLIENTE SEGUN DIRECCION ---------------------*/
    @GetMapping("/clientes/direccion/{direccion}")
    public ResponseEntity<List<Cliente>> getClienteByDireccion(@PathVariable("direccion") String direccion){
        List<Cliente> clientes = clienteService.getClienteByDireccionS(direccion);
        if (clientes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);

        /*
        List<Cliente> clientes = clienteRepository.findByDireccionContaining(direccion);
        if (clientes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Cliente c : clientes) {
            c.setAlquileres(null);
        }
        return new ResponseEntity<List<Cliente>>(clientes,HttpStatus.OK);
        */
    }


    /*---------------------- MOSTRAR CLIENTE SEGUN DNI ---------------------*/
    @GetMapping("/clientes/dni/{dni}")
    public ResponseEntity<Cliente> getClienteByDni(@PathVariable("dni") String dni){
        Cliente cliente = clienteService.getClienteByDniS(dni);
        return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);

        /*
        Cliente cliente = clienteRepository.findByDNISQL(dni);
        cliente.setAlquileres(null);
        return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
        */
    }


    /*---------------------- MOSTRAR CLIENTE SEGUN NOMBRE ---------------------*/
    @GetMapping("/clientes/nombre/{nombre}")
    public ResponseEntity<Cliente> getClienteByNombre(@PathVariable("nombre") String nombre){
        Cliente cliente = clienteService.getClienteByNombreS(nombre);
        return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);

        /*
        Cliente cliente = clienteRepository.findByRUCJPQL(nombre);
        cliente.setAlquileres(null);
        return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
        */
    }


    /*---------------------- MOSTRAR CLIENTE SEGUN CORREO ---------------------*/
    @GetMapping("/clientes/correo/{correo}")
    public ResponseEntity<Cliente> getClienteByCorreo(@PathVariable("correo") String correo){
        Cliente cliente = clienteService.getClienteByCorreoS(correo);
        return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);

        /*
        Cliente cliente = clienteRepository.findByCorreoSQL(correo);
        cliente.setAlquileres(null);
        return new ResponseEntity<Cliente>(cliente,HttpStatus.OK);
        */
    }





    @GetMapping("/clientes/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=employee_report";
        response.setHeader(headerKey,headerValue);

        List<Cliente> cliente;
        cliente = clienteRepository.findAll();

        ClientesExporterExcel exporterExcel = new ClientesExporterExcel(cliente);
        exporterExcel.export(response);
    }



}