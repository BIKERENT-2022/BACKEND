package pe.com.bikerent.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.bikerent.backend.entities.Bicicleta;
import pe.com.bikerent.backend.entities.Empresa;
import pe.com.bikerent.backend.entities.Usuario;
import pe.com.bikerent.backend.exceptions.ResourceNotFoundException;
import pe.com.bikerent.backend.repositories.BicicletaRepository;
import pe.com.bikerent.backend.repositories.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BicicletaController {
    @Autowired
    private BicicletaRepository bicicletaRepository;

    /* -------------------------------------------- LISTA DE BICICLETAS -------------------------------------------- */
    @GetMapping("/bicicletas")
    public ResponseEntity<List<Bicicleta>> getAllBicicletas(){
        List<Bicicleta> bicicletas = bicicletaRepository.findAll();
        if(bicicletas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Bicicleta b : bicicletas) {
            b.setEmpresa(null);
            b.setAlquileres(null);
        }
        return new ResponseEntity<List<Bicicleta>>(bicicletas,HttpStatus.OK);
    }


    /*---------------------- MOSTRAR BICICLETAS SEGUN ID ---------------------*/
    @GetMapping("/bicicletas/{id}")
    public ResponseEntity<Bicicleta> getBicicletaById(@PathVariable("id") Long id){
        Bicicleta bicicleta = bicicletaRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found bicicleta with id="+id));;
        bicicleta.setEmpresa(null);
        bicicleta.setAlquileres(null);
        return new ResponseEntity<Bicicleta>(bicicleta,HttpStatus.OK);
    }

    /*---------------------- MOSTRAR BICICLETAS SEGUN MODELO ---------------------*/
    @GetMapping("/bicicletas/modelo/{modelo}")
    public ResponseEntity<List<Bicicleta>> getAllBicicletasByModelo(@PathVariable("modelo") String modelo){
        List<Bicicleta> bicicletas = bicicletaRepository.findByModeloSQL(modelo);
        if(bicicletas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Bicicleta b : bicicletas) {
            b.setEmpresa(null);
            b.setAlquileres(null);
        }
        return new ResponseEntity<List<Bicicleta>>(bicicletas,HttpStatus.OK);
    }


    /*---------------------- MOSTRAR BICICLETAS SEGUN MARCA ---------------------*/
    @GetMapping("/bicicletas/marca/{marca}")
    public ResponseEntity<List<Bicicleta>> getAllBicicletasByMarca(@PathVariable("marca") String marca){
        List<Bicicleta> bicicletas = bicicletaRepository.findByMarcaSQL(marca);
        if(bicicletas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Bicicleta b : bicicletas) {
            b.setEmpresa(null);
            b.setAlquileres(null);
        }
        return new ResponseEntity<List<Bicicleta>>(bicicletas,HttpStatus.OK);
    }


    /*---------------------- MOSTRAR BICICLETAS SEGUN COLOR ---------------------*/
    @GetMapping("/bicicletas/color/{color}")
    public ResponseEntity<List<Bicicleta>> getAllBicicletasByColor(@PathVariable("color") String color){
        List<Bicicleta> bicicletas = bicicletaRepository.findByColorSQL(color);
        if(bicicletas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Bicicleta b : bicicletas) {
            b.setEmpresa(null);
            b.setAlquileres(null);
        }
        return new ResponseEntity<List<Bicicleta>>(bicicletas,HttpStatus.OK);
    }


    /*---------------------- MOSTRAR BICICLETAS SEGUN TIPO ---------------------*/
    @GetMapping("/bicicletas/tipo/{tipo}")
    public ResponseEntity<List<Bicicleta>> getAllBicicletasByTipo(@PathVariable("tipo") String tipo){
        List<Bicicleta> bicicletas = bicicletaRepository.findByTipoSQL(tipo);
        if(bicicletas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Bicicleta b : bicicletas) {
            b.setEmpresa(null);
            b.setAlquileres(null);
        }
        return new ResponseEntity<List<Bicicleta>>(bicicletas,HttpStatus.OK);
    }
}
