package vistas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Logica.Coordinador;
import Entidades.Usuario;

import java.awt.*;
import java.awt.event.*;

public class VentanaListaUsuarios extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextArea areaUsuarios;
    private JButton btnMostrar;
    private JButton btnLimpiar;
    private JButton btnVolver;

    private Coordinador miCoordinador;

    public VentanaListaUsuarios() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        iniciarComponentes();
    }

    private void iniciarComponentes() {

        JLabel lblTitulo = new JLabel("LISTA DE USUARIOS");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setBounds(150, 10, 200, 30);
        contentPane.add(lblTitulo);

        areaUsuarios = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaUsuarios);
        scroll.setBounds(30, 50, 420, 200);
        contentPane.add(scroll);

        btnMostrar = new JButton("Mostrar Usuarios");
        btnMostrar.setBounds(30, 270, 150, 30);
        btnMostrar.addActionListener(this);
        contentPane.add(btnMostrar);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(200, 270, 120, 30);
        btnLimpiar.addActionListener(this);
        contentPane.add(btnLimpiar);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(340, 270, 110, 30);
        btnVolver.addActionListener(this);
        contentPane.add(btnVolver);
    }

    // 🔥 Método para limpiar
    public void limpiar() {
        areaUsuarios.setText("");
    }

    public void setCoordinador(Coordinador miCoordinador) {
        this.miCoordinador = miCoordinador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnMostrar) {

            areaUsuarios.setText("");

            for (Usuario u : miCoordinador.listarUsuario()) {

                areaUsuarios.append("Documento: " + u.getDocumento() + "\n");
                areaUsuarios.append("Nombre: " + u.getNombreCompleto() + "\n");
                areaUsuarios.append("Tipo: " + u.getTipoUsuario() + "\n");
                areaUsuarios.append("------------------------\n");
            }

        } else if (e.getSource() == btnLimpiar) {

            limpiar();

        } else if (e.getSource() == btnVolver) {
            limpiar();
            miCoordinador.mostrarBibliotecario(); // o la ventana que quieras
            this.setVisible(false);
        }
    }
}