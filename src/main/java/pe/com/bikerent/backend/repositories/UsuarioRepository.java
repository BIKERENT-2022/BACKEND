package pe.com.bikerent.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.bikerent.backend.entities.Usuario;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {


    /* ---------------------- MOSTRAR TODOS LOS USUARIOS SEGUN SU NOMBRE --------------------- */
    @Query(value = "SELECT * FROM usuarios WHERE usuario=?1", nativeQuery = true)
    Usuario findByUsuarioSQL(String usuario);


    /* ---------------------- LISTAR TODOS LOS USUARIOS SEGUN SU TIPO ---------------------*/
    @Query(value = "SELECT * FROM usuarios WHERE tipo_usuario=?1", nativeQuery = true)
    List<Usuario> findByTipoUsuarioSQL(String tipo_usuario);
}
