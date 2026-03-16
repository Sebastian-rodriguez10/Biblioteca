package GestorDeDatos;

import java.time.Year;
import java.util.ArrayList;

import Entidades.Libro;

public class GestionLibros {

    private ArrayList<Libro> libros = new ArrayList<>();

    // Registrar libro
    public void registrarLibro(String isbn, String titulo, String autor, int año, String estado) {

        int añoActual = Year.now().getValue();

        if (isbn.isEmpty() || titulo.isEmpty() || autor.isEmpty() || estado.isEmpty()) {
            System.out.println("Ningún campo puede estar vacío.");
            return;
        }

        if (año > añoActual) {
            System.out.println("El año no puede ser mayor al actual.");
            return;
        }

        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                System.out.println("Error: El ISBN ya existe.");
                return;
            }
        }

        Libro libro = new Libro(isbn, titulo, autor, año, estado);
        libros.add(libro);

        System.out.println("Libro registrado correctamente.");
    }

    // Listar libros
    public void listarLibros() {

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    // Buscar libro por ISBN
    public void buscarLibro(String isbn) {

        for (Libro libro : libros) {

            if (libro.getIsbn().equals(isbn)) {
                System.out.println(libro);
                return;
            }
        }

        System.out.println("Libro no encontrado.");
    }

    // Actualizar disponibilidad
    public void actualizarEstado(String isbn, String estadoNuevo) {

        for (Libro libro : libros) {

            if (libro.getIsbn().equals(isbn)) {

                libro.setEstado(estadoNuevo);
                System.out.println("Estado actualizado correctamente.");
                return;
            }
        }

        System.out.println("Libro no encontrado.");
    }

    // Eliminar libro
    public void eliminarLibro(String isbn) {

        for (Libro libro : libros) {

            if (libro.getIsbn().equals(isbn)) {

                libros.remove(libro);
                System.out.println("Libro eliminado correctamente.");
                return;
            }
        }

        System.out.println("Libro no encontrado.");
    }
}
