package pe.com.bikerent.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.bikerent.backend.entities.Alquiler;

public interface AlquilerRepository extends JpaRepository<Alquiler,Long> {
}
