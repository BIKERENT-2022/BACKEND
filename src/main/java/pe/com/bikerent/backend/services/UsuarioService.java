package pe.com.bikerent.backend.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pe.com.bikerent.backend.entities.Cliente;
import pe.com.bikerent.backend.entities.Empresa;
import pe.com.bikerent.backend.entities.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario createUsuarioS(Usuario usuario);

    public Usuario updateUsuarioByIdS(Long id, Usuario usuario);
    public void deleteUsuarioByIdS(Long id);
    public List<Usuario> getAllUsuariosS();
    public Usuario getUsuarioByUsuarioS(String usu);
    public List<Usuario> getAllUsuariosByTipoUsuarioS(String tipo_usuario);
    public Usuario getUsuarioByIdS(Long id);

}
