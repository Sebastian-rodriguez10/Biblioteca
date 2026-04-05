package vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import GestorDeDatos.*;
import Logica.Coordinador;
import Entidades.Usuario;

import java.awt.event.*;

public class VentanaBibliotecario extends JFrame implements ActionListener {

    private JPanel contentPane;

    private JButton btnListaUsuarios;
    private JButton btnEliminarUsuario;
    private JButton btnAgregarLibro;
    private JButton btnEliminarLibro;
    private JButton btnVolver;
    private JButton btnPrestamos;

    private GestorUsuario gestorUsuario;
    private GestionLibros gestionLibros;
    private Coordinador mCoordinador;
    private VentanaListaUsuarios vListaUsuarios;

    public VentanaBibliotecario(GestorUsuario gu, GestionLibros gl) {

        this.gestorUsuario = gu;
        this.gestionLibros = gl;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        iniciarComponentes();
    }

    private void iniciarComponentes() {

        btnListaUsuarios = new JButton("Lista de Usuarios");
        btnListaUsuarios.setBounds(50, 30, 280, 30);
        btnListaUsuarios.addActionListener(this);
        contentPane.add(btnListaUsuarios);

        btnEliminarUsuario = new JButton("Eliminar Usuario");
        btnEliminarUsuario.setBounds(50, 70, 280, 30);
        btnEliminarUsuario.addActionListener(this);
        contentPane.add(btnEliminarUsuario);

        btnAgregarLibro = new JButton("Agregar Libro");
        btnAgregarLibro.setBounds(50, 110, 280, 30);
        btnAgregarLibro.addActionListener(this);
        contentPane.add(btnAgregarLibro);

        btnEliminarLibro = new JButton("Eliminar Libro");
        btnEliminarLibro.setBounds(50, 150, 280, 30);
        btnEliminarLibro.addActionListener(this);
        contentPane.add(btnEliminarLibro);

        btnVolver = new JButton("Cerrar sesión");
        btnVolver.setBounds(35, 230, 310, 30);
        btnVolver.addActionListener(this);
        contentPane.add(btnVolver);

        btnPrestamos = new JButton("Gestión de Préstamos");
        btnPrestamos.setBounds(50, 190, 280, 30);
        btnPrestamos.addActionListener(this);
        contentPane.add(btnPrestamos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnListaUsuarios) {
            mCoordinador.mostrarVentanaListaUsuariosDesdeBiblio();

        } else if (e.getSource() == btnEliminarUsuario) {

            String doc = JOptionPane.showInputDialog("Documento:");
            JOptionPane.showMessageDialog(this, gestorUsuario.eliminarUsuario(doc));

        } else if (e.getSource() == btnAgregarLibro) {

            String isbn = JOptionPane.showInputDialog("ISBN:");
            String titulo = JOptionPane.showInputDialog("Título:");
            String autor = JOptionPane.showInputDialog("Autor:");
            int año = 0;
            try {
               
            // Intentamos convertir el texto a número
            año = Integer.parseInt(JOptionPane.showInputDialog(("Año")));
            System.out.println("¡Es un número válido!: " + año);
            gestionLibros.registrarLibro(isbn, titulo, autor, año, "Disponible");
        } catch (NumberFormatException e1) {
             if (isbn.isEmpty() || titulo.isEmpty() || autor.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                }else{
                    System.out.println("Error: Has introducido una letra o un formato no válido.");
                }
            // Si falla la conversión, entra aquí
            
        }
            


        } else if (e.getSource() == btnEliminarLibro) {

            String isbn = JOptionPane.showInputDialog("ISBN:");
            gestionLibros.eliminarLibro(isbn);
        } else if (e.getSource() == btnVolver) {
            mCoordinador.mostrarLogin();
            this.setVisible(false);
        } else if (e.getSource() == btnPrestamos) {
            mCoordinador.mostrarPrestamosDesdeBiblio();
        }

    }

    public void setCoordinador(Coordinador mCoordinador) {
        this.mCoordinador = mCoordinador;
    }
}
