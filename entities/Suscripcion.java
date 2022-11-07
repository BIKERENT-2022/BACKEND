package pe.com.bikerent.backend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "suscripciones")
@Data
@NoArgsConstructor
public class Suscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "tarjeta_id")
    private Tarjeta tarjeta;

    @OneToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String fechaInicio;
    private String fechaFin;


    public Suscripcion(Tarjeta tarjeta, Plan plan, Usuario usuario, String fechaInicio, String fechaFin) {
        this.tarjeta = tarjeta;
        this.plan = plan;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
}
