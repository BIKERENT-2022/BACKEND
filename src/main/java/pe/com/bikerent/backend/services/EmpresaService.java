package pe.com.bikerent.backend.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pe.com.bikerent.backend.entities.Empresa;

import java.util.List;

public interface EmpresaService {
    public Empresa updateEmpresaByIdS(Long id, Empresa empresa);
    public void deleteEmpresaByIdS(Long id);
    public Empresa getEmpresaByIdS(Long id);
    public List<Empresa> getAllEmpresasS();
    public List<Empresa> getAllEmpresasAndBikesS();
    public List<Empresa> getEmpresaByDireccionS(String direccion);
    public Empresa getEmpresaByRucS(String ruc);
    public Empresa getEmpresaByNombreS(String nombre);
    public Empresa getEmpresaByCorreoS(String correo);
}
