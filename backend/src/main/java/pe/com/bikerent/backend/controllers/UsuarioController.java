package pe.com.bikerent.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.bikerent.backend.entities.Cliente;
import pe.com.bikerent.backend.entities.Empresa;
import pe.com.bikerent.backend.entities.Suscripcion;
import pe.com.bikerent.backend.entities.Usuario;
import pe.com.bikerent.backend.exceptions.ResourceNotFoundException;
import pe.com.bikerent.backend.repositories.ClienteRepository;
import pe.com.bikerent.backend.repositories.EmpresaRepository;
import pe.com.bikerent.backend.repositories.SuscripcionesRepository;
import pe.com.bikerent.backend.repositories.UsuarioRepository;
import pe.com.bikerent.backend.services.UsuarioService;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200") //Para dar permisos de conexcion
@RestController
@RequestMapping("/api")
public class UsuarioController {
/*
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EmpresaRepository empresaRepository;*/

    @Autowired
    private UsuarioService usuarioService;



    /*----------------------------------------------------- CREAR USUARIOS -----------------------------------------------------*/
    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario newUsuario = usuarioService.createUsuarioS(new Usuario(usuario.getUsuario(), usuario.getContrasenia(), usuario.getTipo_usuario()));
        return new ResponseEntity<Usuario>(newUsuario, HttpStatus.CREATED);
        /*        Usuario newUsuario = usuarioRepository.save(new Usuario(usuario.getUsuario(), usuario.getContrasenia(), usuario.getTipo_usuario()));

        switch (newUsuario.getTipo_usuario()){
            case "Empresa": createNewEmpresa(newUsuario.getId()); break;
            case "Cliente": createNewCliente(newUsuario.getId()); break;
        }

        return new ResponseEntity<Usuario>(newUsuario, HttpStatus.CREATED);*/
    }
    /*
    // Empresa
    public ResponseEntity<Empresa>createNewEmpresa(Long id){
        Empresa newEmpresa = usuarioService.createNewEmpresaS(new Empresa(id,null,null,null,null,null,null));
        return new ResponseEntity<Empresa>(newEmpresa, HttpStatus.CREATED);
    }
    // Cliente
    public ResponseEntity<Cliente>createNewCliente(Long id){
        Cliente newCliente = usuarioService.createNewClienteS(new Cliente(id,null,null,null,null,null,null));
        return new ResponseEntity<Cliente>(newCliente, HttpStatus.CREATED);
    }
*/



    /*----------------------------------------------------- ACTUALIZAR USUARIOS -----------------------------------------------------*/
    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> updateUsuarioById(@PathVariable("id") Long id,@RequestBody Usuario usuario) {

        Usuario foundUsuario = usuarioService.updateUsuarioByIdS(id, usuario);
        return new ResponseEntity<Usuario>(foundUsuario, HttpStatus.OK);

        /*
        Usuario foundUsuario = usuarioRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found Owner with id="+id));

        if (usuario.getUsuario()!=null)
            foundUsuario.setUsuario(usuario.getUsuario());
        if (usuario.getContrasenia()!=null)
            foundUsuario.setContrasenia(usuario.getContrasenia());
        if (usuario.getTipo_usuario()!=null)
            new ResourceNotFoundException("No se puede cambiar esta variable perteneciente al id="+id);

        Usuario updatedUsuario = usuarioRepository.save(foundUsuario);
        return new ResponseEntity<Usuario>(updatedUsuario, HttpStatus.OK);
        */
    }


    /*----------------------------------------------------- ELIMINAR USUARIOS -----------------------------------------------------*/

    // Borrar usuarios
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<HttpStatus>deleteUsuarioById(@PathVariable("id") Long id){
        usuarioService.deleteUsuarioByIdS(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        /*
        usuarioRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        */
    }



    /*----------------------------------------------------- LISTA DE TODOS LOS USUARIOS-----------------------------------------------------*/
    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        List<Usuario> usuarios = usuarioService.getAllUsuariosS();
        if(usuarios.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK);

        /*
        List<Usuario> usuarios = usuarioRepository.findAll();
        if(usuarios.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Usuario>>(usuarios,HttpStatus.OK);
        */
    }



    //---------------------- MOSTRAR USUARIO SEGUN NOMBRE ---------------------
    @GetMapping("/usuarios/usuario/{usuario}")
    public ResponseEntity<Usuario> getUsuarioByUsuario(@PathVariable("usuario") String usu){
        Usuario usuario = usuarioService.getUsuarioByUsuarioS(usu);
        return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);

        /*
        Usuario usuario = usuarioRepository.findByUsuarioSQL(usu);
        return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
        */
    }


    //---------------------- LISTAR USUARIO SEGUN EL TIPO ---------------------
    @GetMapping("/usuarios/tipoUsuario/{tipo_usuario}")
    public ResponseEntity<List<Usuario>> getAllUsuariosByTipoUsuario(@PathVariable("tipo_usuario") String tipo_usuario){
        List<Usuario> usuario = usuarioService.getAllUsuariosByTipoUsuarioS(tipo_usuario);
        return new ResponseEntity<List<Usuario>>(usuario,HttpStatus.OK);

        /*
        List<Usuario> usuario = usuarioRepository.findByTipoUsuarioSQL(tipo_usuario);
        return new ResponseEntity<List<Usuario>>(usuario,HttpStatus.OK);
        */
    }


    //---------------------- MOSTRAR USUARIO SEGUN EL ID ---------------------
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") Long id){
        Usuario usuario = usuarioService.getUsuarioByIdS(id);
        return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);

        /*
        Usuario usuario = usuarioRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found Usuario with id="+id));;
        return new ResponseEntity<Usuario>(usuario,HttpStatus.OK);
        */
    }

}
