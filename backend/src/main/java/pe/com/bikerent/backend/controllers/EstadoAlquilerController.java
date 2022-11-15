package pe.com.bikerent.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.bikerent.backend.entities.EstadoAlquiler;
import pe.com.bikerent.backend.entities.Usuario;
import pe.com.bikerent.backend.exceptions.ResourceNotFoundException;
import pe.com.bikerent.backend.repositories.EstadoAlquilerRepository;
import pe.com.bikerent.backend.repositories.UsuarioRepository;
import pe.com.bikerent.backend.services.EstadoAlquilerService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EstadoAlquilerController {
    @Autowired
    private EstadoAlquilerRepository estadoAlquilerRepository;
    @Autowired
    private EstadoAlquilerService estadoAlquilerService;


    /*----------------------------------------------------- LISTA DE TODOS LOS ESTADOS DE ALQUILER -----------------------------------------------------*/
    @GetMapping("/estadoAlquiler")
    public ResponseEntity<List<EstadoAlquiler>> getAllEstadosAlquileres(){
        List<EstadoAlquiler> estados = estadoAlquilerService.getAllEstadosAlquileresS();
        if(estados.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<EstadoAlquiler>>(estados,HttpStatus.OK);

        /*
        List<EstadoAlquiler> estados = estadoAlquilerRepository.findAll();
        if(estados.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<EstadoAlquiler>>(estados,HttpStatus.OK);
        */
    }

}
