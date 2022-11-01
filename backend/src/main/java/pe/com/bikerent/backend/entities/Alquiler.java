package pe.com.bikerent.backend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "alquileres")
@Data
@NoArgsConstructor
public class Alquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String plazo;
    private String fecha;
    private String hora;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    @ManyToOne
    @JoinColumn(name = "bicicleta_id")
    private Bicicleta bicicleta;

    @OneToOne
    @JoinColumn(name = "estado_id")
    private EstadoAlquiler estadoAlquiler;

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;


    public Alquiler(String plazo, String fecha, String hora, Cliente cliente, Bicicleta bicicleta, EstadoAlquiler estadoAlquiler, Delivery delivery) {
        this.plazo = plazo;
        this.fecha = fecha;
        this.hora = hora;
        this.cliente = cliente;
        this.bicicleta = bicicleta;
        this.estadoAlquiler = estadoAlquiler;
        this.delivery = delivery;
    }
}
