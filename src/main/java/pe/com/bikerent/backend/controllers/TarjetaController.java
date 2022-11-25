package pe.com.bikerent.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.bikerent.backend.entities.Cliente;
import pe.com.bikerent.backend.entities.Tarjeta;
import pe.com.bikerent.backend.entities.Usuario;
import pe.com.bikerent.backend.exceptions.ResourceNotFoundException;
import pe.com.bikerent.backend.repositories.TarjetaRepository;
import pe.com.bikerent.backend.services.TarjetaService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TarjetaController {

    /*@Autowired
    private TarjetaRepository tarjetaRepository;*/
    @Autowired
    private TarjetaService tarjetaService;



    /*----------------------------------------------------- CREAR Tarjeta -----------------------------------------------------*/
    @PostMapping("/tarjetas")
    public ResponseEntity<Tarjeta> createTarjeta(@RequestBody Tarjeta tarjeta) {

        Tarjeta newTarjeta = tarjetaService.createTarjetaS(new Tarjeta(
                tarjeta.getNumero(),
                tarjeta.getNombreCompleto(),
                tarjeta.getFechaCaducidad(),
                tarjeta.getCvv()));

        return new ResponseEntity<Tarjeta>(newTarjeta, HttpStatus.CREATED);

        /*
        Tarjeta newTarjeta = tarjetaRepository.save(new Tarjeta(
                tarjeta.getNumero(),
                tarjeta.getNombreCompleto(),
                tarjeta.getFechaCaducidad(),
                tarjeta.getCvv()));

        return new ResponseEntity<Tarjeta>(newTarjeta, HttpStatus.CREATED);
        */
    }



    /*----------------------------------------------------- ACTUALIZAR TARJETAS -----------------------------------------------------*/
    @PutMapping("/tarjetas/{id}")
    public ResponseEntity<Tarjeta> updateTarjetaById(@PathVariable("id") Long id, @RequestBody Tarjeta tarjeta) {

        Tarjeta foundTarjeta = tarjetaService.updateTarjetaByIdS(id, tarjeta);
        return new ResponseEntity<Tarjeta>(foundTarjeta, HttpStatus.OK);

        /*
        Tarjeta foundTarjeta = tarjetaRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found Tarjeta with id="+id));

        if (tarjeta.getNumero()!=null)
            foundTarjeta.setNumero(tarjeta.getNumero());
        if (tarjeta.getNombreCompleto()!=null)
            foundTarjeta.setNombreCompleto(tarjeta.getNombreCompleto());
        if (tarjeta.getFechaCaducidad()!=null)
            foundTarjeta.setFechaCaducidad(tarjeta.getFechaCaducidad());
        if (tarjeta.getCvv()!=null)
            foundTarjeta.setCvv(tarjeta.getCvv());

        Tarjeta updatedTarjeta = tarjetaRepository.save(foundTarjeta);
        return new ResponseEntity<Tarjeta>(updatedTarjeta, HttpStatus.OK);
        */
    }



    /*----------------------------------------------------- LISTAS DE TARJETAS -----------------------------------------------------*/
    @GetMapping("/tarjetas")
    public ResponseEntity<List<Tarjeta>> getAllTarjetas(){
        List<Tarjeta> tarjetas = tarjetaService.getAllTarjetasS();
        if(tarjetas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Tarjeta>>(tarjetas,HttpStatus.OK);

        /*
        List<Tarjeta> tarjetas = tarjetaRepository.findAll();
        if(tarjetas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Tarjeta>>(tarjetas,HttpStatus.OK);
        */
    }


    //---------------------- MOSTRAR EMPRESA SEGUN EL ID ---------------------
    @GetMapping("/tarjetas/{id}")
    public ResponseEntity<Tarjeta> getTarjetaById(@PathVariable("id") Long id){
        Tarjeta tarjeta = tarjetaService.getTarjetaByIdS(id);
        return new ResponseEntity<Tarjeta>(tarjeta,HttpStatus.OK);

        /*
        Tarjeta tarjeta = tarjetaRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found tarjeta with id="+id));;
        return new ResponseEntity<Tarjeta>(tarjeta,HttpStatus.OK);
        */
    }

}
