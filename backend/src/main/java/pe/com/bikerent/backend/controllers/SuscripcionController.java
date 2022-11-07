package pe.com.bikerent.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.bikerent.backend.entities.Suscripcion;
import pe.com.bikerent.backend.entities.Usuario;
import pe.com.bikerent.backend.exceptions.ResourceNotFoundException;
import pe.com.bikerent.backend.repositories.SuscripcionesRepository;
import pe.com.bikerent.backend.repositories.UsuarioRepository;
import pe.com.bikerent.backend.services.SuscripcionService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SuscripcionController {
    @Autowired
    private SuscripcionesRepository suscripcionesRepository;
    @Autowired
    private SuscripcionService suscripcionService;


    //---------------------- CREAR SUSCRIPCION --------------------- */
    @PostMapping("/suscripciones")
    public ResponseEntity<Suscripcion> createSuscripcion(@RequestBody Suscripcion suscripcion) {

        Suscripcion newSuscripcion = suscripcionService.createSuscripcionS(new Suscripcion(
                suscripcion.getTarjeta(),
                suscripcion.getPlan(),
                suscripcion.getUsuario(),
                suscripcion.getFechaInicio(),
                suscripcion.getFechaFin()));


        return new ResponseEntity<Suscripcion>(newSuscripcion, HttpStatus.CREATED);

        /*
        Suscripcion newSuscripcion = suscripcionesRepository.save(new Suscripcion(
                suscripcion.getTarjeta(),
                suscripcion.getPlan(),
                suscripcion.getUsuario(),
                suscripcion.getFechaInicio(),
                suscripcion.getFechaFin()));


        return new ResponseEntity<Suscripcion>(newSuscripcion, HttpStatus.CREATED);
        */
    }



    /*----------------------------------------------------- ACTUALIZAR SUSCRIPCION -----------------------------------------------------*/
    @PutMapping("/suscripciones/{id}")
    public ResponseEntity<Suscripcion> updateSuscripcionById(@PathVariable("id") Long id,@RequestBody Suscripcion suscripcion) {

        Suscripcion foundSuscripcion = suscripcionesRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found suscripcion with id="+id));

        if (suscripcion.getUsuario()!=null)
            foundSuscripcion.setUsuario(suscripcion.getUsuario());
        if (suscripcion.getTarjeta()!=null)
            foundSuscripcion.setTarjeta(suscripcion.getTarjeta());
        if (suscripcion.getPlan()!=null)
            foundSuscripcion.setPlan(suscripcion.getPlan());
        if (suscripcion.getFechaInicio()!=null)
            foundSuscripcion.setFechaInicio(suscripcion.getFechaInicio());
        if (suscripcion.getFechaFin()!=null)
            foundSuscripcion.setFechaFin(suscripcion.getFechaFin());

        Suscripcion updatedSuscripcion = suscripcionService.updateSuscripcionByIdS(foundSuscripcion);
        return new ResponseEntity<Suscripcion>(updatedSuscripcion, HttpStatus.OK);

        /*
        Suscripcion foundSuscripcion = suscripcionesRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found suscripcion with id="+id));

        if (suscripcion.getUsuario()!=null)
            foundSuscripcion.setUsuario(suscripcion.getUsuario());
        if (suscripcion.getTarjeta()!=null)
            foundSuscripcion.setTarjeta(suscripcion.getTarjeta());
        if (suscripcion.getPlan()!=null)
            foundSuscripcion.setPlan(suscripcion.getPlan());
        if (suscripcion.getFechaInicio()!=null)
            foundSuscripcion.setFechaInicio(suscripcion.getFechaInicio());
        if (suscripcion.getFechaFin()!=null)
            foundSuscripcion.setFechaFin(suscripcion.getFechaFin());

        Suscripcion updatedSuscripcion = suscripcionesRepository.save(foundSuscripcion);
        return new ResponseEntity<Suscripcion>(updatedSuscripcion, HttpStatus.OK);
        */
    }



    /*----------------------------------------------------- BORRAR SUSCRIPCION -----------------------------------------------------*/
    @DeleteMapping("/suscripciones/{id}")
    public ResponseEntity<HttpStatus>deleteSuscripcionById(@PathVariable("id") Long id){
        suscripcionService.deleteSuscripcionByIdS(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        /*
        suscripcionesRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        */
    }



    /*----------------------------------------------------- LISTA DE TODAS LAS SUSCRIPCIONES -----------------------------------------------------*/
    @GetMapping("/suscripciones")
    public ResponseEntity<List<Suscripcion>> getAllSuscripciones(){
        List<Suscripcion> suscripciones = suscripcionService.getAllSuscripcionesS();
        if(suscripciones.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Suscripcion>>(suscripciones,HttpStatus.OK);

        /*
        List<Suscripcion> suscripciones = suscripcionesRepository.findAll();
        if(suscripciones.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Suscripcion>>(suscripciones,HttpStatus.OK);
        */
    }


    //---------------------- MOSTRAR SUSCRIPCION SEGUN EL ID --------------------- */
    @GetMapping("/suscripciones/{id}")
    public ResponseEntity<Suscripcion> getSuscripcionesById(@PathVariable("id") Long id){
        Suscripcion suscripcion = suscripcionService.getSuscripcionesByIdS(id);
        return new ResponseEntity<Suscripcion>(suscripcion,HttpStatus.OK);

        /*
        Suscripcion suscripcion = suscripcionesRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found Suscripcion with id="+id));;
        return new ResponseEntity<Suscripcion>(suscripcion,HttpStatus.OK);
        */
    }

}
