package Logica;

import GestorDeDatos.GestionLibros;
import GestorDeDatos.GestorPrestamos;
import GestorDeDatos.GestorUsuario;
import vistas.VentanaAdministrador;
import vistas.VentanaBibliotecario;
import vistas.VentanaLogin;
import vistas.VentanaRegistro;
import vistas.VentanaUsuario;

public class Relaciones {

    public Relaciones(){
        String wi = "Dana";
VentanaRegistro mVentanaRegistro = new VentanaRegistro();
    VentanaLogin mLogin = new VentanaLogin();
    GestionLibros mGestionLibros = new GestionLibros();
    GestorUsuario mGestorUsuario = new GestorUsuario();
    GestorPrestamos mGestorPrestamos = new GestorPrestamos();
    Coordinador mCoordinador = new Coordinador();
    VentanaAdministrador mVentanaAdministrador = new VentanaAdministrador(mGestorUsuario,mGestionLibros);
    VentanaBibliotecario mBibliotecario = new VentanaBibliotecario(mGestorUsuario,mGestionLibros);
    VentanaUsuario mVentanaUsuario = new VentanaUsuario(wi, mGestionLibros);

    // Relacionando las clases unicas con el coordinador
    mVentanaRegistro.setCoordinador(mCoordinador);
    mLogin.setCoordinador(mCoordinador);
    mVentanaAdministrador.setCoordinador(mCoordinador);
    mBibliotecario.setCoordinador(mCoordinador);
    mVentanaUsuario.setCoordinador(mCoordinador);
    mGestionLibros.setCoordinador(mCoordinador);
    mGestorUsuario.setCoordinador(mCoordinador);
    mGestorPrestamos.setCoordinador(mCoordinador);

    //Relacionando el coordinador con las clases
    mCoordinador.setVentanaRegistro(mVentanaRegistro);
    mCoordinador.setVentanaLogin(mLogin);
    mCoordinador.setVentanaAdministrador(mVentanaAdministrador);
    mCoordinador.setBibliotecario(mBibliotecario);
    mCoordinador.setVentanaUsuario(mVentanaUsuario);
    mCoordinador.setGestionLibros(mGestionLibros);
    mCoordinador.setGestorsuario(mGestorUsuario);
    mCoordinador.setGestorPrestamo(mGestorPrestamos);

    // metodo para que sea visible la ventana principal

    mCoordinador.visualisarVentanaPincipal();

    }

    
}
