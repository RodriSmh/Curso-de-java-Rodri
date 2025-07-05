package baseDatos.CRUD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Crud extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tbBuscar;
	private JTextField tbClave;
	private JTextField tbNombre;
	private JTextField tbDomicilio;
	private JTextField tbCelular;
	private JTextField tbCorreoElectronico;
	private JTextField tbFechaNacimiento;
	private JTextField tbIdPersona;
	public static final String URL="jdbc:mysql://localhost:3306/escuela?autoReconnet=true&useSSL=false";
	public static final String usuario="root";
	public static final String contraseña="1234";
	public PreparedStatement ps;
	public ResultSet rs;
	@SuppressWarnings("rawtypes")
	private JComboBox cbGenero;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crud frame = new Crud();
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
	public Connection getConnection() {
		Connection conexion=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion= DriverManager.getConnection(URL,usuario,contraseña);
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos");
			System.err.println("Error"+e);			
		}
		return conexion;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Crud() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{95, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		tbBuscar = new JTextField();
		GridBagConstraints gbc_tbBuscar = new GridBagConstraints();
		gbc_tbBuscar.insets = new Insets(20, 0, 5, 5);
		gbc_tbBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbBuscar.gridx = 2;
		gbc_tbBuscar.gridy = 0;
		contentPane.add(tbBuscar, gbc_tbBuscar);
		tbBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion=null;
				try {
					conexion= getConnection();
					ps=conexion.prepareStatement("select * from persona where clave=?");
					ps.setString(1, tbBuscar.getText());
					rs=ps.executeQuery();
					
					if(rs.next()) {
						tbClave.setText(rs.getString("clave"));
						tbIdPersona.setText(String.valueOf(rs.getInt("idPersona")));
						tbNombre.setText(rs.getString("nombre"));
						tbDomicilio.setText(rs.getString("domicilio"));
						tbCelular.setText(rs.getString("celular"));
						tbCorreoElectronico.setText(rs.getNString("correo_electronico"));
						tbFechaNacimiento.setText(rs.getDate("fecha_nacimiento").toString());
						cbGenero.setSelectedItem(rs.getString("genero"));
					}
					else 
						JOptionPane.showMessageDialog(null, "Registro no encontrado");
						
					
						
				}catch(Exception ex) {
					System.err.print(ex);
				}
				
			}
		});
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(20, 0, 5, 0);
		gbc_btnBuscar.gridx = 3;
		gbc_btnBuscar.gridy = 0;
		contentPane.add(btnBuscar, gbc_btnBuscar);
		
		tbIdPersona = new JTextField();
		GridBagConstraints gbc_tbIdPersona = new GridBagConstraints();
		gbc_tbIdPersona.insets = new Insets(0, 0, 15, 0);
		gbc_tbIdPersona.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbIdPersona.gridx = 3;
		gbc_tbIdPersona.gridy = 1;
		contentPane.add(tbIdPersona, gbc_tbIdPersona);
		tbIdPersona.setColumns(10);
		
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
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion=null;
				try {
					conexion= getConnection();
					ps=conexion.prepareStatement("Insert into persona(clave,nombre,domicilio,celular,correo_electronico,fecha_nacimiento,genero) values(?,?,?,?,?,?,?)");
					ps.setString(1, tbClave.getText());
					ps.setString(2, tbNombre.getText());
					ps.setString(3, tbDomicilio.getText());
					ps.setString(4, tbCelular.getText());
					ps.setString(5, tbCorreoElectronico.getText());
					ps.setDate(6, Date.valueOf(tbFechaNacimiento.getText()));
					ps.setString(7, cbGenero.getSelectedItem().toString());
					
					int resultado =ps.executeUpdate();
					
					if(resultado>0)
						JOptionPane.showMessageDialog(null, "Registro insertado correctamente");
					else
						JOptionPane.showMessageDialog(null, "Error al insertar el registro");
					
					limpiarCajas();
						
				}catch(Exception ex) {
					System.err.print(ex);
				}
				try {
					conexion.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnInsertar = new GridBagConstraints();
		gbc_btnInsertar.weightx = 0.5;
		gbc_btnInsertar.insets = new Insets(0, 0, 0, 5);
		gbc_btnInsertar.gridx = 0;
		gbc_btnInsertar.gridy = 10;
		contentPane.add(btnInsertar, gbc_btnInsertar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection conexion=null;
				try {
					conexion= getConnection();
					ps=conexion.prepareStatement("update persona set clave=?,nombre=?,domicilio=?,celular=?,correo_electronico=?,fecha_nacimiento=?,genero=? where idpersona=?");
					ps.setString(1, tbClave.getText());
					ps.setString(2, tbNombre.getText());
					ps.setString(3, tbDomicilio.getText());
					ps.setString(4, tbCelular.getText());
					ps.setString(5, tbCorreoElectronico.getText());
					ps.setDate(6, Date.valueOf(tbFechaNacimiento.getText()));
					ps.setString(7, cbGenero.getSelectedItem().toString());
					ps.setInt(8, Integer.parseInt(tbIdPersona.getText()));

					int resultado =ps.executeUpdate();
					
					if(resultado>0)
						JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
					else
						JOptionPane.showMessageDialog(null, "Error al modificar el registro");
					
					limpiarCajas();
						
				}catch(Exception ex) {
					System.err.print(ex);
				}
				try {
					conexion.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.weightx = 0.5;
		gbc_btnModificar.insets = new Insets(0, 0, 0, 5);
		gbc_btnModificar.gridx = 1;
		gbc_btnModificar.gridy = 10;
		contentPane.add(btnModificar, gbc_btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection conexion=null;
				try {
					conexion= getConnection();
					ps=conexion.prepareStatement("delete from persona where idpersona=?");
					
					ps.setInt(1, Integer.parseInt(tbIdPersona.getText()));
					
					int resultado =ps.executeUpdate();
					
					if(resultado>0)
						JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
					else
						JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
					
					limpiarCajas();
						
				}catch(Exception ex) {
					System.err.print(ex);
				}
				try {
					conexion.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.weightx = 0.5;
		gbc_btnEliminar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEliminar.gridx = 2;
		gbc_btnEliminar.gridy = 10;
		contentPane.add(btnEliminar, gbc_btnEliminar);
		
		JButton btnLimpiar = new JButton("Limpiar");
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
