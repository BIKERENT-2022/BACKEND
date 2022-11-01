package pe.com.bikerent.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.bikerent.backend.entities.Cliente;
import pe.com.bikerent.backend.entities.Plan;
import pe.com.bikerent.backend.entities.Usuario;
import pe.com.bikerent.backend.exceptions.ResourceNotFoundException;
import pe.com.bikerent.backend.repositories.PlanRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlanController {

    @Autowired
    private PlanRepository planRepository;


    /*----------------------------------------------------- LISTAS DE PLANES -----------------------------------------------------*/
    @GetMapping("/planes")
    public ResponseEntity<List<Plan>> getAllPlanes(){
        List<Plan> planes = planRepository.findAll();
        if(planes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Plan>>(planes,HttpStatus.OK);
    }

}
