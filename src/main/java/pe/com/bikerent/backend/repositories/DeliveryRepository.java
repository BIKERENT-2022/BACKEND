package pe.com.bikerent.backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.bikerent.backend.entities.Bicicleta;
import pe.com.bikerent.backend.entities.Delivery;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery,Long> {

    @Query(value = "SELECT * FROM deliveries WHERE repartidor=?1", nativeQuery = true)
    List<Delivery> findByRepartidorSQL(String repartidor);
}
