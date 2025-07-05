package baseDatos.crud_mvc.vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class VistaPersona extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField tbClave;
	public JTextField tbNombre;
	public JTextField tbDomicilio;
	public JTextField tbCelular;
	public JTextField tbCorreoElectronico;
	public JTextField tbFechaNacimiento;
	public JTextField tbBuscar;
	public JTextField tbIdPersona;
	@SuppressWarnings("rawtypes")
	public JComboBox cbGenero;
	public JButton btnLimpiar;
	public JButton btnEliminar;
	public JButton btnBuscar;
	public JButton btnModificar;
	public JButton btnInsertar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPersona frame = new VistaPersona();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public VistaPersona() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Clave: ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		tbClave = new JTextField();
		GridBagConstraints gbc_tbClave = new GridBagConstraints();
		gbc_tbClave.gridwidth = 3;
		gbc_tbClave.insets = new Insets(0, 0, 20, 0);
		gbc_tbClave.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbClave.gridx = 1;
		gbc_tbClave.gridy = 2;
		contentPane.add(tbClave, gbc_tbClave);
		tbClave.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tbNombre = new JTextField();
		GridBagConstraints gbc_tbNombre = new GridBagConstraints();
		gbc_tbNombre.gridwidth = 3;
		gbc_tbNombre.insets = new Insets(0, 0, 20, 0);
		gbc_tbNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbNombre.gridx = 1;
		gbc_tbNombre.gridy = 3;
		contentPane.add(tbNombre, gbc_tbNombre);
		tbNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Domicilio:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tbDomicilio = new JTextField();
		GridBagConstraints gbc_tbDomicilio = new GridBagConstraints();
		gbc_tbDomicilio.gridwidth = 3;
		gbc_tbDomicilio.insets = new Insets(0, 0, 20, 0);
		gbc_tbDomicilio.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbDomicilio.gridx = 1;
		gbc_tbDomicilio.gridy = 4;
		contentPane.add(tbDomicilio, gbc_tbDomicilio);
		tbDomicilio.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Celular:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		tbCelular = new JTextField();
		GridBagConstraints gbc_tbCelular = new GridBagConstraints();
		gbc_tbCelular.gridwidth = 3;
		gbc_tbCelular.insets = new Insets(0, 0, 20, 0);
		gbc_tbCelular.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbCelular.gridx = 1;
		gbc_tbCelular.gridy = 5;
		contentPane.add(tbCelular, gbc_tbCelular);
		tbCelular.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Correo Electronico: ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		tbCorreoElectronico = new JTextField();
		GridBagConstraints gbc_tbCorreoElectronico = new GridBagConstraints();
		gbc_tbCorreoElectronico.gridwidth = 3;
		gbc_tbCorreoElectronico.insets = new Insets(0, 0, 20, 0);
		gbc_tbCorreoElectronico.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbCorreoElectronico.gridx = 1;
		gbc_tbCorreoElectronico.gridy = 6;
		contentPane.add(tbCorreoElectronico, gbc_tbCorreoElectronico);
		tbCorreoElectronico.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de nacimiento:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 7;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		tbFechaNacimiento = new JTextField();
		GridBagConstraints gbc_tbFechaNacimiento = new GridBagConstraints();
		gbc_tbFechaNacimiento.gridwidth = 3;
		gbc_tbFechaNacimiento.insets = new Insets(0, 0, 20, 0);
		gbc_tbFechaNacimiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbFechaNacimiento.gridx = 1;
		gbc_tbFechaNacimiento.gridy = 7;
		contentPane.add(tbFechaNacimiento, gbc_tbFechaNacimiento);
		tbFechaNacimiento.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Genero:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 8;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		cbGenero = new JComboBox();
		cbGenero.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "Masculino", "Femenino"}));
		GridBagConstraints gbc_cbGenero = new GridBagConstraints();
		gbc_cbGenero.gridwidth = 3;
		gbc_cbGenero.insets = new Insets(0, 0, 20, 0);
		gbc_cbGenero.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbGenero.gridx = 1;
		gbc_cbGenero.gridy = 8;
		contentPane.add(cbGenero, gbc_cbGenero);
		
		tbBuscar = new JTextField();
		tbBuscar.setColumns(10);
		GridBagConstraints gbc_tbBuscar = new GridBagConstraints();
		gbc_tbBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_tbBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbBuscar.gridx = 2;
		gbc_tbBuscar.gridy = 0;
		contentPane.add(tbBuscar, gbc_tbBuscar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(20, 0, 5, 0);
		gbc_btnBuscar.gridx = 3;
		gbc_btnBuscar.gridy = 0;
		contentPane.add(btnBuscar, gbc_btnBuscar);
		
		tbIdPersona = new JTextField();
		tbIdPersona.setColumns(10);
		GridBagConstraints gbc_tbIdPersona = new GridBagConstraints();
		gbc_tbIdPersona.insets = new Insets(0, 0, 5, 0);
		gbc_tbIdPersona.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbIdPersona.gridx = 3;
		gbc_tbIdPersona.gridy = 1;
		contentPane.add(tbIdPersona, gbc_tbIdPersona);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnInsertar = new GridBagConstraints();
		gbc_btnInsertar.weightx = 0.5;
		gbc_btnInsertar.insets = new Insets(0, 0, 0, 5);
		gbc_btnInsertar.gridx = 0;
		gbc_btnInsertar.gridy = 10;
		contentPane.add(btnInsertar, gbc_btnInsertar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.weightx = 0.5;
		gbc_btnModificar.insets = new Insets(0, 0, 0, 5);
		gbc_btnModificar.gridx = 1;
		gbc_btnModificar.gridy = 10;
		contentPane.add(btnModificar, gbc_btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
			}
		});
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.weightx = 0.5;
		gbc_btnEliminar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEliminar.gridx = 2;
		gbc_btnEliminar.gridy = 10;
		contentPane.add(btnEliminar, gbc_btnEliminar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCajas();
			}
		});
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.weightx = 0.5;
		gbc_btnLimpiar.gridx = 3;
		gbc_btnLimpiar.gridy = 10;
		contentPane.add(btnLimpiar, gbc_btnLimpiar);
	}
	public void limpiarCajas() {
		tbClave.setText("");
		tbBuscar.setText("");
		tbIdPersona.setText("");
		tbNombre.setText("");
		tbDomicilio.setText("");
		tbCelular.setText("");
		tbCorreoElectronico.setText("");
		tbFechaNacimiento.setText("");
		cbGenero.setSelectedIndex(0);
	}
}


