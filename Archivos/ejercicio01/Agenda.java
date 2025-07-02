package Archivos.ejercicio01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.jDialog.VentanaPrincipalJdialog;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class Agenda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tbNombre;
	private JTextField tbCorreo;
	private JTextField tbTelefono;
	private static VentanaPrincipalJdialog frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda frame = new Agenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Agenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 332);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setFont(new Font("Arial", Font.PLAIN, 16));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmMostrarContactos = new JMenuItem("Mostrar contactos");
		mntmMostrarContactos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contactos c=new Contactos(frame,true);
				c.setVisible(true);
			}
		});
		mntmMostrarContactos.setIcon(new ImageIcon(Agenda.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/notebook.png")));
		mntmMostrarContactos.setFont(new Font("Arial", Font.PLAIN, 16));
		mnNewMenu.add(mntmMostrarContactos);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmSalir.setIcon(new ImageIcon(Agenda.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/close-button-png-26.png")));
		mntmSalir.setFont(new Font("Arial", Font.PLAIN, 16));
		mnNewMenu.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(34, 139, 34));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{199, 319, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Agenda de contactos");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lbNombre = new JLabel("Nombre");
		lbNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lbNombre.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_lbNombre = new GridBagConstraints();
		gbc_lbNombre.weightx = 0.4;
		gbc_lbNombre.anchor = GridBagConstraints.WEST;
		gbc_lbNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lbNombre.gridx = 0;
		gbc_lbNombre.gridy = 1;
		contentPane.add(lbNombre, gbc_lbNombre);
		
		tbNombre = new JTextField();
		tbNombre.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_tbNombre = new GridBagConstraints();
		gbc_tbNombre.weightx = 0.6;
		gbc_tbNombre.insets = new Insets(0, 0, 5, 0);
		gbc_tbNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbNombre.gridx = 1;
		gbc_tbNombre.gridy = 1;
		contentPane.add(tbNombre, gbc_tbNombre);
		tbNombre.setColumns(10);
		
		JLabel lbCorreoElectronico = new JLabel("Correo electronico");
		lbCorreoElectronico.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_lbCorreoElectronico = new GridBagConstraints();
		gbc_lbCorreoElectronico.weightx = 0.4;
		gbc_lbCorreoElectronico.anchor = GridBagConstraints.WEST;
		gbc_lbCorreoElectronico.insets = new Insets(0, 0, 5, 5);
		gbc_lbCorreoElectronico.gridx = 0;
		gbc_lbCorreoElectronico.gridy = 2;
		contentPane.add(lbCorreoElectronico, gbc_lbCorreoElectronico);
		
		tbCorreo = new JTextField();
		tbCorreo.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_tbCorreo = new GridBagConstraints();
		gbc_tbCorreo.weightx = 0.6;
		gbc_tbCorreo.insets = new Insets(0, 0, 5, 0);
		gbc_tbCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbCorreo.gridx = 1;
		gbc_tbCorreo.gridy = 2;
		contentPane.add(tbCorreo, gbc_tbCorreo);
		tbCorreo.setColumns(10);
		
		JLabel lbNumeroTelefonico = new JLabel("Numero telefonico");
		lbNumeroTelefonico.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_lbNumeroTelefonico = new GridBagConstraints();
		gbc_lbNumeroTelefonico.weightx = 0.4;
		gbc_lbNumeroTelefonico.anchor = GridBagConstraints.WEST;
		gbc_lbNumeroTelefonico.insets = new Insets(0, 0, 5, 5);
		gbc_lbNumeroTelefonico.gridx = 0;
		gbc_lbNumeroTelefonico.gridy = 3;
		contentPane.add(lbNumeroTelefonico, gbc_lbNumeroTelefonico);
		
		tbTelefono = new JTextField();
		tbTelefono.setFont(new Font("Arial", Font.PLAIN, 24));
		GridBagConstraints gbc_tbTelefono = new GridBagConstraints();
		gbc_tbTelefono.weightx = 0.6;
		gbc_tbTelefono.insets = new Insets(0, 0, 5, 0);
		gbc_tbTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbTelefono.gridx = 1;
		gbc_tbTelefono.gridy = 3;
		contentPane.add(tbTelefono, gbc_tbTelefono);
		tbTelefono.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar Contacto");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre,correo,celular;
				nombre=tbNombre.getText();
				correo=tbCorreo.getText();
				celular=tbTelefono.getText();
				Persona persona=new Persona(nombre,correo,celular);
				Archivo archivo=new Archivo();
				archivo.crearArchivo();
				archivo.escribirTexto(persona);
				tbNombre.setText("");
				tbCorreo.setText("");
				tbTelefono.setText("");
			}
		});
		btnGuardar.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.NORTH;
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 6;
		contentPane.add(btnGuardar, gbc_btnGuardar);
	}

}
