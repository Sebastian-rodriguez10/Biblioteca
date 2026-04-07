package Logica;

import java.util.ArrayList;

import Entidades.Libro;
import Entidades.Prestamo;
import Entidades.Usuario;
import GestorDeDatos.GestionLibros;
import GestorDeDatos.GestorPrestamos;
import GestorDeDatos.GestorUsuario;
import vistas.*;

public class Coordinador {
    private VentanaAdministrador mVentanaAdministrador;
    private VentanaLogin mLogin;
    private VentanaRegistro mVentanaRegistro;
    private VentanaBibliotecario mBibliotecario;
    private VentanaUsuario mVentanaUsuario;
    private GestionLibros mGestionLibros;
    private GestorPrestamos mGestorPrestamos;
    private GestorUsuario mGestorUsuario;
    private VentanaPrestamos mVentanaPrestamos;
    private VentanaListaUsuarios mVentanaListaUsuarios;

    public void setVentanaRegistro(VentanaRegistro mVentanaRegistro) {
        this.mVentanaRegistro = mVentanaRegistro;
    }

    public void setVentanaLogin(VentanaLogin mLogin) {
        this.mLogin = mLogin;
    }

    public void setVentanaAdministrador(VentanaAdministrador mVentanaAdministrador) {
        this.mVentanaAdministrador = mVentanaAdministrador;
    }

    public void setBibliotecario(VentanaBibliotecario mBibliotecario) {
        this.mBibliotecario = mBibliotecario;
    }

    public void setVentanaUsuario(VentanaUsuario mVentanaUsuario) {
        this.mVentanaUsuario = mVentanaUsuario;
    }

    public void setGestionLibros(GestionLibros mGestionLibros) {
        this.mGestionLibros = mGestionLibros;
    }

    public void setGestorPrestamo(GestorPrestamos mGestorPrestamos) {
        this.mGestorPrestamos = mGestorPrestamos;
    }

    public void setGestorsuario(GestorUsuario mGestorUsuario) {
        this.mGestorUsuario = mGestorUsuario;
    }

    public void setVentanaPrestamos(VentanaPrestamos vp) {
        this.mVentanaPrestamos = vp;
    }

    public void setVentanaListarUsuario(VentanaListaUsuarios mVentanaListaUsuarios) {
        this.mVentanaListaUsuarios = mVentanaListaUsuarios;
    }

    // ================= VISTAS =================

    public void mostrarLogin() {
        mLogin.setVisible(true);
    }

    public void mostrarRegistro() {
        mVentanaRegistro.setVisible(true);
        mLogin.setVisible(false);
    }

    public void mostrarAdministrador() {
        mVentanaAdministrador.setVisible(true);
        mLogin.setVisible(false);
    }

    public void mostrarBibliotecario() {
        mBibliotecario.setVisible(true);
        mLogin.setVisible(false);
    }

    public void mostrarUsuario() {
        mVentanaUsuario.setVisible(true);
        mLogin.setVisible(false);
    }

    public void mostrarVentanaPrestamos() {
        mVentanaPrestamos.setVisible(true);
        mVentanaAdministrador.setVisible(false);
        mBibliotecario.setVisible(false);
    }

    public void mostrarPrestamosDesdeAdmin() {
        mVentanaPrestamos.setOrigen("admin");
        mVentanaPrestamos.setVisible(true);
        mVentanaAdministrador.setVisible(false);
    }

    public void mostrarPrestamosDesdeBiblio() {
        mVentanaPrestamos.setOrigen("biblio");
        mVentanaPrestamos.setVisible(true);
        mBibliotecario.setVisible(false);
    }

    public void mostrarVentanaListaUsuariosDesdeAdmin() {
        mVentanaListaUsuarios.setOrigen("admin");
        mVentanaListaUsuarios.setVisible(true);
        mVentanaAdministrador.setVisible(false);
    }
    public void mostrarVentanaListaUsuariosDesdeBiblio() {
        mVentanaListaUsuarios.setOrigen("biblio");
        mVentanaListaUsuarios.setVisible(true);
        mBibliotecario.setVisible(false);
    }

    

    /// motodos para hacer lo que tengas que hacer

    public void visualisarVentanaPincipal() {
        mLogin.setVisible(true);
    }

    /// ------------------Bibliotecario
    /// -------------------------------------------------------
    public ArrayList<Libro> listarLibros() {
        return mGestionLibros.listarLibros();
    }

    public Libro buscarLibro(String isbn) {
        return mGestionLibros.buscarLibro(isbn);
    }

    public ArrayList<Usuario> listarUsuario() {
        return mGestorUsuario.listarUsuarios();
    }

    public  Usuario buscarUsuario(String documento){
        return mGestorUsuario.buscarUsuario(documento);
    }

    public String eliminarUsuario(String doc) {
        return mGestorUsuario.eliminarUsuario(doc);
    }

    public void registrarPrestamo(Usuario u, Libro l, boolean b) {
        // TODO Auto-generated method stub
        mGestorPrestamos.registrarPrestamo(u, l, b);;
    }

    public ArrayList<Prestamo> listaPrestamos() {
        return mGestorPrestamos.listarPrestamos();
    }

    public void registrarDevolucion(String documento, String isbn) {
        mGestorPrestamos.registrarDevolucion(documento, isbn);
    }

}
