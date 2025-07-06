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
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tabla extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaProducto;
	private JTextField tbBuscar;
	private JTextField tbCodigo;
	private JTextField tbNombre;
	private JTextField tbPrecio;
	private JTextField tbCantidad;
	private Conexion con;
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
		setBounds(100, 100, 727, 346);
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
		tablaProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PreparedStatement ps=null;
				ResultSet rs=null;
				try {
					Conexion con=new Conexion();
					Connection conexion=con.getConnection();
					int fila=tablaProducto.getSelectedRow();
					String codigo=tablaProducto.getValueAt(fila, 0).toString();
					ps=conexion.prepareStatement("select codigo,nombre,precio,cantidad from producto where codigo=?");
					ps.setString(1, codigo);
					rs=ps.executeQuery();
					
					while(rs.next()) {
						tbCodigo.setText(rs.getString("codigo"));
						tbNombre.setText(rs.getString("nombre"));
						tbPrecio.setText(String.valueOf(rs.getDouble("precio")));
						tbCantidad.setText(String.valueOf(rs.getInt("cantidad")));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
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
		
		JLabel lblNewLabel_1 = new JLabel("Codigo");
		lblNewLabel_1.setBounds(502, 46, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		tbCodigo = new JTextField();
		tbCodigo.setBounds(569, 40, 120, 20);
		contentPane.add(tbCodigo);
		tbCodigo.setColumns(10);
		
		tbNombre = new JTextField();
		tbNombre.setBounds(569, 96, 120, 20);
		contentPane.add(tbNombre);
		tbNombre.setColumns(10);
		
		tbPrecio = new JTextField();
		tbPrecio.setBounds(569, 152, 120, 20);
		contentPane.add(tbPrecio);
		tbPrecio.setColumns(10);
		
		tbCantidad = new JTextField();
		tbCantidad.setBounds(569, 201, 120, 20);
		contentPane.add(tbCantidad);
		tbCantidad.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setBounds(502, 102, 49, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Precio");
		lblNewLabel_1_2.setBounds(502, 158, 49, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Cantidad");
		lblNewLabel_1_3.setBounds(502, 207, 49, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JButton btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps=null;
				try {
					Conexion con=new Conexion();
					
					Connection conexion=con.getConnection();
					ps= conexion.prepareStatement("insert into producto (codigo,nombre,precio,cantidad) values (?,?,?,?)");
					ps.setString(1, tbCodigo.getText());
					ps.setString(2, tbNombre.getText());
					ps.setDouble(3, Double.parseDouble(tbPrecio.getText()));
					ps.setInt(4, Integer.parseInt(tbCantidad.getText()));
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Registro insertado correctamente");
					
					
				} catch (Exception ex) {
					
				}
			}
		});
		btnInsertar.setBounds(502, 244, 89, 23);
		contentPane.add(btnInsertar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps=null;
				try {
					con=new Conexion();
					
					Connection conexion=con.getConnection();
					ps= conexion.prepareStatement("update producto set codigo=?,nombre=?,precio=?,cantidad=? where codigo=?");
					ps.setString(1, tbCodigo.getText());
					ps.setString(2, tbNombre.getText());
					ps.setDouble(3, Double.parseDouble(tbPrecio.getText()));
					ps.setInt(4, Integer.parseInt(tbCantidad.getText()));
					ps.setString(5, tbCodigo.getText());
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
					
					
				} catch (Exception ex) {
					
				}
			}
		});
		btnModificar.setBounds(614, 244, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbCodigo.setText("");
				tbNombre.setText("");
				tbPrecio.setText("");
				tbCantidad.setText("");
			}
		});
		btnLimpiar.setBounds(502, 275, 89, 23);
		contentPane.add(btnLimpiar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps=null;
				try {
					con=new Conexion();
					
					Connection conexion=con.getConnection();
					ps= conexion.prepareStatement("delete from producto where codigo=?)");
					ps.setString(1, tbCodigo.getText());
				
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Registro el-minado correctamente");
					
					
				} catch (Exception ex) {
					
				}
			}
		});
		btnEliminar.setBounds(614, 275, 89, 23);
		contentPane.add(btnEliminar);
	}
}
