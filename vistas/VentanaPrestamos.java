package vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Entidades.Libro;
import GestorDeDatos.GestionLibros;
import GestorDeDatos.GestorPrestamos;
import Logica.Coordinador;

import java.awt.event.*;

public class VentanaPrestamos extends JFrame implements ActionListener {

    private JPanel contentPane;

    private JTextArea areaLibros;
    private JTextField txtIsbn;
    private JTextField txtBuscarIsbn;
    private JTextField txtIdUsuario;

    private JButton btnMostrarLibros;
    private JButton btnRegistrarPrestamo;
    private JButton btnVolver;
    private JButton btnBuscarLibro;

    private GestionLibros gestionLibros;
    private GestorPrestamos gestorPrestamos;
    private Coordinador mCoordinador;
    private String origen;

    public VentanaPrestamos() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 500); // más grande

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        iniciarComponentes();
    }

    private void iniciarComponentes() {

        JLabel titulo = new JLabel("GESTIÓN DE PRÉSTAMOS");
        titulo.setBounds(180, 10, 300, 25);
        titulo.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 16));
        contentPane.add(titulo);

        // ===== AREA LIBROS =====
        JLabel lblLibros = new JLabel("Lista de Libros");
        lblLibros.setBounds(20, 40, 200, 20);
        contentPane.add(lblLibros);

        areaLibros = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaLibros);
        scroll.setBounds(20, 60, 540, 150);
        contentPane.add(scroll);

        // ===== BOTON MOSTRAR =====
        btnMostrarLibros = new JButton("Mostrar Libros");
        btnMostrarLibros.setBounds(20, 220, 200, 30);
        btnMostrarLibros.addActionListener(this);
        contentPane.add(btnMostrarLibros);

        // ===== SECCION BUSCAR =====
        JLabel lblBuscar = new JLabel("Buscar Libro por ISBN");
        lblBuscar.setBounds(20, 260, 200, 20);
        contentPane.add(lblBuscar);

        txtBuscarIsbn = new JTextField();
        txtBuscarIsbn.setBounds(20, 285, 150, 30);
        contentPane.add(txtBuscarIsbn);

        btnBuscarLibro = new JButton("Buscar");
        btnBuscarLibro.setBounds(180, 285, 120, 30);
        btnBuscarLibro.addActionListener(this);
        contentPane.add(btnBuscarLibro);

        // ===== SECCION PRESTAMO =====
        JLabel lblPrestamo = new JLabel("Registrar Préstamo");
        lblPrestamo.setBounds(20, 330, 200, 20);
        contentPane.add(lblPrestamo);

        // ID usuario
        txtIdUsuario = new JTextField();
        txtIdUsuario.setBounds(20, 355, 150, 40);
        txtIdUsuario.setBorder(BorderFactory.createTitledBorder("ID Usuario"));
        contentPane.add(txtIdUsuario);

        // ISBN libro
        txtIsbn = new JTextField();
        txtIsbn.setBounds(180, 355, 150, 40);
        txtIsbn.setBorder(BorderFactory.createTitledBorder("ISBN Libro"));
        contentPane.add(txtIsbn);

        // Botón préstamo
        btnRegistrarPrestamo = new JButton("Registrar");
        btnRegistrarPrestamo.setBounds(350, 355, 150, 40);
        btnRegistrarPrestamo.addActionListener(this);
        contentPane.add(btnRegistrarPrestamo);

        // ===== VOLVER =====
        btnVolver = new JButton("Volver");
        btnVolver.setBounds(20, 410, 120, 40);
        btnVolver.addActionListener(this);
        contentPane.add(btnVolver);

    }

    // SETTERS PARA MVC
    public void setGestionLibros(GestionLibros gl) {
        this.gestionLibros = gl;
    }

    public void setGestorPrestamos(GestorPrestamos gp) {
        this.gestorPrestamos = gp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnMostrarLibros) {

            areaLibros.setText("");

            for (Libro l : gestionLibros.getLibros()) {
                areaLibros.append(l.toString() + "\n\n");
            }

        } else if (e.getSource() == btnRegistrarPrestamo) {

            String isbn = txtIsbn.getText();

            for (Libro l : gestionLibros.getLibros()) {

                if (l.getIsbn().equals(isbn)) {

                    // Simulación (puedes mejorar luego con usuario real)
                    gestorPrestamos.registrarPrestamo(null, l, true);

                    JOptionPane.showMessageDialog(this, "Préstamo registrado");
                    return;
                }
            }

            JOptionPane.showMessageDialog(this, "Libro no encontrado");

        } else if (e.getSource() == btnVolver) {

            this.setVisible(false);

            if (origen.equals("admin")) {
                mCoordinador.mostrarAdministrador();

            } else if (origen.equals("biblio")) {
                mCoordinador.mostrarBibliotecario();
            }
        }

    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setCoordinador(Coordinador mCoordinador) {
        this.mCoordinador = mCoordinador;

    }
}
