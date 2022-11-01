package pe.com.bikerent.backend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "usuarios")
@Data
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String usuario;
    private String contrasenia;
    private String tipo_usuario;


    public Usuario(String usuario, String contrasenia, String tipo_usuario) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.tipo_usuario = tipo_usuario;
    }
}
