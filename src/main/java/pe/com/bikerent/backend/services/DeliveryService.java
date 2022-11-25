package pe.com.bikerent.backend.services;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import pe.com.bikerent.backend.entities.Delivery;

import java.util.List;

public interface DeliveryService {
    public Delivery createDeliveryS(Delivery delivery);
    public Delivery updateDeliveryByIdS(Long id, Delivery delivery);
    public List<Delivery> getAllDeliveriesS();
    public Delivery getDeliveryByIdS(Long id);
    public List<Delivery> getALLDeliveriesByRepartidorS(String nombre);
}
