package pe.com.bikerent.backend.controllers;

import com.sun.jdi.LongValue;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.bikerent.backend.entities.*;
import pe.com.bikerent.backend.exceptions.ResourceNotFoundException;
import pe.com.bikerent.backend.repositories.AlquilerRepository;
import pe.com.bikerent.backend.repositories.ClienteRepository;
import pe.com.bikerent.backend.services.AlquilerService;

import java.util.List;
import java.util.function.ToLongFunction;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class AlquilerController {

    /*@Autowired
    private AlquilerRepository alquilerRepository;*/
    @Autowired
    private AlquilerService alquilerService;



    /*----------------------------------------------------- CREAR ALQUILER -----------------------------------------------------*/
    @PostMapping("/alquileres")
    public ResponseEntity<Alquiler> createAlquiler(@RequestBody Alquiler alquiler) {

        Alquiler newAlquiler = alquilerService.createAlquilerS(new Alquiler(
                alquiler.getPlazo(),
                alquiler.getFecha(),
                alquiler.getHora(),
                alquiler.getCliente(),
                alquiler.getBicicleta(),
                alquiler.getEstadoAlquiler(),
                alquiler.getDelivery()));

        return new ResponseEntity<Alquiler>(newAlquiler, HttpStatus.CREATED);

        /*
        Alquiler newAlquiler = alquilerRepository.save(new Alquiler(
                alquiler.getPlazo(),
                alquiler.getFecha(),
                alquiler.getHora(),
                alquiler.getCliente(),
                alquiler.getBicicleta(),
                alquiler.getEstadoAlquiler(),
                alquiler.getDelivery()));

        return new ResponseEntity<Alquiler>(newAlquiler, HttpStatus.CREATED);
        */
    }



    /*----------------------------------------------------- ACTUALIZAR ALQUILER -----------------------------------------------------*/
    @PutMapping("/alquileres/{id}")
    public ResponseEntity<Alquiler> updateAlquilerById(@PathVariable("id") Long id, @RequestBody Alquiler alquiler) {

        Alquiler foundCliente = alquilerService.updateAlquilerByIdS(id, alquiler);
        return new ResponseEntity<Alquiler>(foundCliente, HttpStatus.OK);

        /*
        Alquiler foundCliente = alquilerRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found Alquiler with id="+id));

        if (alquiler.getPlazo()!=null)
            foundCliente.setPlazo(alquiler.getPlazo());
        if (alquiler.getFecha()!=null)
            foundCliente.setFecha(alquiler.getFecha());
        if (alquiler.getHora()!=null)
            foundCliente.setHora(alquiler.getHora());
        if (alquiler.getCliente()!=null)
            foundCliente.setCliente(alquiler.getCliente());
        if (alquiler.getBicicleta()!=null)
            foundCliente.setBicicleta(alquiler.getBicicleta());
        if (alquiler.getEstadoAlquiler()!=null)
            foundCliente.setEstadoAlquiler(alquiler.getEstadoAlquiler());
        if (alquiler.getDelivery()!=null)
            foundCliente.setDelivery(alquiler.getDelivery());

        Alquiler foundCliente1 = alquilerRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found Alquiler with id="+id));
        foundCliente1.getCliente().setAlquileres(null);
        foundCliente1.getBicicleta().setEmpresa(null);
        foundCliente1.getBicicleta().setAlquileres(null);

        Alquiler updatedAlquiler = alquilerRepository.save(foundCliente);
        return new ResponseEntity<Alquiler>(updatedAlquiler, HttpStatus.OK);
        */
    }



    /*----------------------------------------------------- BORRAR ALQUILER -----------------------------------------------------*/
    @DeleteMapping("/alquileres/{id}")
    public ResponseEntity<HttpStatus>deleteAlquilerById(@PathVariable("id") Long id){
        alquilerService.deleteAlquilerByIdS(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        /*
        alquilerRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        */
    }



    /*----------------------------------------------------- LISTA DE TODOS LOS ALQUILERES-----------------------------------------------------*/
    @GetMapping("/alquileres")
    public ResponseEntity<List<Alquiler>> getAllAlquileres(){

        List<Alquiler> alquileres = alquilerService.getAllAlquileresS();
        if(alquileres.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Alquiler>>(alquileres,HttpStatus.OK);

        /*
        List<Alquiler> alquileres = alquilerRepository.findAll();
        if(alquileres.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Alquiler a : alquileres) {
            a.getCliente().setAlquileres(null);
            a.getBicicleta().setEmpresa(null);
            a.getBicicleta().setAlquileres(null);
        }
        return new ResponseEntity<List<Alquiler>>(alquileres,HttpStatus.OK);*/
    }



    //---------------------- MOSTRAR EL ALQUILER SEGUN EL ID ---------------------
    @GetMapping("/alquileres/{id}")
    public ResponseEntity<Alquiler> getAlquilerById(@PathVariable("id") Long id){

        Alquiler alquiler = alquilerService.getAlquilerByIdS(id);
        return new ResponseEntity<Alquiler>(alquiler,HttpStatus.OK);

        /*
        Alquiler alquiler = alquilerRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found Alquiler with id="+id));

        alquiler.getCliente().setAlquileres(null);
        alquiler.getBicicleta().setEmpresa(null);
        alquiler.getBicicleta().setAlquileres(null);

        return new ResponseEntity<Alquiler>(alquiler,HttpStatus.OK);*/
    }

}
