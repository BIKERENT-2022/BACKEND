package pe.com.bikerent.backend.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.bikerent.backend.entities.Alquiler;
import pe.com.bikerent.backend.entities.Bicicleta;
import pe.com.bikerent.backend.entities.Empresa;
import pe.com.bikerent.backend.exceptions.ResourceNotFoundException;
import pe.com.bikerent.backend.repositories.EmpresaRepository;
import pe.com.bikerent.backend.services.EmpresaService;

import java.util.List;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    public Empresa updateEmpresaByIdS(Long id, Empresa empresa){
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
        return updatedEmpresa;
    }

    public void deleteEmpresaByIdS(Long id){
        empresaRepository.deleteById(id);
    }

    public Empresa getEmpresaByIdS(Long id){
        Empresa empresa = empresaRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found empresa with id="+id));;
        empresa.setBicicletas(null);
        return empresa;
    }

    public List<Empresa> getAllEmpresasS(){
        List<Empresa> empresas = empresaRepository.findAll();
        for (Empresa e : empresas) {
            e.setBicicletas(null);
        }
        return empresas;
    }

    public List<Empresa> getAllEmpresasAndBikesS(){
        List<Empresa> empresas = empresaRepository.findAll();
        for (Empresa e : empresas) {
            for (Bicicleta b : e.getBicicletas()) {
                b.setAlquileres(null);
                b.setEmpresa(null);
            }
        }
        return empresas;
    }

    public List<Empresa> getEmpresaByDireccionS(String direccion){
        List<Empresa> empresas = empresaRepository.findByDireccionContaining(direccion);
        for (Empresa e : empresas) {
            e.setBicicletas(null);
        }
        return empresas;
    }

    public Empresa getEmpresaByRucS(String ruc){
        Empresa empresa = empresaRepository.findByRUCSQL(ruc);
        empresa.setBicicletas(null);
        return empresa;
    }

    public Empresa getEmpresaByNombreS(String nombre){
        Empresa empresa = empresaRepository.findByRUCJPQL(nombre);
        empresa.setBicicletas(null);
        return empresa;
    }

    public Empresa getEmpresaByCorreoS(String correo){
        Empresa empresa = empresaRepository.findByCorreoSQL(correo);
        empresa.setBicicletas(null);
        return empresa;
    }

}
