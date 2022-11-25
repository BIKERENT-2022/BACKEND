import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { LoginComponent } from './components/login/login.component';
import { SolicitudesComponent } from './components/solicitudes/solicitudes.component';
import { AceptarSolicitudComponent } from './components/aceptar-solicitud/aceptar-solicitud.component';
import { ClientesPremiumComponent } from './components/clientes-premium/clientes-premium.component';
import { PerfilPremiumComponent } from './components/perfil-premium/perfil-premium.component';
import { AngularMaterialModule } from './components/shared/angular-material/angular-material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BicicletasComponent } from './components/bicicletas/bicicletas.component';
import { RegistroComponent } from './components/registro/registro.component';
import { CambiarContrasenaComponent } from './components/cambiar-contrasena/cambiar-contrasena.component';
import { NotificacionesComponent } from './components/notificaciones/notificaciones.component';
import { HistorialComponent } from './components/historial/historial.component';
import { AlquilerEmpresasComponent } from './components/alquiler-empresas/alquiler-empresas.component';
import { ConfirmarInformacionComponent } from './components/confirmar-informacion/confirmar-informacion.component';
import { InfoBasicComponent } from './components/info-basic/info-basic.component';
import { InfoPremiumComponent } from './components/info-premium/info-premium.component';
import { NotificacionesEmpresasComponent } from './components/notificaciones-empresas/notificaciones-empresas.component';
import { PagoPremiumComponent } from './components/pago-premium/pago-premium.component';
import { PerfilEmpresasComponent } from './components/perfil-empresas/perfil-empresas.component';
import { PlanBasicComponent } from './components/plan-basic/plan-basic.component';
import { SolicitudTarjetaComponent } from './components/solicitud-tarjeta/solicitud-tarjeta.component';
import { HistorialAlqEmpresasComponent } from './components/historial-alq-empresas/historial-alq-empresas.component';
import { EmpresasPerfilComponent } from './components/empresas-perfil/empresas-perfil.component';
import { SearchComponent } from './components/search/search.component';
import { RegistrarOModificarComponent } from './components/registrar-o-modificar/registrar-o-modificar.component';
import { MinibmxEComponent } from './components/minibmx-e/minibmx-e.component';
import { MinibmxCComponent } from './components/minibmx-c/minibmx-c.component';
import { GpsComponent } from './components/gps/gps.component';
import { FinalizarAlquilerComponent } from './components/finalizar-alquiler/finalizar-alquiler.component';
import { CarritoComponent } from './components/carrito/carrito.component';
import { AniadirModeloComponent } from './components/aniadir-modelo/aniadir-modelo.component';
import { VerPerfilComponent } from './components/ver-perfil/ver-perfil.component';
import { AlquilerRealizadoComponent } from './components/alquiler-realizado/alquiler-realizado.component';
import { CondicionesBasicComponent } from './components/condiciones-basic/condiciones-basic.component';
import { HomeComponent } from './components/home/home.component';
import { PagoBasicComponent } from './components/pago-basic/pago-basic.component';
import { AfiliarTarjetaComponent } from './components/afiliar-tarjeta/afiliar-tarjeta.component';
import { RegistrarUbicacionUnoComponent } from './components/registrar-ubicacion-uno/registrar-ubicacion-uno.component';
import { RegistrarUbicacionCuatroComponent } from './components/registrar-ubicacion-cuatro/registrar-ubicacion-cuatro.component';
import { RegistrarUbicacionCincoComponent } from './components/registrar-ubicacion-cinco/registrar-ubicacion-cinco.component';
import { VerPedidoComponent } from './components/ver-pedido/ver-pedido.component';
import { PedidosActivosComponent } from './components/pedidos-activos/pedidos-activos.component';
import { CondicionesEmpresaComponent } from './components/condiciones-empresa/condiciones-empresa.component';
import { PagoPlanComponent } from './components/pago-plan/pago-plan.component';
import { NavbarEmpresaComponent } from './components/navbar-empresa/navbar-empresa.component';
import { HomeEmpresaComponent } from './components/home-empresa/home-empresa.component';
import { RepartidoresComponent } from './components/repartidores/repartidores.component';
import { RepartidoresAgregarComponent } from './components/repartidores-agregar/repartidores-agregar.component';
import { RepartidoresEditarComponent } from './components/repartidores-editar/repartidores-editar.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    SolicitudesComponent,
    AceptarSolicitudComponent,
    ClientesPremiumComponent,
    PerfilPremiumComponent,
    BicicletasComponent,
    RegistroComponent,
    CambiarContrasenaComponent,
    NotificacionesComponent,
    HistorialComponent,
    AlquilerEmpresasComponent,
    ConfirmarInformacionComponent,
    InfoBasicComponent,
    InfoPremiumComponent,
    NotificacionesEmpresasComponent,
    PagoPremiumComponent,
    PerfilEmpresasComponent,
    PlanBasicComponent,
    SolicitudTarjetaComponent,
    HistorialAlqEmpresasComponent,
    EmpresasPerfilComponent,
    SearchComponent,
    RegistrarOModificarComponent,
    MinibmxEComponent,
    MinibmxCComponent,
    GpsComponent,
    FinalizarAlquilerComponent,
    CarritoComponent,
    AniadirModeloComponent,
    VerPerfilComponent,
    AlquilerRealizadoComponent,
    CondicionesBasicComponent,
    HomeComponent,
    PagoBasicComponent,
    AfiliarTarjetaComponent,
    RegistrarUbicacionUnoComponent,
    RegistrarUbicacionCuatroComponent,
    RegistrarUbicacionCincoComponent,
    VerPedidoComponent,
    PedidosActivosComponent,
    CondicionesEmpresaComponent,
    PagoPlanComponent,
    NavbarEmpresaComponent,
    HomeEmpresaComponent,
    RepartidoresComponent,
    RepartidoresAgregarComponent,
    RepartidoresEditarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AngularMaterialModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
