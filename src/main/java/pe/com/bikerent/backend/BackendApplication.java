package pe.com.bikerent.backend;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pe.com.bikerent.backend.entities.*;
import pe.com.bikerent.backend.repositories.*;


@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner mappingDemo(
            EmpresaRepository empresaRepository,
            BicicletaRepository bicicletaRepository,
            ClienteRepository clienteRepository,
            EstadoAlquilerRepository estadoAlquilerRepository,
            DeliveryRepository deliveryRepository,
            AlquilerRepository alquilerRepository,
            UsuarioRepository usuarioRepository,
            PlanRepository planRepository,
            TarjetaRepository tarjetaRepository,
            SuscripcionesRepository suscripcionesRepository
    ){
        return args -> {


            /* ----------------------------------------------------------------------------------------------- */
            /* ------------------- CREAR DATOS PARA LA TABLA USUARIO Y SU CLIENTE O EMPRESA------------------- */

            //----- Empresas
            Usuario usuario = new Usuario("pepito","pepito52","Empresa");
            usuarioRepository.save(usuario);
            switch (usuario.getTipo_usuario()){
                case "Empresa": empresaRepository.save(new Empresa(usuario.getId(),"123","Pepe Gonzales","pepegonzales@hotmail.com","flores paradero 7,sjl","123456789","a")); break;
                case "Cliente": clienteRepository.save(new Cliente(usuario.getId(),"456","Pepe Gonzales","pepegonzales@hotmail.com","flores paradero 7","123456789","a")); break;
            }

            Usuario usuario3 = new Usuario("carlitos","carlitos52","Empresa");
            usuarioRepository.save(usuario3);
            switch (usuario3.getTipo_usuario()){
                case "Empresa": empresaRepository.save(new Empresa(usuario3.getId(),"142","Carlos Peres","carlosperes@hotmail.com","flores paradero 9, sjl","147258369","c")); break;
                case "Cliente": clienteRepository.save(new Cliente(usuario3.getId(),"122","Carlos Peres","carlosperes@hotmail.com","flores paradero 9","147258369","c")); break;
            }

            Usuario usuario5 = new Usuario("alexito","alex76","Empresa");
            usuarioRepository.save(usuario5);
            switch (usuario5.getTipo_usuario()){
                case "Empresa": empresaRepository.save(new Empresa(usuario5.getId(),"762","Alex Leslo","alexleslo@hotmail.com","flores paradero 11","258369741","o")); break;
                case "Cliente": clienteRepository.save(new Cliente(usuario5.getId(),"762","Alex Leslo","alexleslo@hotmail.com","flores paradero 11","258369741","o")); break;
            }



            //----- Clientes
            Usuario usuario2 = new Usuario("pedro","pedroo52","Cliente");
            usuarioRepository.save(usuario2);
            switch (usuario2.getTipo_usuario()){
                case "Empresa": empresaRepository.save(new Empresa(usuario2.getId(),"789","Pedro Castillo","pedrocastillo@hotmail.com","flores paradero 8","987654321","b")); break;
                case "Cliente": clienteRepository.save(new Cliente(usuario2.getId(),"111","Pedro Castillo","pedrocastillo@hotmail.com","flores paradero 8","987654321","b")); break;
            }

            Usuario usuario4 = new Usuario("diegooo","diego76","Cliente");
            usuarioRepository.save(usuario4);
            switch (usuario4.getTipo_usuario()){
                case "Empresa": empresaRepository.save(new Empresa(usuario4.getId(),"789","Diego Casaverde","diegocasaverde@hotmail.com","flores paradero 10","369258147","d")); break;
                case "Cliente": clienteRepository.save(new Cliente(usuario4.getId(),"222","Diego Casaverde","diegocasaverde@hotmail.com","flores paradero 10","369258147","d")); break;
            }

            Usuario usuario6 = new Usuario("saullll","saul76","Cliente");
            usuarioRepository.save(usuario6);
            switch (usuario4.getTipo_usuario()){
                case "Empresa": empresaRepository.save(new Empresa(usuario6.getId(),"7489","saul saul","saul@hotmail.com","flores paradero 14","369253577","e")); break;
                case "Cliente": clienteRepository.save(new Cliente(usuario6.getId(),"3221","saul saul","saul@hotmail.com","flores paradero 14","364258147","e")); break;
            }



            /* ---------------------------------------------------------------------------- */
            /* ------------------- CREAR DATOS PARA LA TABLA BICICLETAS ------------------- */
            Bicicleta bicicleta = new Bicicleta("BMX","Cube bike","Black","electrica","a",empresaRepository.getReferenceById(1L));
            bicicletaRepository.save(bicicleta);

            Bicicleta bicicleta2 = new Bicicleta("BMX","Bike Trek","Red","electrica","b",empresaRepository.getReferenceById(1L));
            bicicletaRepository.save(bicicleta2);

            Bicicleta bicicleta3 = new Bicicleta("Mini BMX","Scott bikes","White","plegable","c",empresaRepository.getReferenceById(2L));
            bicicletaRepository.save(bicicleta3);
            Bicicleta bicicleta4 = new Bicicleta("Montaniera","Cannodale","Yellow","electrica","d",empresaRepository.getReferenceById(2L));
            bicicletaRepository.save(bicicleta4);

            Bicicleta bicicleta5 = new Bicicleta("Campera","Cube bike","Red","plegable","e",empresaRepository.getReferenceById(2L));
            bicicletaRepository.save(bicicleta5);

            Bicicleta bicicleta6 = new Bicicleta("Campera","Scott bikes","Orange","plegable","f",empresaRepository.getReferenceById(3L));
            bicicletaRepository.save(bicicleta6);



            /* ------------------- CREAR DATOS PARA LA TABLA ESTADO DE ALQUILER ------------------- */
            EstadoAlquiler estadoAlquiler = new EstadoAlquiler("En revision");
            estadoAlquilerRepository.save(estadoAlquiler);

            EstadoAlquiler estadoAlquiler1 = new EstadoAlquiler("Aceptado");
            estadoAlquilerRepository.save(estadoAlquiler1);

            EstadoAlquiler estadoAlquiler2 = new EstadoAlquiler("En camino");
            estadoAlquilerRepository.save(estadoAlquiler2);

            EstadoAlquiler estadoAlquiler3 = new EstadoAlquiler("Entregado");
            estadoAlquilerRepository.save(estadoAlquiler3);

            EstadoAlquiler estadoAlquiler4 = new EstadoAlquiler("Finalizado");
            estadoAlquilerRepository.save(estadoAlquiler4);


            /*------------------- CREAR DATOS PARA LA TABLA DELIVERY-------------------*/
            Delivery delivery = new Delivery("pedro","1/01/2022","2/1/2022","18:00","20:00","sjl","sjl");
            deliveryRepository.save(delivery);

            Delivery delivery2 = new Delivery("maria","2/1/2022","3/1/2022","19:00","21:00","san borja","san borja");
            deliveryRepository.save(delivery2);

            Delivery delivery3 = new Delivery("marta","3/1/2022","4/1/2022","18:00","22:00","Molina","Molina");
            deliveryRepository.save(delivery3);



            /*------------------- CREAR DATOS PARA LA TABLA ALQUILERES -------------------*/
            Alquiler alquiler = new Alquiler("30 dias","01/01/2022","18:00",clienteRepository.getReferenceById(4L),bicicleta,estadoAlquiler,delivery);
            alquilerRepository.save(alquiler);
            Alquiler alquiler2 = new Alquiler("45 dias","01/01/2022","18:00",clienteRepository.getReferenceById(4L),bicicleta2,estadoAlquiler2,delivery);
            alquilerRepository.save(alquiler2);

            Alquiler alquiler3 = new Alquiler("30 dias","02/01/2022","19:00",clienteRepository.getReferenceById(5L),bicicleta3,estadoAlquiler2,delivery2);
            alquilerRepository.save(alquiler3);
            Alquiler alquiler4 = new Alquiler("30 dias","02/01/2022","19:00",clienteRepository.getReferenceById(5L),bicicleta4,estadoAlquiler2,delivery2);
            alquilerRepository.save(alquiler4);
            Alquiler alquiler5 = new Alquiler("30 dias","02/01/2022","19:00",clienteRepository.getReferenceById(5L),bicicleta5,estadoAlquiler,delivery2);
            alquilerRepository.save(alquiler5);

            Alquiler alquiler6 = new Alquiler("30 dias","03/01/2022","19:00",clienteRepository.getReferenceById(6L),bicicleta,estadoAlquiler2,delivery3);
            alquilerRepository.save(alquiler6);



            /*------------------- CREAR DATOS PARA LA TABLA PLAN-------------------*/
            Plan plan = new Plan("Basic");
            planRepository.save(plan);

            Plan plan2 = new Plan("Premium");
            planRepository.save(plan2);

            Plan plan3 = new Plan("Empresa");
            planRepository.save(plan3);



            /*------------------- CREAR DATOS PARA LA TABLA TARJETA-------------------*/
            Tarjeta tarjeta = new Tarjeta("1234567891012131","pedro","5/5/2022","123");
            tarjetaRepository.save(tarjeta);

            Tarjeta tarjeta2 = new Tarjeta("9876543211012131","maria","5/6/2022","456");
            tarjetaRepository.save(tarjeta2);

            Tarjeta tarjeta3 = new Tarjeta("1472583691012131","jorge","5/8/2022","789");
            tarjetaRepository.save(tarjeta3);



            /* ------------------- CREAR DATOS PARA LA TABLA SUSCRIPCIONES-------------------*/
            Suscripcion suscripcion = new Suscripcion(tarjeta,plan,usuario,"25/02/2022","25/03/2022");
            suscripcionesRepository.save(suscripcion);

            Suscripcion suscripcion2 = new Suscripcion(tarjeta2,plan2,usuario2,"25/03/2022","25/04/2022");
            suscripcionesRepository.save(suscripcion2);

        };
    }
}
