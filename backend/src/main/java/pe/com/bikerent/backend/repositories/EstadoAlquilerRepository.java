package pe.com.bikerent.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.bikerent.backend.entities.EstadoAlquiler;

public interface EstadoAlquilerRepository extends JpaRepository<EstadoAlquiler,Long> {
}
