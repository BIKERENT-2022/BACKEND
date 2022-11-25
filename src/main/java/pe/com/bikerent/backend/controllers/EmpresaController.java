package pe.com.bikerent.backend.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.bikerent.backend.entities.*;
import pe.com.bikerent.backend.exceptions.ResourceNotFoundException;
import pe.com.bikerent.backend.repositories.BicicletaRepository;
import pe.com.bikerent.backend.repositories.EmpresaRepository;
import pe.com.bikerent.backend.services.EmpresaService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private EmpresaService empresaService;


    /*----------------------------------------------------- ACTUALIZAR EMPRESA -----------------------------------------------------*/
    @PutMapping("/empresas/{id}")
    public ResponseEntity<Empresa> updateEmpresaById(@PathVariable("id") Long id, @RequestBody Empresa empresa) {

        Empresa foundEmpresa = empresaService.updateEmpresaByIdS(id, empresa);
        return new ResponseEntity<Empresa>(foundEmpresa, HttpStatus.OK);

        /*
        Empresa foundEmpresa = empresaRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found Owner with id="+id));

        if (empresa.getRuc()!=null)
            foundEmpresa.setRuc(empresa.getRuc());
        if (empresa.getNombre()!=null)
            foundEmpresa.setNombre(empresa.getNombre());
        if (empresa.getCorreo()!=null)
            foundEmpresa.setCorreo(empresa.getCorreo());
        if (empresa.getDireccion()!=null)
            foundEmpresa.setDireccion(empresa.getDireccion());
        if (empresa.getTelefono()!=null)
            foundEmpresa.setTelefono(empresa.getTelefono());
        if (empresa.getImagen()!=null)
            foundEmpresa.setImagen(empresa.getImagen());

        Empresa foundEmpresa1 = empresaRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found Alquiler with id="+id));
        foundEmpresa1.setBicicletas(null);

        Empresa updatedEmpresa = empresaRepository.save(foundEmpresa);
        return new ResponseEntity<Empresa>(updatedEmpresa, HttpStatus.OK);
        */
    }



    /*---------------------- BORRAR EMPRESA ---------------------*/
    @DeleteMapping("/empresas/{id}")
    public ResponseEntity<HttpStatus>deleteEmpresaById(@PathVariable("id") Long id){
        empresaService.deleteEmpresaByIdS(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        /*
        empresaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        */
    }



    //---------------------- MOSTRAR EMPRESA SEGUN EL ID ---------------------
    @GetMapping("/empresas/{id}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable("id") Long id){
        Empresa empresa = empresaService.getEmpresaByIdS(id);
        return new ResponseEntity<Empresa>(empresa,HttpStatus.OK);

        /*
        Empresa empresa = empresaRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found empresa with id="+id));;
        empresa.setBicicletas(null);
        return new ResponseEntity<Empresa>(empresa,HttpStatus.OK);
        */
    }

    /*----------------------------------------------------- LISTA DE TODAS LAS EMPRESAS -----------------------------------------------------*/
    @GetMapping("/empresas")
    public ResponseEntity<List<Empresa>> getAllEmpresas(){
        List<Empresa> empresas = empresaService.getAllEmpresasS();
        if(empresas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Empresa>>(empresas,HttpStatus.OK);

        /*
        List<Empresa> empresas = empresaRepository.findAll();
        if(empresas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Empresa e : empresas) {
            e.setBicicletas(null);
        }
        return new ResponseEntity<List<Empresa>>(empresas,HttpStatus.OK);
        */
    }


    /*----------------------------------------------------- LISTA DE TODOS LAS EMPRESAS CON SUS BICICLETAS -----------------------------------------------------*/
    @GetMapping("/empresas/bikes")
    public ResponseEntity<List<Empresa>> getAllEmpresasAndBikes(){
        List<Empresa> empresas = empresaService.getAllEmpresasAndBikesS();
        if(empresas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Empresa>>(empresas,HttpStatus.OK);

        /*
        List<Empresa> empresas = empresaRepository.findAll();
        if(empresas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Empresa e : empresas) {
            for (Bicicleta b : e.getBicicletas()) {
                b.setAlquileres(null);
                b.setEmpresa(null);
            }
        }
        return new ResponseEntity<List<Empresa>>(empresas,HttpStatus.OK);
        */
    }



    /*---------------------- MOSTRAR EMPRESA SEGUN DIRECCION ---------------------*/
    @GetMapping("/empresas/direccion/{direccion}")
    public ResponseEntity<List<Empresa>> getEmpresaByDireccion(@PathVariable("direccion") String direccion){
        List<Empresa> empresas = empresaService.getEmpresaByDireccionS(direccion);
        if(empresas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Empresa>>(empresas,HttpStatus.OK);

        /*
        List<Empresa> empresas = empresaRepository.findByDireccionContaining(direccion);
        if(empresas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Empresa e : empresas) {
            e.setBicicletas(null);
        }
        return new ResponseEntity<List<Empresa>>(empresas,HttpStatus.OK);
        */
    }


    /*---------------------- MOSTRAR Empresa SEGUN RUC ---------------------*/
    @GetMapping("/empresas/ruc/{ruc}")
    public ResponseEntity<Empresa> getEmpresaByRuc(@PathVariable("ruc") String ruc){
        Empresa empresa = empresaService.getEmpresaByRucS(ruc);
        return new ResponseEntity<Empresa>(empresa,HttpStatus.OK);

        /*
        Empresa empresa = empresaRepository.findByRUCSQL(ruc);
        empresa.setBicicletas(null);
        return new ResponseEntity<Empresa>(empresa,HttpStatus.OK);
        */
    }


    /*---------------------- MOSTRAR Empresa SEGUN NOMBRE ---------------------*/
    @GetMapping("/empresas/nombre/{nombre}")
    public ResponseEntity<Empresa> getEmpresaByNombre(@PathVariable("nombre") String nombre){
        Empresa empresa = empresaService.getEmpresaByNombreS(nombre);
        return new ResponseEntity<Empresa>(empresa,HttpStatus.OK);

        /*
        Empresa empresa = empresaRepository.findByRUCJPQL(nombre);
        empresa.setBicicletas(null);
        return new ResponseEntity<Empresa>(empresa,HttpStatus.OK);
        */
    }


    /*---------------------- MOSTRAR Empresa SEGUN CORREO ---------------------*/
    @GetMapping("/empresas/correo/{correo}")
    public ResponseEntity<Empresa> getEmpresaByCorreo(@PathVariable("correo") String correo){
        Empresa empresa = empresaService.getEmpresaByCorreoS(correo);
        return new ResponseEntity<Empresa>(empresa,HttpStatus.OK);

        /*
        Empresa empresa = empresaRepository.findByCorreoSQL(correo);
        empresa.setBicicletas(null);
        return new ResponseEntity<Empresa>(empresa,HttpStatus.OK);
        */
    }


    @GetMapping("/empresas/id/{id}")
    public ResponseEntity<Empresa> getById(@PathVariable("id") Long id){
        Empresa empresa = empresaRepository.getById(id);

        return new ResponseEntity<Empresa>(empresa,HttpStatus.OK);
    }

}
