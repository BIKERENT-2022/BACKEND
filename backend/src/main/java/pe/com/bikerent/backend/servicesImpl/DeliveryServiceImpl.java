package pe.com.bikerent.backend.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.bikerent.backend.entities.Delivery;
import pe.com.bikerent.backend.exceptions.ResourceNotFoundException;
import pe.com.bikerent.backend.repositories.DeliveryRepository;
import pe.com.bikerent.backend.services.DeliveryService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;


    @Transactional
    public Delivery createDeliveryS(Delivery delivery){
        Delivery newDelivery = deliveryRepository.save(new Delivery(
                delivery.getRepartidor(),
                delivery.getFecha_envio(),
                delivery.getFecha_recojo(),
                delivery.getHora_envio(),
                delivery.getHora_recojo(),
                delivery.getDireccion_envio(),
                delivery.getDireccion_recojo()));
        return newDelivery;
    }

    @Transactional
    public Delivery updateDeliveryByIdS(Long id, Delivery delivery){
        Delivery foundDelivery = deliveryRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found delivery with id="+id));

        if (delivery.getRepartidor()!=null)
            foundDelivery.setRepartidor(delivery.getRepartidor());
        if (delivery.getFecha_envio()!=null)
            foundDelivery.setFecha_envio(delivery.getFecha_envio());
        if (delivery.getFecha_recojo()!=null)
            foundDelivery.setFecha_recojo(delivery.getFecha_recojo());
        if (delivery.getHora_envio()!=null)
            foundDelivery.setHora_envio(delivery.getHora_envio());
        if (delivery.getHora_recojo()!=null)
            foundDelivery.setHora_recojo(delivery.getHora_recojo());
        if (delivery.getDireccion_envio()!=null)
            foundDelivery.setDireccion_envio(delivery.getDireccion_envio());
        if (delivery.getDireccion_recojo()!=null)
            foundDelivery.setDireccion_recojo(delivery.getDireccion_recojo());


        Delivery updatedDelivery = deliveryRepository.save(foundDelivery);
        return updatedDelivery;
    }

    public List<Delivery> getAllDeliveriesS(){
        List<Delivery> deliveries = deliveryRepository.findAll();
        for (Delivery e : deliveries) {
            //e.setBicicletas(null);
        }
        return deliveries;
    }

    public Delivery getDeliveryByIdS(Long id){
        Delivery delivery = deliveryRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found delivery with id="+id));;
        return delivery;
    }

    public List<Delivery> getALLDeliveriesByRepartidorS(String repartidor){
        List<Delivery> deliveries = deliveryRepository.findByRepartidorSQL(repartidor);
        return deliveries;
    }

}
