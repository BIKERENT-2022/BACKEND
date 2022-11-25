package pe.com.bikerent.backend.controllers;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.transaction.annotation.Transactional;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.bikerent.backend.entities.*;
import pe.com.bikerent.backend.exceptions.ResourceNotFoundException;
import pe.com.bikerent.backend.exporters.BicicletasExporterExcel;
import pe.com.bikerent.backend.exporters.ClientesExporterExcel;
import pe.com.bikerent.backend.repositories.BicicletaRepository;
import pe.com.bikerent.backend.repositories.EmpresaRepository;
import pe.com.bikerent.backend.repositories.UsuarioRepository;
import pe.com.bikerent.backend.services.BicicletaService;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BicicletaController {
    @Autowired
    private BicicletaRepository bicicletaRepository;
    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private BicicletaService bicicletaService;


    /*----------------------------------------------------- CREAR BICICLETA -----------------------------------------------------*/
    @Transactional
    @PostMapping("/bicicletas")
    public ResponseEntity<Bicicleta> createBicicleta(@RequestBody Bicicleta bicicleta) {

        Bicicleta newBicicleta = bicicletaService.createBicicletaS(new Bicicleta(
                bicicleta.getModelo(),
                bicicleta.getMarca(),
                bicicleta.getColor(),
                bicicleta.getTipo(),
                bicicleta.getImagen(),
                bicicleta.getEmpresa()));
        return new ResponseEntity<Bicicleta>(newBicicleta, HttpStatus.CREATED);

        /*
        Bicicleta newBicicleta = bicicletaRepository.save(new Bicicleta(
                bicicleta.getModelo(),
                bicicleta.getMarca(),
                bicicleta.getColor(),
                bicicleta.getTipo(),
                bicicleta.getImagen(),
                bicicleta.getEmpresa()));

        return new ResponseEntity<Bicicleta>(newBicicleta, HttpStatus.CREATED);
        */
    }



    /*----------------------------------------------------- ACTUALIZAR ALQUILER -----------------------------------------------------*/
    @Transactional
    @PutMapping("/bicicletas/{id}")
    public ResponseEntity<Bicicleta> updatebicicletasById(@PathVariable("id") Long id, @RequestBody Bicicleta bicicleta) {

        Bicicleta foundBicicleta = bicicletaService.updatebicicletasByIdS(id, bicicleta);
        return new ResponseEntity<Bicicleta>(foundBicicleta, HttpStatus.OK);

        /*
        Bicicleta foundBicicleta = bicicletaRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found bicicleta with id="+id));

        if (bicicleta.getModelo()!=null)
            foundBicicleta.setModelo(bicicleta.getModelo());
        if (bicicleta.getMarca()!=null)
            foundBicicleta.setMarca(bicicleta.getMarca());
        if (bicicleta.getColor()!=null)
            foundBicicleta.setColor(bicicleta.getColor());
        if (bicicleta.getTipo()!=null)
            foundBicicleta.setTipo(bicicleta.getTipo());
        if (bicicleta.getImagen()!=null)
            foundBicicleta.setImagen(bicicleta.getImagen());
        if (bicicleta.getEmpresa()!=null)
            foundBicicleta.setEmpresa(bicicleta.getEmpresa());

        Bicicleta foundBicicleta1 = bicicletaRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found bicicleta with id="+id));
        foundBicicleta1.setAlquileres(null);

        Bicicleta updatedBicicleta = bicicletaRepository.save(foundBicicleta);
        return new ResponseEntity<Bicicleta>(updatedBicicleta, HttpStatus.OK);
        */
    }



    /* -------------------------------------------- BORRAR BICICLETAS -------------------------------------------- */
    @DeleteMapping("/bicicletas/{id}")
    public ResponseEntity<HttpStatus>deleteBicicletaById(@PathVariable("id") Long id){

        bicicletaService.deleteBicicletaByIdS(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        /*
        bicicletaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        */
    }



    /* -------------------------------------------- LISTA DE BICICLETAS -------------------------------------------- */


    @GetMapping("/bicicletas")
    public ResponseEntity<List<Bicicleta>> getAllBicicletas(){

        List<Bicicleta> bicicletas = bicicletaService.getAllBicicletasS();
        if(bicicletas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Bicicleta>>(bicicletas,HttpStatus.OK);

        /*
        List<Bicicleta> bicicletas = bicicletaRepository.findAll();
        if(bicicletas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Bicicleta b : bicicletas) {
            //b.getEmpresa().setBicicletas(null);
            b.setEmpresa(null);
            b.setAlquileres(null);
        }
        return new ResponseEntity<List<Bicicleta>>(bicicletas,HttpStatus.OK);
        */
    }


    /*---------------------- MOSTRAR BICICLETAS SEGUN ID ---------------------*/
    @GetMapping("/bicicletas/{id}")
    public ResponseEntity<Bicicleta> getBicicletaById(@PathVariable("id") Long id){
        Bicicleta bicicleta = bicicletaService.getBicicletaByIdS(id);
        bicicleta.getEmpresa().setBicicletas(null);
        bicicleta.setAlquileres(null);
        return new ResponseEntity<Bicicleta>(bicicleta,HttpStatus.OK);

        /*
        Bicicleta bicicleta = bicicletaRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found bicicleta with id="+id));;
        bicicleta.getEmpresa().setBicicletas(null);
        bicicleta.setAlquileres(null);
        return new ResponseEntity<Bicicleta>(bicicleta,HttpStatus.OK);
        */
    }

    /*---------------------- MOSTRAR BICICLETAS SEGUN MODELO ---------------------*/
    @GetMapping("/bicicletas/modelo/{modelo}")
    public ResponseEntity<List<Bicicleta>> getAllBicicletasByModelo(@PathVariable("modelo") String modelo){
        List<Bicicleta> bicicletas = bicicletaService.getAllBicicletasByModeloS(modelo);
        if(bicicletas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Bicicleta>>(bicicletas,HttpStatus.OK);

        /*
        List<Bicicleta> bicicletas = bicicletaRepository.findByModeloSQL(modelo);
        if(bicicletas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Bicicleta b : bicicletas) {
            b.setEmpresa(null);
            b.setAlquileres(null);
        }
        return new ResponseEntity<List<Bicicleta>>(bicicletas,HttpStatus.OK);
        */
    }


    /*---------------------- MOSTRAR BICICLETAS SEGUN MARCA ---------------------*/
    @GetMapping("/bicicletas/marca/{marca}")
    public ResponseEntity<List<Bicicleta>> getAllBicicletasByMarca(@PathVariable("marca") String marca){
        List<Bicicleta> bicicletas = bicicletaService.getAllBicicletasByMarcaS(marca);
        if(bicicletas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Bicicleta>>(bicicletas,HttpStatus.OK);

        /*
        List<Bicicleta> bicicletas = bicicletaRepository.findByMarcaSQL(marca);
        if(bicicletas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Bicicleta b : bicicletas) {
            b.setEmpresa(null);
            b.setAlquileres(null);
        }
        return new ResponseEntity<List<Bicicleta>>(bicicletas,HttpStatus.OK);
        */
    }


    /*---------------------- MOSTRAR BICICLETAS SEGUN COLOR ---------------------*/
    @GetMapping("/bicicletas/color/{color}")
    public ResponseEntity<List<Bicicleta>> getAllBicicletasByColor(@PathVariable("color") String color){
        List<Bicicleta> bicicletas = bicicletaService.getAllBicicletasByColorS(color);
        if(bicicletas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Bicicleta>>(bicicletas,HttpStatus.OK);

        /*
        List<Bicicleta> bicicletas = bicicletaRepository.findByColorSQL(color);
        if(bicicletas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Bicicleta b : bicicletas) {
            b.setEmpresa(null);
            b.setAlquileres(null);
        }
        return new ResponseEntity<List<Bicicleta>>(bicicletas,HttpStatus.OK);
        */
    }


    /*---------------------- MOSTRAR BICICLETAS SEGUN TIPO ---------------------*/
    @GetMapping("/bicicletas/tipo/{tipo}")
    public ResponseEntity<List<Bicicleta>> getAllBicicletasByTipo(@PathVariable("tipo") String tipo){
        List<Bicicleta> bicicletas = bicicletaService.getAllBicicletasByTipoS(tipo);
        if(bicicletas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Bicicleta>>(bicicletas,HttpStatus.OK);

        /*
        List<Bicicleta> bicicletas = bicicletaRepository.findByTipoSQL(tipo);
        if(bicicletas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Bicicleta b : bicicletas) {
            b.setEmpresa(null);
            b.setAlquileres(null);
        }
        return new ResponseEntity<List<Bicicleta>>(bicicletas,HttpStatus.OK);
        */
    }



    @GetMapping("/bicicletas/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=employee_report";
        response.setHeader(headerKey,headerValue);

        List<Bicicleta> bici;
        bici = bicicletaRepository.findAll();

        BicicletasExporterExcel exporterExcel = new BicicletasExporterExcel(bici);
        exporterExcel.export(response);
    }

}
