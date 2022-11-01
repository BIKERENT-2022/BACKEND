package pe.com.bikerent.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.bikerent.backend.entities.Suscripcion;

public interface SuscripcionesRepository extends JpaRepository<Suscripcion,Long> {
}
