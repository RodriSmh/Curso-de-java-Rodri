package baseDatos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AplicacionBD extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static final String URL="jdbc:mysql://localhost:3306/escuela?autoReconnet=true&useSSL=false";
	public static final String usuario="root";
	public static final String contraseña="1234";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AplicacionBD frame = new AplicacionBD();
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
//			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion= DriverManager.getConnection(URL,usuario,contraseña);
			JOptionPane.showMessageDialog(null, "Conexion exitosa");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos");
			System.err.println("Error"+e);			
		}
		return conexion;
	}
	public AplicacionBD() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connection conexion= getConnection();
				PreparedStatement ps;
				ResultSet rs;
				
				try {
					ps= conexion.prepareStatement("Select * from persona");
					rs=ps.executeQuery();
					
					if(rs.next())
						JOptionPane.showMessageDialog(null, "Nombre: "+rs.getString("nombre"));
					else
						JOptionPane.showMessageDialog(null, "No existen registros");
					conexion.close();
				}catch(Exception ex) {
					System.err.println("Error: "+ex);
				}
			}
		});
		btnConectar.setBounds(183, 116, 89, 23);
		contentPane.add(btnConectar);
	}
}
