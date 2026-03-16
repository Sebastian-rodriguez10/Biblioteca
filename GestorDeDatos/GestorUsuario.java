package GestorDeDatos;

import java.util.ArrayList;

import Entidades.Usuario;

public class GestorUsuario {
    // Lista donde se guarda los usuarios
    private ArrayList<Usuario> listaUsuarios;
    public GestorUsuario() {
        listaUsuarios = new ArrayList<>();
    }
    // Método para registrar usuario
    public String registrarUsuario(Usuario usuario) {
        // Que se ingresen todos los campos
        if (usuario.getDocumento() == 0 || usuario.getNombreCompleto() == null || usuario.getNombreCompleto().isEmpty() || usuario.getTipoUsuario() == null || usuario.getTipoUsuario().isEmpty()) {
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
    public void listarUsuarios() {
        if (listaUsuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (Usuario usuario : listaUsuarios) {
                System.out.println("Documento: " + usuario.getDocumento());
                System.out.println("Nombre: " + usuario.getNombreCompleto());
                System.out.println("Tipo: " + usuario.getTipoUsuario());
                System.out.println("-----------------------------");
            }
        }
    }
    // Buscar
    public Usuario buscarUsuario(int documento) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getDocumento() == documento) {
                return usuario;
            }
        }
        return null;
    }
    // Eliminar
    public String eliminarUsuario(int documento) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getDocumento() == documento) {
                listaUsuarios.remove(usuario);
                return "Usuario eliminado correctamente.";
            }
        }
        return "No existe un usuario con ese documento.";
    }
}