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

import java.util.List;

@RestController
@RequestMapping("/api")
public class EstadoAlquilerController {
    @Autowired
    private EstadoAlquilerRepository estadoAlquilerRepository;


    /*----------------------------------------------------- LISTA DE TODOS LOS ESTADOS DE ALQUILER -----------------------------------------------------*/
    @GetMapping("/estadoAlquiler")
    public ResponseEntity<List<EstadoAlquiler>> getAllEstadosAlquileres(){
        List<EstadoAlquiler> estados = estadoAlquilerRepository.findAll();
        if(estados.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<EstadoAlquiler>>(estados,HttpStatus.OK);
    }

}
