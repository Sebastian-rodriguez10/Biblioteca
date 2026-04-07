package GestorDeDatos;

import java.time.Year;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entidades.Libro;
import Logica.Coordinador;

public class GestionLibros {

    private ArrayList<Libro> libros = new ArrayList<>();
    private Coordinador mCoordinador;
    public GestionLibros(){
        libros.add(new Libro("CA1","Cien años de soledad", "Gabriel García Márquez", 1967,"diponible"));
        libros.add(new Libro("A19","1984", "George Orwell", 1949,"No disponible"));
        libros.add(new Libro("PR1","El Principito", "Antoine de Saint-Exupéry", 1943,"diponible"));
    }
    


    // get
    public ArrayList<Libro> getLibros() {
         // 2. "Quemar" los datos usando el método add()
        
    return libros;
}

    // Registrar libro
    public void registrarLibro(String isbn, String titulo, String autor, int año, String estado) {

        int añoActual = Year.now().getValue();

        if (isbn==""|| titulo==""|| autor=="" || estado=="") {
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
                JOptionPane.showMessageDialog(null, "Error: El ISBN ya existe.");
                return;
            }
        }

        Libro libro = new Libro(isbn, titulo, autor, año, estado);
        libros.add(libro);

        System.out.println("Libro registrado correctamente.");
        JOptionPane.showMessageDialog(null, "Libro registrado correctamente.");
    }

    // Listar libros
    public ArrayList<Libro> listarLibros() {
        //ArrayList<Libro> listaLibros=new ArrayList<Libro>();
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            JOptionPane.showMessageDialog(null, "No hay libros registrados");
            return new ArrayList<Libro>();
        }

        for (Libro libro : libros) {
            System.out.println(libro);
            return libros;
        }
        return libros;
    }

    // Buscar libro por ISBN
    public Libro buscarLibro(String isbn) {

        Libro nuLibro = null;

        for (Libro libro : libros) {

            if (libro.getIsbn().equals(isbn)) {
                System.out.println(libro);
                System.out.println("Libro encontrado.");
                return libro;
            }
        }
        return nuLibro;

        //System.out.println("Libro no encontrado.");
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
                JOptionPane.showMessageDialog(null, "Libro eliminado correctamente.");
                System.out.println("Libro eliminado correctamente.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Libro no encontrado.");
        System.out.println("Libro no encontrado.");
    }

    public void setCoordinador(Coordinador mCoordinador){
        this.mCoordinador = mCoordinador;
    }
}
