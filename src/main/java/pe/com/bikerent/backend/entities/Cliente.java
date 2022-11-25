package pe.com.bikerent.backend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "clientes")
@Data
@NoArgsConstructor

public class Cliente {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@OneToOne
    //@JoinColumn(name = "usuario_id")
    //private Usuario usuario;

    private String dni;
    private String nombre;
    private String correo;
    private String direccion;
    private String telefono;
    private String imagen;


    @OneToMany(mappedBy = "cliente")
    private List<Alquiler> alquileres;


    public Cliente(Long id, String dni, String nombre, String correo, String direccion, String telefono, String imagen) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.imagen = imagen;
    }
}
