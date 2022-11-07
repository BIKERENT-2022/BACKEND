package pe.com.bikerent.backend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "estadoAlquileres")
@Data
@NoArgsConstructor
public class EstadoAlquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estado;

    public EstadoAlquiler(String estado) {
        this.estado = estado;
    }
}
