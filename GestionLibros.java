import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class GestionLibros {

    private Map<String, Libro> libros = new HashMap<>();

    public void registrarLibro(String isbn, String titulo, String autor, int año, String estado) {

        int añoActual = Year.now().getValue();

        if (isbn.isEmpty() || titulo.isEmpty() || autor.isEmpty() || estado.isEmpty()) {
            System.out.println("Ningun campo puede estar vacio");
            return;
        }

        if (año > añoActual) {
            System.out.println("El año no puede ser mayor al actual");
            return;
        }

        if (libros.containsKey(isbn)) {
            System.out.println("El ISBN ya está registrado");
            return;
        }

        if (!estado.equalsIgnoreCase("Disponible") &&
            !estado.equalsIgnoreCase("Prestado")) {
            System.out.println("Estado invalido");
            return;
        }

        Libro libro = new Libro(isbn, titulo, autor, año, estado);
        libros.put(isbn, libro);

        System.out.println("Libro registrado correctamente");
    }

    public void listarLibros() {

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (Libro libro : libros.values()) {
            System.out.println(libro);
        }
    }

    public void buscarLibro(String isbn) {

        Libro libro = libros.get(isbn);

        if (libro != null) {
            System.out.println(libro);
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    public void actualizarEstado(String isbn, String nuevoEstado) {

        Libro libro = libros.get(isbn);

        if (libro == null) {
            System.out.println("Libro no encontrado");
            return;
        }

        if (!nuevoEstado.equalsIgnoreCase("Disponible") && !nuevoEstado.equalsIgnoreCase("Prestado")) {
            System.out.println("Estado inválido");
            return;
        }

        libro.setEstado(nuevoEstado);
        System.out.println("Estado actualizado correctamente.");
    }

    public void eliminarLibro(String isbn) {

        if (libros.remove(isbn) != null) {
            System.out.println("Libro eliminado correctamente");
        } else {
            System.out.println("Libro no encontrado");
        }
    }
}