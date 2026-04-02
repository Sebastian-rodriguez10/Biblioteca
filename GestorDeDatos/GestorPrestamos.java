package GestorDeDatos;

import Entidades.Libro;
import Entidades.Prestamo;
import Entidades.Usuario;
import Logica.Coordinador;
import java.util.ArrayList;

public class GestorPrestamos {

    private ArrayList<Prestamo> listaPrestamos;
    private Coordinador mCoordinador;

    public GestorPrestamos() {
        this.listaPrestamos = new ArrayList<>();
    }

    // Registrar prestamo:
    public void registrarPrestamo(Usuario u, Libro l, boolean status) {
        Prestamo prestamo = new Prestamo(u, l, status);
        listaPrestamos.add(prestamo);
    }

    // Consultar prestamos activos:
    public void consultarPrestamo() {
        if (listaPrestamos.isEmpty()) {
            System.out.println("\nNO HAY PRESTAMOS REGISTRADOS.");
        } else {
            System.out.println("\n>>>>>> PRESTAMOS ACTIVOS <<<<<<");
            for (Prestamo p : listaPrestamos) {
                if (p.isEstado()) {
                    System.out.print("\n\n-Nombre del usuario: " + p.getUsuario().getNombreCompleto());
                    System.out.print("-Documento del usuario: " + p.getUsuario().getDocumento());
                    System.out.print("-Título del libro: " + p.getLibro().getTitulo());
                    System.out.print("-ISBN del libro: " + p.getLibro().getIsbn());
                }
            }
        }
    }

    // Registrar devolución:
    public void registrarDevolucion(String documento) {
        int acumulador = 0;
        boolean valor = false;
        do {
            if (acumulador == listaPrestamos.size()) {
                System.out.println("\nNO SE ENCONTRÓ UN PRESTAMO RELACIONADO CON EL DOCUMENTO ESCRITO.");
                valor = true;
            } else if (listaPrestamos.get(acumulador).getUsuario().getDocumento() == documento) {
                System.out.println("\nDATOS DEL PRESTAMO:");
                System.out.print(
                        "\n\n-Nombre del usuario: " + listaPrestamos.get(acumulador).getUsuario().getDocumento());
                System.out.print(
                        "-Documento del usuario: " + listaPrestamos.get(acumulador).getUsuario().getNombreCompleto());
                System.out.print("-Título del libro: " + listaPrestamos.get(acumulador).getLibro().getTitulo());
                System.out.print("-ISBN del libro: " + listaPrestamos.get(acumulador).getLibro().getIsbn());
                listaPrestamos.get(acumulador).setEstado(false);
                System.out.println("-Estado actual del prestamo: Devuelto.");
                valor = true;
            } else {
                acumulador++;
            }
        } while (!valor);
    }

    public void setCoordinador(Coordinador mCoordinador){
        this.mCoordinador = mCoordinador;
    }
}
