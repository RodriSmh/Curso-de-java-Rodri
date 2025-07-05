package baseDatos.bd_JTable;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Tabla extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaProducto;
	private JTextField tbBuscar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabla frame = new Tabla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Tabla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 40, 482, 258);
		contentPane.add(scrollPane);
		
		tablaProducto = new JTable();
		tablaProducto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"codigo", "nombre", "precio", "cantidad"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, String.class, Double.class, Integer.class
			};
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tablaProducto);
		
		JButton btnCargar = new JButton("Cargar tabla");
		btnCargar.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modeloTabla=new DefaultTableModel();
				tablaProducto.setModel(modeloTabla);
				PreparedStatement ps=null;
				ResultSet rs=null;
				
				try {
					Conexion con=new Conexion();
					
					Connection conexion=con.getConnection();
					ps= conexion.prepareStatement("Select codigo,nombre,precio,cantidad from producto");
					rs=ps.executeQuery();
					
					modeloTabla.addColumn("codigo");
					modeloTabla.addColumn("nombre");
					modeloTabla.addColumn("precio");
					modeloTabla.addColumn("cantidad");
					
					while(rs.next()) {
						Object fila[]=new Object[4];
						for (int i = 0; i < fila.length; i++) {
							fila[i]=rs.getObject(i+1);
						}
						 modeloTabla.addRow(fila);
					}
					
				} catch (Exception ex) {
					
				}
			}
		});
		btnCargar.setBounds(370, 11, 112, 23);
		contentPane.add(btnCargar);
		
		tbBuscar = new JTextField();
		tbBuscar.setBounds(62, 12, 166, 20);
		contentPane.add(tbBuscar);
		tbBuscar.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(12, 15, 49, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnCargarRegistro = new JButton("Cargar registro");
		btnCargarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modeloTabla=new DefaultTableModel();
				tablaProducto.setModel(modeloTabla);
				PreparedStatement ps=null;
				ResultSet rs=null;
				String campo=tbBuscar.getText();
				String where="";
				if(!"".equals(campo))
					where="where codigo='"+campo+"'";
				try {
					Conexion con=new Conexion();
					
					@SuppressWarnings("static-access")
					Connection conexion=con.getConnection();
					ps= conexion.prepareStatement("Select codigo,nombre,precio,cantidad from producto "+where);
					rs=ps.executeQuery();
					
					modeloTabla.addColumn("codigo");
					modeloTabla.addColumn("nombre");
					modeloTabla.addColumn("precio");
					modeloTabla.addColumn("cantidad");
					
					ResultSetMetaData rsMD=(ResultSetMetaData) rs.getMetaData();
					int cantidadColumnas=rsMD.getColumnCount();
					
					int anchos[]= {40,150,50,70};
					for (int i = 0; i < cantidadColumnas; i++) {
						tablaProducto.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
					}
					while(rs.next()) {
						Object fila[]=new Object[cantidadColumnas];
						for (int i = 0; i < cantidadColumnas; i++) {
							fila[i]=rs.getObject(i+1);
						}
						 modeloTabla.addRow(fila);
					}
					
				} catch (Exception ex) {
					
				}
			
			}
		});
		btnCargarRegistro.setBounds(238, 11, 122, 23);
		contentPane.add(btnCargarRegistro);
	}
}
