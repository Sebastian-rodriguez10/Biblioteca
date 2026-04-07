package GestorDeDatos;

import Entidades.Libro;
import Entidades.Prestamo;
import Entidades.Usuario;
import Logica.Coordinador;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
    public void registrarDevolucion(String documento, String isbn) {
        boolean noHayDevo = false;
        for (Prestamo prestamo : listaPrestamos) {
            if(prestamo.getLibro().getIsbn().equals(isbn)&&prestamo.getUsuario().getDocumento().equals(documento)&&!prestamo.getLibro().getEstado().equals("diponible")){
                prestamo.getLibro().setEstado("diponible");
                prestamo.getUsuario().bajarPrestamos();
                System.out.println("wi");
                JOptionPane.showMessageDialog(null, "Se devolvio correctamente");
                return;
            }else{
                
                noHayDevo = true;
                System.out.println("EmpanadAS");
            }
        }
        if (noHayDevo) {
            JOptionPane.showMessageDialog(null, "No hay devoluciones con ese isbn");
            return;
        }
    
    }
    //est
    // Listar todos los pramos:
public ArrayList<Prestamo> listarPrestamos() {

    if (listaPrestamos.isEmpty()) {
        System.out.println("No hay préstamos registrados.");
        JOptionPane.showMessageDialog(null,"No hay prestamos registrados");
        
    } else {
        // for (Prestamo prestamo : listaPrestamos) {
        //     System.out.println("Documento: " + prestamo.getUsuario().getDocumento());
        //     System.out.println("Nombre: " + prestamo.getUsuario().getNombreCompleto());
        //     System.out.println("Libro: " + prestamo.getLibro().getTitulo());
        //     System.out.println("ISBN: " + prestamo.getLibro().getIsbn());
        //     System.out.println("Estado: " + (prestamo.isEstado() ? "Activo" : "Devuelto"));
        //     System.out.println("-----------------------------");
        // }
        JOptionPane.showMessageDialog(null,"Admira la lista");
    }

    return listaPrestamos;
}

    public void setCoordinador(Coordinador mCoordinador){
        this.mCoordinador = mCoordinador;
    }
}
