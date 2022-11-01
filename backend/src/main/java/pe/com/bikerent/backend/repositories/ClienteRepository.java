package pe.com.bikerent.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.bikerent.backend.entities.Cliente;
import pe.com.bikerent.backend.entities.Empresa;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    List<Cliente> findByDireccionContaining(String direccion);

    @Query(value = "SELECT * FROM clientes WHERE dni=?1", nativeQuery = true)
    Cliente findByDNISQL(String dni);

    @Query("SELECT o FROM Cliente o WHERE o.nombre=?1")
    Cliente findByRUCJPQL(String nombre);

    @Query(value = "SELECT * FROM clientes WHERE correo=?1", nativeQuery = true)
    Cliente findByCorreoSQL(String correo);
}
