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
                delivery.getNombre(),
                delivery.getDni(),
                delivery.getApellido(),
                delivery.getNombre(),
                delivery.getCelular()));
        return newDelivery;
    }

    @Transactional
    public Delivery updateDeliveryByIdS(Long id, Delivery delivery){
        Delivery foundDelivery = deliveryRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found delivery with id="+id));

        if (delivery.getNombre()!=null)
            foundDelivery.setNombre(delivery.getNombre());
        if (delivery.getDni()!=null)
            foundDelivery.setDni(delivery.getDni());
        if (delivery.getApellido()!=null)
            foundDelivery.setApellido(delivery.getApellido());
        if (delivery.getNombre()!=null)
            foundDelivery.setNombre(delivery.getNombre());
        if (delivery.getCelular()!=null)
            foundDelivery.setCelular(delivery.getCelular());


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

    public List<Delivery> getALLDeliveriesByRepartidorS(String nombre){
        List<Delivery> deliveries = deliveryRepository.findByRepartidorSQL(nombre);
        return deliveries;
    }

}
