package vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Entidades.Libro;
import Entidades.Prestamo;
import Entidades.Usuario;
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
    private JButton btnListarPrestamos;
    private JButton btnDevolver;
    private JButton btnLimpiar;

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

        // ================================ AREA LIBROS
        // =======================================
        JLabel lblLibros = new JLabel("Lista de Libros");
        lblLibros.setBounds(20, 40, 200, 20);
        contentPane.add(lblLibros);

        areaLibros = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaLibros);
        scroll.setBounds(20, 60, 540, 150);
        contentPane.add(scroll);

        // ======================== BOTON MOSTRAR ===========================
        btnMostrarLibros = new JButton("Mostrar Libros");
        btnMostrarLibros.setBounds(20, 220, 200, 30);
        btnMostrarLibros.addActionListener(this);

        //======================BOTON LIMPIAR=============================
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(460, 220, 100, 30);
        btnLimpiar.addActionListener(this);
        contentPane.add(btnLimpiar);

        contentPane.add(btnMostrarLibros);
        // ============================= BOTON LISTAR PRESTAMOS =======================
        btnListarPrestamos = new JButton("Listar Prestamos");
        // btnVolver.setBounds(20, 410, 120, 40);
        btnListarPrestamos.setBounds(240, 220, 200, 30);
        btnListarPrestamos.addActionListener(this);
        contentPane.add(btnListarPrestamos);

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
        btnRegistrarPrestamo.setBounds(350, 355, 150, 30);
        btnRegistrarPrestamo.addActionListener(this);
        contentPane.add(btnRegistrarPrestamo);

        // Botón devolver (NUEVO)
        btnDevolver = new JButton("Devolver");
        btnDevolver.setBounds(350, 385, 150, 30);
        btnDevolver.addActionListener(this);
        contentPane.add(btnDevolver);

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

    // ====================AQUI EMPIEZA TODO DE LOS BOTONES LA ACCION
    // ===============================
    @Override
    public void actionPerformed(ActionEvent e) {
        // ----------------------------MOSTRAR LA LISTA DE LIBROS---------------------------------------
        if (e.getSource() == btnMostrarLibros) {

            // mCoordinador.listarLibros().toString();

            areaLibros.setText("");

            for (Libro l : mCoordinador.listarLibros()) {
                areaLibros.append(l.toString() + "\n\n");
            }
            // --------------------------------REGISTRAR PRESTAMO-------------------------------------------
        } else if (e.getSource() == btnRegistrarPrestamo) {

            String isbn = txtIsbn.getText();
            String documento = txtIdUsuario.getText();
            if (isbn.isEmpty() || documento.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los con son obligatorios");
                return;
            }
            // Registra buscar los objetos en las listas
            Usuario usuarioEncontrado = mCoordinador.buscarUsuario(documento);
            Libro libroEncpLibro = mCoordinador.buscarLibro(isbn);

            // VALIDACIONES
            if (libroEncpLibro == null) {
                JOptionPane.showMessageDialog(this, "Libro no encontrado");

            } else if (usuarioEncontrado == null) {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado");

            } else if (!libroEncpLibro.getEstado().equalsIgnoreCase("diponible")) {
                JOptionPane.showMessageDialog(this, "Libro no disponible");

            } else if (usuarioEncontrado.getNumPrestamos() >= usuarioEncontrado.getLimPrestamos()) {
                JOptionPane.showMessageDialog(this, "Ya supero su numero de limites");

            } else {
                mCoordinador.registrarPrestamo(usuarioEncontrado, libroEncpLibro, true);
                libroEncpLibro.setEstado("no disponible");
                usuarioEncontrado.incrementarPrestamos();
                JOptionPane.showMessageDialog(this, "Préstamo registrado");
            }

            // JOptionPane.showMessageDialog(this, "Libro no encontrado");
            // ---------------------------------VOLVER------------------------------------------------
        } else if (e.getSource() == btnVolver) {

            this.setVisible(false);

            if (origen.equals("admin")) {
                mCoordinador.mostrarAdministrador();

            } else if (origen.equals("biblio")) {
                mCoordinador.mostrarBibliotecario();
            }
            limpiar();
        } // ------------------------------------------BUSCAR LIBRO-------------------------------------
        else if (e.getSource() == btnBuscarLibro) {
            // this.setVisible(false);
            limpiar();
            if (txtBuscarIsbn.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Debe ingresar algo en el campo");
                return;
            }
            try {
                Libro wi = mCoordinador.buscarLibro(txtBuscarIsbn.getText());
                areaLibros.append(wi.toString() + "\n\n");
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(this, "No exixte ese ISBN sopenco");
            }

            // ---------------------------------DEVOLVER---------------------------------------
        } else if (e.getSource() == btnDevolver) {

            String documento = txtIdUsuario.getText();
            String isbn = txtIsbn.getText();

            if (documento.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el documento del usuario");
                return;
            }

            mCoordinador.registrarDevolucion(documento,isbn);

            //JOptionPane.showMessageDialog(this, "Devolución procesada");
            //----------------------------LISTAR PRESTAMOS----------------------------------------
        }else if (e.getSource() == btnListarPrestamos) {
            
            areaLibros.setText("");
            for (Prestamo l : mCoordinador.listaPrestamos()) {
                areaLibros.append(l.toString() + "\n");
            }

        }else if (e.getSource() == btnLimpiar) {
            limpiarTodo();
}
    }

    public void limpiar() {
        areaLibros.setText("");
    }

    public void limpiarTodo() {
    areaLibros.setText("");
    txtIsbn.setText("");
    txtBuscarIsbn.setText("");
    txtIdUsuario.setText("");
}

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setCoordinador(Coordinador mCoordinador) {
        this.mCoordinador = mCoordinador;

    }
}
