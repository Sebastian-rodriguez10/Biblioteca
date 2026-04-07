package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Config.Config;
import Entidades.Usuario;
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
	private JLabel lblContraseña, lblUsuario;
	private JButton btnSesion;
	private JButton btnRegistro;
	private Coordinador mCoordinador;
	private Config config = new Config();
	private int intentos = 0;

	public VentanaLogin() {
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
		txtDocumento.setBounds(137, 138, 160, 20);
		contentPane.add(txtDocumento);
		txtDocumento.setColumns(50);

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(137, 120, 60, 14);
		contentPane.add(lblUsuario);
			 
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

			String rol = comboBox.getSelectedItem().toString();
			String contraseña = new String(passwordField.getPassword());
			String id = txtDocumento.getText();

			Usuario user = mCoordinador.validUsuario(id);
			//validacion para todos
			if (user == null || !user.getContraseña().equals(contraseña)) {

				intentos++;
				//si llega a los 3 intentos desabilita los botones
				if (intentos >= config.getMaxLogin()) {
					JOptionPane.showMessageDialog(null, "Se acabaron los intentos");
					btnSesion.setEnabled(false);
					btnRegistro.setEnabled(false);
				//mostrarle al usuario en que intento va
				} else {
					JOptionPane.showMessageDialog(null,
							"Usuario o contraseña incorrecta. Intento " + intentos);
				}
				//cerrar el proceso
				return; 
			}

			intentos = 0;

			//Manejo de roles
			if (rol.equalsIgnoreCase("Lector")) {

				if (user.getTipoUsuario().equalsIgnoreCase("lector")) {
					limpiar();
					mCoordinador.mostrarUsuario();
				} else {
					JOptionPane.showMessageDialog(null, "No tienes acceso como lector");
				}

			} else if (rol.equalsIgnoreCase("Administrador")) {

				if (user.getTipoUsuario().equalsIgnoreCase("administrador")) {
					limpiar();
					mCoordinador.mostrarAdministrador();
				} else {
					JOptionPane.showMessageDialog(null, "No tienes acceso como administrador");
				}

			} else if (rol.equalsIgnoreCase("Bibliotecario")) {

				if (user.getTipoUsuario().equalsIgnoreCase("bibliotecario")) {
					limpiar();
					mCoordinador.mostrarBibliotecario();
				} else {
					JOptionPane.showMessageDialog(null, "No tienes acceso como bibliotecario");
				}

			} else {
				JOptionPane.showMessageDialog(null, "Rol inválido");
			}

		} else if (e.getSource() == btnRegistro) {
			limpiar();
			mCoordinador.mostrarRegistro();
		}
	}

	public void limpiar(){
		passwordField.setText("");
		txtDocumento.setText("");
	}

	public void setCoordinador(Coordinador mCoordinador) {
		this.mCoordinador = mCoordinador;
	}
}
