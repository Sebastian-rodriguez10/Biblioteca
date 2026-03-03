package GestorDeDatos;
import java.util.HashMap;

import Entidades.Usuario;

public class GestorUsuario {

    private HashMap<Integer, Usuario> usuariosMap;

    public GestorUsuario() {
        usuariosMap = new HashMap<>();
    }

    // Método para registrar usuario
    public String registrarUsuario(Usuario usuario) {
    // Que se ingresr todos los campos
        if (usuario.getDocumento() == 0 ||
            usuario.getNombreCompleto() == null || usuario.getNombreCompleto().isEmpty() ||
            usuario.getTipoUsuario() == null || usuario.getTipoUsuario().isEmpty()) {

            return "Todos los campos son obligatorios";
        } // Verifica que no haya un documento repetido
        else if (usuariosMap.containsKey(usuario.getDocumento())) {
            return "Ya existe un usuario con ese documento";
        }// Valida el tipo de usuario
        else if (!usuario.getTipoUsuario().equalsIgnoreCase("Administrador") &&!usuario.getTipoUsuario().equalsIgnoreCase("Bibliotecario") &&!usuario.getTipoUsuario().equalsIgnoreCase("Lector")) {
            return "Tipo de usuario no válido";

        } else {
                //ingresa el usuacrio
            usuariosMap.put(usuario.getDocumento(), usuario);
            return "Usuario registrado correctamente.";
        }
    }
}