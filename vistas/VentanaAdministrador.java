package vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import GestorDeDatos.*;
import Logica.Coordinador;
import Entidades.Usuario;

import java.awt.event.*;

public class VentanaAdministrador extends JFrame implements ActionListener {

    private JPanel contentPane;

    private JButton btnAgregarUsuario;
    private JButton btnEliminarUsuario;
    private JButton btnAgregarLibro;
    private JButton btnEliminarLibro;

    private GestorUsuario gestorUsuario;
    private GestionLibros gestionLibros;
    private Coordinador mCoordinador;

    // public VentanaAdministrador(){
        
    // }

    public VentanaAdministrador(GestorUsuario gu, GestionLibros gl) {

        this.gestorUsuario = gu;
        this.gestionLibros = gl;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        iniciarComponentes();
    }

    private void iniciarComponentes() {

        btnAgregarUsuario = new JButton("Agregar Usuario");
        btnAgregarUsuario.setBounds(50, 30, 280, 30);
        btnAgregarUsuario.addActionListener(this);
        contentPane.add(btnAgregarUsuario);

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
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAgregarUsuario) {

            String doc = JOptionPane.showInputDialog("Documento:");
            String nombre = JOptionPane.showInputDialog("Nombre:");
            String tipo = JOptionPane.showInputDialog("Tipo:");

            Usuario u = new Usuario(Integer.parseInt(doc), nombre, tipo);
            JOptionPane.showMessageDialog(this, gestorUsuario.registrarUsuario(u));

        } else if (e.getSource() == btnEliminarUsuario) {

            String doc = JOptionPane.showInputDialog("Documento:");
            JOptionPane.showMessageDialog(this, gestorUsuario.eliminarUsuario(Integer.parseInt(doc)));

        } else if (e.getSource() == btnAgregarLibro) {

            String isbn = JOptionPane.showInputDialog("ISBN:");
            String titulo = JOptionPane.showInputDialog("Título:");
            String autor = JOptionPane.showInputDialog("Autor:");
            int año = Integer.parseInt(JOptionPane.showInputDialog("Año"));

            gestionLibros.registrarLibro(isbn, titulo, autor, año, "Disponible");

        } else if (e.getSource() == btnEliminarLibro) {

            String isbn = JOptionPane.showInputDialog("ISBN:");
            gestionLibros.eliminarLibro(isbn);
        }
    }

    public void setCoordinador(Coordinador mCoordinador){
        this.mCoordinador = mCoordinador;
    }
}

