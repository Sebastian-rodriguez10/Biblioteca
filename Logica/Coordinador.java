package Logica;

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



    /// motodos para hacer lo que tengas que hacer 

    public void visualisarVentanaPincipal() {
        mLogin.setVisible(true);
    }



}
