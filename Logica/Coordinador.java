package Logica;

import GestorDeDatos.GestionLibros;
import GestorDeDatos.GestorPrestamos;
import GestorDeDatos.GestorUsuario;
import vistas.VentanaAdministrador;
import vistas.VentanaBibliotecario;
import vistas.VentanaLogin;
import vistas.VentanaRegistro;
import vistas.VentanaUsuario;

public class Coordinador {
    private VentanaAdministrador mVentanaAdministrador;
    private VentanaLogin mLogin;
    private VentanaRegistro mVentanaRegistro;
    private VentanaBibliotecario mBibliotecario;
    private VentanaUsuario mVentanaUsuario;
    private GestionLibros mGestionLibros;
    private GestorPrestamos mGestorPrestamos;
    private GestorUsuario mGestorUsuario;

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

    /// motodos para hacer lo que tengas que hacer 

    public void visualisarVentanaPincipal() {
        mLogin.setVisible(true);
    }



}
