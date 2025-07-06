package baseDatos.ComboboxBD.programa;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import baseDatos.ComboboxBD.modelo.Conexion;
import baseDatos.ComboboxBD.modelo.Pais;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ItemEvent;

public class Combobox extends JFrame {

	private static final String RAWTYPES = "rawtypes";
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<Pais> ComboPaises;
	private JScrollPane scrollPane;
	private JTable tablaEstados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Combobox frame = new Combobox();
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
	@SuppressWarnings({ "unchecked", RAWTYPES })
	public Combobox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{91, 334, 0};
		gbl_contentPane.rowHeights = new int[]{81, 266};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Pais");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.weightx = 0.5;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		ComboPaises = new JComboBox<Pais>();
		ComboPaises.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					Pais pais= (Pais) ComboPaises.getSelectedItem();
					DefaultTableModel modeloTabla=new DefaultTableModel();
					tablaEstados.setModel(modeloTabla);
					PreparedStatement ps=null;
					ResultSet rs=null;
					
					try {
						Conexion con=new Conexion();
						
						Connection conexion=con.getConnection();
						ps= conexion.prepareStatement("Select idEstado,nombreEstado from estados where idPais="+pais.getIdPais());
						rs=ps.executeQuery();
						
						modeloTabla.addColumn("idEstado");
						modeloTabla.addColumn("Nombre estado");
						
						
						ResultSetMetaData rsMD=(ResultSetMetaData) rs.getMetaData();
						int cantidadColumnas=rsMD.getColumnCount();
						
						int anchos[]= {40,150};
						for (int i = 0; i < cantidadColumnas; i++) {
							tablaEstados.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
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
				
			}
		});
		GridBagConstraints gbc_ComboPaises = new GridBagConstraints();
		gbc_ComboPaises.insets = new Insets(0, 0, 5, 0);
		gbc_ComboPaises.fill = GridBagConstraints.HORIZONTAL;
		gbc_ComboPaises.gridx = 1;
		gbc_ComboPaises.gridy = 0;
		contentPane.add(ComboPaises, gbc_ComboPaises);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		tablaEstados = new JTable();
		tablaEstados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idEstado", "Nombre estado"
			}
		) {
			
			private static final long serialVersionUID = 1L;

			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tablaEstados.getColumnModel().getColumn(0).setPreferredWidth(45);
		tablaEstados.getColumnModel().getColumn(1).setPreferredWidth(60);
		scrollPane.setViewportView(tablaEstados);
		Pais pais=new Pais();
		DefaultComboBoxModel modelo=new DefaultComboBoxModel(pais.mostrarPaises());
		ComboPaises.setModel(modelo);
		
	}

}
