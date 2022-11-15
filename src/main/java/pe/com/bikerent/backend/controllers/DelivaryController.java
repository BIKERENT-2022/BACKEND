package pe.com.bikerent.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.bikerent.backend.entities.*;
import pe.com.bikerent.backend.exceptions.ResourceNotFoundException;
import pe.com.bikerent.backend.repositories.DeliveryRepository;
import pe.com.bikerent.backend.services.DeliveryService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DelivaryController {

    /*@Autowired
    private DeliveryRepository deliveryRepository;*/
    @Autowired
    private DeliveryService deliveryService;

    /*----------------------------------------------------- CREAR DELIVERY -----------------------------------------------------*/
    @PostMapping("/deliveries")
    public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery) {
        Delivery newDelivery = deliveryService.createDeliveryS(new Delivery(
                delivery.getRepartidor(),
                delivery.getFecha_envio(),
                delivery.getFecha_recojo(),
                delivery.getHora_envio(),
                delivery.getHora_recojo(),
                delivery.getDireccion_envio(),
                delivery.getDireccion_recojo()));
        return new ResponseEntity<Delivery>(newDelivery, HttpStatus.CREATED);

        /*
        Delivery newDelivery = deliveryRepository.save(new Delivery(
                delivery.getRepartidor(),
                delivery.getFecha_envio(),
                delivery.getFecha_recojo(),
                delivery.getHora_envio(),
                delivery.getHora_recojo(),
                delivery.getDireccion_envio(),
                delivery.getDireccion_recojo()));
        return new ResponseEntity<Delivery>(newDelivery, HttpStatus.CREATED);
        */
    }



    /*----------------------------------------------------- ACTUALIZAR DELIVERY -----------------------------------------------------*/
    @PutMapping("/deliveries/{id}")
    public ResponseEntity<Delivery> updateDeliveryById(@PathVariable("id") Long id,@RequestBody Delivery delivery) {

        Delivery foundDelivery = deliveryService.updateDeliveryByIdS(id, delivery);
        return new ResponseEntity<Delivery>(foundDelivery, HttpStatus.OK);

        /*
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
        return new ResponseEntity<Delivery>(updatedDelivery, HttpStatus.OK);
        */
    }



    /*----------------------------------------------------- LISTA DE TODOS LOS DELIVERIES -----------------------------------------------------*/
    @GetMapping("/deliveries")
    public ResponseEntity<List<Delivery>> getAllDeliveries(){
        List<Delivery> deliveries = deliveryService.getAllDeliveriesS();
        if(deliveries.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Delivery>>(deliveries,HttpStatus.OK);

        /*
        List<Delivery> deliveries = deliveryRepository.findAll();
        if(deliveries.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Delivery e : deliveries) {
            //e.setBicicletas(null);
        }
        return new ResponseEntity<List<Delivery>>(deliveries,HttpStatus.OK);
        */
    }



    //---------------------- MOSTRAR DELIVERY SEGUN EL ID ---------------------
    @GetMapping("/deliveries/{id}")
    public ResponseEntity<Delivery> getDeliveryById(@PathVariable("id") Long id){
        Delivery delivery = deliveryService.getDeliveryByIdS(id);
        return new ResponseEntity<Delivery>(delivery, HttpStatus.OK);

        /*
        Delivery delivery = deliveryRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Not found delivery with id="+id));;
        return new ResponseEntity<Delivery>(delivery, HttpStatus.OK);
        */
    }



    /*---------------------- LISTAR DELIVERIRES SEGUN EL REPARTIDOR ---------------------*/
    @GetMapping("/deliveries/repartidor/{repartidor}")
    public ResponseEntity<List<Delivery>> getALLDeliveriesByRepartidor(@PathVariable("repartidor") String repartidor){
        List<Delivery> deliveries = deliveryService.getALLDeliveriesByRepartidorS(repartidor);
        if(deliveries.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Delivery>>(deliveries,HttpStatus.OK);

        /*
        List<Delivery> deliveries = deliveryRepository.findByRepartidorSQL(repartidor);
        if(deliveries.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Delivery>>(deliveries,HttpStatus.OK);
        */
    }

}
