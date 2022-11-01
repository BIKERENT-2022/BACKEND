package pe.com.bikerent.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.bikerent.backend.entities.Bicicleta;
import pe.com.bikerent.backend.entities.Empresa;

import java.util.List;


public interface BicicletaRepository extends JpaRepository<Bicicleta,Long> {

    @Query(value = "SELECT * FROM bicicletas WHERE modelo=?1", nativeQuery = true)
    List<Bicicleta> findByModeloSQL(String modelo);

    @Query(value = "SELECT * FROM bicicletas WHERE marca=?1", nativeQuery = true)
    List<Bicicleta> findByMarcaSQL(String marca);

    @Query(value = "SELECT * FROM bicicletas WHERE color=?1", nativeQuery = true)
    List<Bicicleta> findByColorSQL(String color);

    @Query(value = "SELECT * FROM bicicletas WHERE tipo=?1", nativeQuery = true)
    List<Bicicleta> findByTipoSQL(String tipo);
}
