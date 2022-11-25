package pe.com.bikerent.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.bikerent.backend.entities.Empresa;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa,Long> {
    List<Empresa> findByDireccionContaining(String direccion);

    @Query(value = "SELECT * FROM empresas WHERE ruc=?1", nativeQuery = true)
    Empresa findByRUCSQL(String ruc);

    @Query("SELECT o FROM Empresa o WHERE o.nombre=?1")
    Empresa findByRUCJPQL(String nombre);

    @Query(value = "SELECT * FROM empresas WHERE correo=?1", nativeQuery = true)
    Empresa findByCorreoSQL(String correo);

    @Query(value = "SELECT * FROM empresas WHERE id=?1", nativeQuery = true)
    Empresa getById(Long id);

}
