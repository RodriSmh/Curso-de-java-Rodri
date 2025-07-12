package baseDatos.Calendario.Programa;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

import baseDatos.Calendario.modelo.Conexion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.ActionEvent;

public class VentanaCalendario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDateChooser dateChooser;
	private JButton btnInsertarFecha;
	private JButton btnCargar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCalendario frame = new VentanaCalendario();
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
	public VentanaCalendario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(40, 52, 254, 37);
		contentPane.add(dateChooser);
		
		JButton btnMostrarFecha = new JButton("Mostrar Fecha");
		btnMostrarFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date= dateChooser.getDate();
				long d=date.getTime();
				java.sql.Date fecha= new java.sql.Date(d);
				
				JOptionPane.showMessageDialog(null, fecha);
			}
		});
		btnMostrarFecha.setBounds(40, 138, 129, 23);
		contentPane.add(btnMostrarFecha);
		
		btnInsertarFecha = new JButton("insertar fecha");
		btnInsertarFecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion con=new Conexion();
				PreparedStatement ps=null;
				
				try {
					Connection conexion= con.getConnection();
					ps=conexion.prepareStatement("insert into fecha (fecha) values (?)");
					
					Date date= dateChooser.getDate();
					long d=date.getTime();
					java.sql.Date fecha= new java.sql.Date(d);
					
					ps.setDate(1, fecha);
					ps.executeUpdate();
					conexion.close();
					
					JOptionPane.showMessageDialog(null, "fecha insertada correctamente");
				} catch (Exception e2) {
					System.err.println(e2);
				}
			}
		});
		btnInsertarFecha.setBounds(312, 62, 114, 23);
		contentPane.add(btnInsertarFecha);
		
		btnCargar = new JButton("Cargar fecha");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion con=new Conexion();
				PreparedStatement ps=null;
				ResultSet rs=null;
				try {
					Connection conexion= con.getConnection();
					ps=conexion.prepareStatement("select fecha from fecha where idfecha=?");
					
					ps.setInt(1,1);
					rs=ps.executeQuery();
					
					while(rs.next())
						dateChooser.setDate(rs.getDate("fecha"));
					conexion.close();
					
//					JOptionPane.showMessageDialog(null, "fecha insertada correctamente");
				} catch (Exception e2) {
					System.err.println(e2);
				}
			}
		});
		btnCargar.setBounds(312, 138, 114, 23);
		contentPane.add(btnCargar);
	}
}
