package pe.com.bikerent.backend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name= "deliveries")
@Data
@NoArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String repartidor;
    private String fecha_envio;
    private String fecha_recojo;
    private String hora_envio;
    private String hora_recojo;
    private String direccion_envio;
    private String direccion_recojo;


    public Delivery(String nombreEncargado, String fechaEnvio, String fechaRecojo, String horaEnvio, String horaRecojo, String direccion_envio, String direccion_recojo) {
        this.repartidor = nombreEncargado;
        this.fecha_envio = fechaEnvio;
        this.fecha_recojo = fechaRecojo;
        this.hora_envio = horaEnvio;
        this.hora_recojo = horaRecojo;
        this.direccion_envio = direccion_envio;
        this.direccion_recojo = direccion_recojo;
    }
}
