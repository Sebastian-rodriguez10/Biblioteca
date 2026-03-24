package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Coordinador;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class VentanaRegistro extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textDocumento;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JLabel lblNombre;
	private JLabel lblDocumento;
	private JLabel lblContraseña;
	private JButton btnRegistrar;
	private JButton btnCancelar;
    private Coordinador mCoordinador;

	public VentanaRegistro() {
		setTitle("Ventana de registro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		iniciarComponentes();
	}
		
	public void iniciarComponentes() {
		lblNewLabel = new JLabel("Registro de usuarios");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(135, 11, 176, 67);
		contentPane.add(lblNewLabel);
		
		lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(117, 98, 65, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(192, 97, 147, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(50);
		
		lblDocumento = new JLabel("I.D.: ");
		lblDocumento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDocumento.setBounds(148, 143, 34, 14);
		contentPane.add(lblDocumento);
		
		textDocumento = new JTextField();
		textDocumento.setBounds(194, 142, 145, 20);
		contentPane.add(textDocumento);
		textDocumento.setColumns(50);
		
		lblContraseña = new JLabel("Contraseña: ");
		lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContraseña.setBounds(93, 186, 89, 14);
		contentPane.add(lblContraseña);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(192, 185, 147, 20);
		contentPane.add(passwordField);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(107, 237, 89, 23);
		contentPane.add(btnRegistrar);
		btnRegistrar.addActionListener(this);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(229, 237, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRegistrar) {
			//registrar();
		} else if(e.getSource() == btnCancelar) {
			mCoordinador.mostrarLogin();
    		this.setVisible(false);
		}
		
	}
	
    public void setCoordinador(Coordinador mCoordinador) {
        this.mCoordinador = mCoordinador;
    }
	
}