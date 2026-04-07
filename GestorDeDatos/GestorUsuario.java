package GestorDeDatos;

import java.util.ArrayList;

import Entidades.Libro;
import Entidades.Usuario;
import Logica.Coordinador;

public class GestorUsuario {
    // Lista donde se guardarán los usuarios
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private Coordinador mCoordinador;

    public GestorUsuario() {
        listaUsuarios.add(new Usuario("1010", "Carlos Perez", "administrador", "admin123"));
        listaUsuarios.add(new Usuario("2020", "Ana Gomez", "bibliotecario", "biblio123"));
        listaUsuarios.add(new Usuario("3030", "Juan Roa", "lector", "roa123"));
    }

    // get
    public ArrayList<Usuario>  getUsuarios() {
    return listaUsuarios;
}

    // Método para registrar usuario
    public String registrarUsuario(Usuario usuario) {
        // Que se ingresen todos los campos
        if (usuario.getDocumento().isEmpty() || usuario.getNombreCompleto().isEmpty()
                || usuario.getNombreCompleto().isEmpty() ||
                usuario.getTipoUsuario().isEmpty()) {
            return "Todos los campos son obligatorios";
        }
        // Verifica que no haya un documento repetido
        for (Usuario u : listaUsuarios) {
            if (u.getDocumento() == usuario.getDocumento()) {
                return "Ya existe un usuario con ese documento";
            }
        }
        // Valida el tipo de usuario
        if (!usuario.getTipoUsuario().equalsIgnoreCase("Administrador")
                && !usuario.getTipoUsuario().equalsIgnoreCase("Bibliotecario")
                && !usuario.getTipoUsuario().equalsIgnoreCase("Lector")) {
            return "Tipo de usuario no válido";
        } else {
            // ingresa el usuario a la lista
            listaUsuarios.add(usuario);
            return "Usuario registrado correctamente.";
        }
    }

    // mostrar la lista
    public ArrayList<Usuario> listarUsuarios() {

        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            for (Usuario usuario : listaUsuarios) {
                System.out.println("Documento: " + usuario.getDocumento());
                System.out.println("Nombre: " + usuario.getNombreCompleto());
                System.out.println("Tipo: " + usuario.getTipoUsuario());
                System.out.println("-----------------------------");
            }
        }
        return listaUsuarios;
    }

    // Buscar
    public Usuario buscarUsuario(String documento) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getDocumento().equals(documento)) {
                return usuario;
            }
        }
        return null;
    }

    // Eliminar
    public String eliminarUsuario(String documento) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getDocumento() == documento) {
                listaUsuarios.remove(usuario);
                return "Usuario eliminado correctamente.";
            }
        }
        return "No existe un usuario con ese documento.";
    }

    public void setCoordinador(Coordinador mCoordinador) {
        this.mCoordinador = mCoordinador;
    }

}