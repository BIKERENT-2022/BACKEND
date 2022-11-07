package pe.com.bikerent.backend.entities;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "bicicletas")
@Data
@NoArgsConstructor
public class Bicicleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private String marca;
    private String color;
    private String tipo;
    private String imagen;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;



    @OneToMany(mappedBy = "bicicleta")
    private List<Alquiler> alquileres;

    public Bicicleta(String modelo, String marca, String color, String tipo, String imagen, Empresa empresa) {
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.tipo = tipo;
        this.imagen = imagen;
        this.empresa = empresa;
    }
}
