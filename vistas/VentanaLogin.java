package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Coordinador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class VentanaLogin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDocumento;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JLabel lblContraseña;
	private JButton btnSesion;
	private JButton btnRegistro;
	private Coordinador mCoordinador;
	private int acumulador;

	public VentanaLogin() {
		acumulador = 0;
		setTitle("Sistema De Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		iniciarComponentes();
	}

	public void iniciarComponentes() {
		lblNewLabel = new JLabel("¡Bienvenido al sistema de la biblioteca municipal!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 0, 424, 73);
		contentPane.add(lblNewLabel);

		comboBox = new JComboBox();
		comboBox.setForeground(new Color(192, 192, 192));
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Seleccione su rol", "Administrador", "Bibliotecario", "Lector" }));
		comboBox.setToolTipText("");
		comboBox.setBounds(137, 84, 160, 22);
		contentPane.add(comboBox);

		txtDocumento = new JTextField();
		txtDocumento.setForeground(new Color(192, 192, 192));
		txtDocumento.setText("Escriba aquí su usuario");
		txtDocumento.setBounds(137, 127, 160, 20);
		contentPane.add(txtDocumento);
		txtDocumento.setColumns(50);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setBounds(137, 188, 160, 20);
		contentPane.add(passwordField);

		lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setBounds(137, 173, 60, 14);
		contentPane.add(lblContraseña);

		btnSesion = new JButton("Iniciar sesión");
		btnSesion.setBounds(91, 248, 106, 33);
		contentPane.add(btnSesion);
		btnSesion.addActionListener(this);

		btnRegistro = new JButton("Resgitrarse");
		btnRegistro.setBounds(245, 246, 106, 36);
		contentPane.add(btnRegistro);
		btnRegistro.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		if (e.getSource() == btnSesion) {			
			String documento = txtDocumento.getText();
			String clave = new String(passwordField.getPassword());
			String rol = comboBox.getSelectedItem().toString();
			if (rol.equals("Administrador") && documento.equals("1010") && clave.equals("3231651")) {
				mCoordinador.mostrarAdministrador();

			} else if (rol.equals("Bibliotecario") && documento.equals("2020") && clave.equals("validaciones")) {
				mCoordinador.mostrarBibliotecario();

			} else if (rol.equals("Lector") && documento.equals("3030") && clave.equals("carlos")) {
				mCoordinador.mostrarUsuario();

			} else {
				acumulador++;
				if(acumulador == 3) {
					JOptionPane.showMessageDialog(this, "DATOS INVALIDOS. HA EXCEDIDO SUS 3 INTENTOS. \nINTENTELO MÁS TARDE.");
					btnSesion.setVisible(false);
				}
			}

		} else if (e.getSource() == btnRegistro) {

			mCoordinador.mostrarRegistro();
		}
	}


	public void setCoordinador(Coordinador mCoordinador) {
		this.mCoordinador = mCoordinador;
	}
}
