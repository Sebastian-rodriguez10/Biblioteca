package vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import GestorDeDatos.GestionLibros;
import Logica.Coordinador;
import Entidades.Libro;

import java.awt.*;
import java.awt.event.*;

public class VentanaUsuario extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JLabel lblBienvenida;
    private JTextArea areaLibros;
    private JTextField txtBuscar;
    private JButton btnVerLibros;
    private JButton btnBuscar;
    private JButton btnVolver;

    private GestionLibros gestionLibros;
    private Coordinador mCoordinador;

    public VentanaUsuario(String nombre, GestionLibros gestionLibros) {
        this.gestionLibros = gestionLibros;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        iniciarComponentes(nombre);
    }

    private void iniciarComponentes(String nombre) {

        lblBienvenida = new JLabel("Bienvenido " + nombre);
        lblBienvenida.setBounds(150, 10, 250, 25);
        contentPane.add(lblBienvenida);

        areaLibros = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaLibros);
        scroll.setBounds(20, 50, 440, 200);
        contentPane.add(scroll);

        btnVerLibros = new JButton("Ver libros");
        btnVerLibros.setBounds(20, 270, 150, 30);
        btnVerLibros.addActionListener(this);
        contentPane.add(btnVerLibros);

        txtBuscar = new JTextField();
        txtBuscar.setBounds(200, 270, 120, 30);
        contentPane.add(txtBuscar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(340, 270, 120, 30);
        btnBuscar.addActionListener(this);
        contentPane.add(btnBuscar);

        btnVolver = new JButton("Cerrar sesión");
        btnVolver.setBounds(185, 310, 150, 30);
        btnVolver.addActionListener(this);
        contentPane.add(btnVolver);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnVerLibros) {

            areaLibros.setText("");
            for (Libro l : gestionLibros.getLibros()) {
                areaLibros.append(l.toString() + "\n\n");
            }

        } else if (e.getSource() == btnBuscar) {

            String isbn = txtBuscar.getText();

            for (Libro l : gestionLibros.getLibros()) {
                if (l.getIsbn().equals(isbn)) {
                    areaLibros.setText(l.toString());
                    return;
                }
            }

            areaLibros.setText("Libro no encontrado");
        } else if (e.getSource() == btnVolver) {
            mCoordinador.mostrarLogin();
            this.setVisible(false);
        }
    }

    public void setCoordinador(Coordinador mCoordinador) {
        this.mCoordinador = mCoordinador;
    }
}