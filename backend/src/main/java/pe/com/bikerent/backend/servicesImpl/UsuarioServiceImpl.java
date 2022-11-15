package pe.com.bikerent.backend.servicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.bikerent.backend.entities.Cliente;
import pe.com.bikerent.backend.entities.Empresa;
import pe.com.bikerent.backend.entities.Usuario;
import pe.com.bikerent.backend.exceptions.ResourceNotFoundException;
import pe.com.bikerent.backend.repositories.ClienteRepository;
import pe.com.bikerent.backend.repositories.EmpresaRepository;
import pe.com.bikerent.backend.repositories.UsuarioRepository;
import pe.com.bikerent.backend.services.UsuarioService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    EmpresaRepository empresaRepository;
    @Autowired
    ClienteRepository clienteRepository;

    @Transactional
    public Usuario createUsuarioS(Usuario usuario){
        Usuario newUsuario = usuarioRepository.save(new Usuario(usuario.getUsuario(), usuario.getContrasenia(), usuario.getTipo_usuario()));

        switch (newUsuario.getTipo_usuario()){
            case "Empresa": createNewEmpresaS(newUsuario.getId()); break;
            case "Cliente": createNewClienteS(newUsuario.getId()); break;
        }

        return newUsuario;
    }
    @Transactional
    public Empresa createNewEmpresaS(Long id){
        Empresa newEmpresa = empresaRepository.save(new Empresa(id,null,null,null,null,null,null));
        return newEmpresa;
    }
    @Transactional
    public Cliente createNewClienteS(Long id){
        Cliente newCliente = clienteRepository.save(new Cliente(id,null,null,null,null,null,null));
        return newCliente;
    }



    @Transactional
    public Usuario updateUsuarioByIdS(Long id, Usuario usuario){
        Usuario foundUsuario = usuarioRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found Owner with id="+id));

        if (usuario.getUsuario()!=null)
            foundUsuario.setUsuario(usuario.getUsuario());
        if (usuario.getContrasenia()!=null)
            foundUsuario.setContrasenia(usuario.getContrasenia());
        if (usuario.getTipo_usuario()!=null)
            new ResourceNotFoundException("No se puede cambiar esta variable perteneciente al id="+id);

        Usuario updatedUsuario = usuarioRepository.save(foundUsuario);
        return updatedUsuario;
    }

    @Transactional
    public void deleteUsuarioByIdS(Long id){
        usuarioRepository.deleteById(id);
    }

    public List<Usuario> getAllUsuariosS(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    public Usuario getUsuarioByUsuarioS(String usu){
        Usuario usuario = usuarioRepository.findByUsuarioSQL(usu);
        return usuario;
    }

    public List<Usuario> getAllUsuariosByTipoUsuarioS(String tipo_usuario){
        List<Usuario> usuario = usuarioRepository.findByTipoUsuarioSQL(tipo_usuario);
        return usuario;
    }

    public Usuario getUsuarioByIdS(Long id){
        Usuario usuario = usuarioRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found Usuario with id="+id));;
        return usuario;
    }

}
