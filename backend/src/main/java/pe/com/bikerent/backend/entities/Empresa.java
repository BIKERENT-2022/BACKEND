package pe.com.bikerent.backend.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "empresas")
@Data
@NoArgsConstructor

public class Empresa {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@OneToOne
    //@JoinColumn(name = "usuario_id")
    //private Usuario usuario;

    private String ruc;
    private String nombre;
    private String correo;
    private String direccion;
    private String telefono;
    private String imagen;


    @JsonIgnore
    @OneToMany(mappedBy = "empresa")
    private List<Bicicleta> bicicletas;


    public Empresa(Long id, String ruc, String nombre, String correo, String direccion, String telefono, String imagen) {
        this.id = id;
        this.ruc = ruc;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.imagen = imagen;
    }
}
