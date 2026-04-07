package vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import GestorDeDatos.*;
import Logica.Coordinador;
import Entidades.Usuario;

import java.awt.event.*;
import java.util.List;

public class VentanaAdministrador extends JFrame implements ActionListener {

    private JPanel contentPane;

    private JButton btnAgregarUsuario;
    private JButton btnEliminarUsuario;
    private JButton btnListarUsuarios; // NUEVO
    private JButton btnAgregarLibro;
    private JButton btnEliminarLibro;
    private JButton btnVolver;
    private JButton btnPrestamos;

    private GestorUsuario gestorUsuario;
    private GestionLibros gestionLibros;
    private Coordinador mCoordinador;
    private VentanaListaUsuarios vListaUsuarios;

    public VentanaAdministrador(GestorUsuario gu, GestionLibros gl) {

        this.gestorUsuario = gu;
        this.gestionLibros = gl;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 380); // AGRANDÉ LA VENTANA
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        iniciarComponentes();
    }

    private void iniciarComponentes() {

        btnAgregarUsuario = new JButton("Agregar Usuario");
        btnAgregarUsuario.setBounds(70, 20, 300, 30);
        btnAgregarUsuario.addActionListener(this);
        contentPane.add(btnAgregarUsuario);

        btnEliminarUsuario = new JButton("Eliminar Usuario");
        btnEliminarUsuario.setBounds(70, 60, 300, 30);
        btnEliminarUsuario.addActionListener(this);
        contentPane.add(btnEliminarUsuario);

        btnListarUsuarios = new JButton("Listar Usuarios"); // NUEVO
        btnListarUsuarios.setBounds(70, 100, 300, 30);
        btnListarUsuarios.addActionListener(this);
        contentPane.add(btnListarUsuarios);

        btnAgregarLibro = new JButton("Agregar Libro");
        btnAgregarLibro.setBounds(70, 140, 300, 30);
        btnAgregarLibro.addActionListener(this);
        contentPane.add(btnAgregarLibro);

        btnEliminarLibro = new JButton("Eliminar Libro");
        btnEliminarLibro.setBounds(70, 180, 300, 30);
        btnEliminarLibro.addActionListener(this);
        contentPane.add(btnEliminarLibro);

        btnPrestamos = new JButton("Gestión de Préstamos");
        btnPrestamos.setBounds(70, 220, 300, 30);
        btnPrestamos.addActionListener(this);
        contentPane.add(btnPrestamos);

        btnVolver = new JButton("Cerrar sesión");
        btnVolver.setBounds(70, 270, 300, 30);
        btnVolver.addActionListener(this);
        contentPane.add(btnVolver);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAgregarUsuario) {

            String doc = JOptionPane.showInputDialog("Documento:");
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String tipo = JOptionPane.showInputDialog("Tipo:");

            Usuario u = new Usuario(doc, nombre, tipo);
            JOptionPane.showMessageDialog(this, gestorUsuario.registrarUsuario(u));

        } else if (e.getSource() == btnEliminarUsuario) {

            String doc = JOptionPane.showInputDialog("Documento:");
            JOptionPane.showMessageDialog(this, gestorUsuario.eliminarUsuario(doc));

        } else if (e.getSource() == btnListarUsuarios) { // NUEVO
            mCoordinador.mostrarVentanaListaUsuariosDesdeAdmin();


        } else if (e.getSource() == btnAgregarLibro) {

            String isbn = JOptionPane.showInputDialog("ISBN:");
            String titulo = JOptionPane.showInputDialog("Título:");
            String autor = JOptionPane.showInputDialog("Autor:");
            int año = 0;
            try {
            // Intentamos convertir el texto a número
                año = Integer.parseInt(JOptionPane.showInputDialog(("Año")));
                if(isbn.equals("")||titulo.equals("")||autor.equals("")){
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                    return;
                    
                }
                System.out.println("¡Es un número válido!: " + año);
                gestionLibros.registrarLibro(isbn, titulo, autor, año, "diponible");
        } catch (NumberFormatException e1) {
            if (isbn.isEmpty() && titulo.isEmpty() && autor.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                }else{
                    JOptionPane.showMessageDialog(null, "Error: Has introducido una letra o un formato no válids");
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

            mCoordinador.mostrarPrestamosDesdeAdmin();
        }
    }

    public void setCoordinador(Coordinador mCoordinador) {
        this.mCoordinador = mCoordinador;
    }
}
