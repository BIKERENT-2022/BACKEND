package pe.com.bikerent.backend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "tarjetas")
@Data
@NoArgsConstructor
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private String nombreCompleto;
    private String fechaCaducidad;
    private String cvv;

    public Tarjeta(String numero, String nombreCompleto, String fechaCaducidad, String cvv) {
        this.numero = numero;
        this.nombreCompleto = nombreCompleto;
        this.fechaCaducidad = fechaCaducidad;
        this.cvv = cvv;
    }
}
