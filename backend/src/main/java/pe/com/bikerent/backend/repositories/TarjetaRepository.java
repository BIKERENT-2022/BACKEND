package pe.com.bikerent.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.bikerent.backend.entities.Tarjeta;

public interface TarjetaRepository extends JpaRepository<Tarjeta,Long> {
}
