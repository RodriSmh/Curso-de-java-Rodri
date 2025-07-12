package baseDatos.ComboboxBD.programa;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import baseDatos.ComboboxBD.modelo.Ciudad;
//import baseDatos.ComboboxBD.modelo.Conexion;
import baseDatos.ComboboxBD.modelo.Estado;
import baseDatos.ComboboxBD.modelo.Pais;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.Insets;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.ScrollPaneConstants;
//import javax.swing.table.DefaultTableModel;
import java.awt.event.ItemListener;
//import com.mysql.cj.jdbc.result.ResultSetMetaData;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.awt.event.ItemEvent;

public class Combobox extends JFrame {

	private static final String RAWTYPES = "rawtypes";
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<Pais> ComboPaises;
	private JLabel lblNewLabel_1;
	private JComboBox<Estado> ComboEstados;
	private JLabel lblNewLabel_2;
	private JComboBox<Ciudad> ComboCiudades;

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
		gbl_contentPane.rowHeights = new int[]{110, 110, 110};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0};
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
		
		ComboPaises = new JComboBox();
		ComboPaises.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					Pais pais= (Pais) ComboPaises.getSelectedItem();
					
					Estado estado=new Estado();
					DefaultComboBoxModel modeloComboEstados= new DefaultComboBoxModel(estado.mostrarEstado(pais.getIdPais()));
					ComboEstados.setModel(modeloComboEstados);
					
					Ciudad ciudad=new Ciudad();
					DefaultComboBoxModel modeloComboCiudades=new DefaultComboBoxModel(ciudad.mostrarCiudad(estado.getIdEstado()));
					ComboCiudades.setModel(modeloComboCiudades);
				}
				
			}
		});
		GridBagConstraints gbc_ComboPaises = new GridBagConstraints();
		gbc_ComboPaises.insets = new Insets(0, 0, 5, 0);
		gbc_ComboPaises.fill = GridBagConstraints.HORIZONTAL;
		gbc_ComboPaises.gridx = 1;
		gbc_ComboPaises.gridy = 0;
		contentPane.add(ComboPaises, gbc_ComboPaises);
		Pais pais=new Pais();
		DefaultComboBoxModel modelo=new DefaultComboBoxModel(pais.mostrarPaises());
		ComboPaises.setModel(modelo);
		
		lblNewLabel_1 = new JLabel("Estado");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.weighty = 0.5;
		gbc_lblNewLabel_1.weightx = 0.5;
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		ComboEstados = new JComboBox<Estado>();
		ComboEstados.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange()==ItemEvent.SELECTED) {
					Estado estado= (Estado) ComboEstados.getSelectedItem();
					
					Ciudad ciudad=new Ciudad();
					DefaultComboBoxModel modeloComboCiudades=new DefaultComboBoxModel(ciudad.mostrarCiudad(estado.getIdEstado()));
					ComboCiudades.setModel(modeloComboCiudades);
				}
			}	
		});
		GridBagConstraints gbc_ComboEstados = new GridBagConstraints();
		gbc_ComboEstados.weighty = 0.5;
		gbc_ComboEstados.weightx = 0.5;
		gbc_ComboEstados.insets = new Insets(0, 0, 5, 0);
		gbc_ComboEstados.fill = GridBagConstraints.HORIZONTAL;
		gbc_ComboEstados.gridx = 1;
		gbc_ComboEstados.gridy = 1;
		contentPane.add(ComboEstados, gbc_ComboEstados);
		
		lblNewLabel_2 = new JLabel("Ciudad");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		ComboCiudades = new JComboBox<Ciudad>();
		GridBagConstraints gbc_ComboCiudades = new GridBagConstraints();
		gbc_ComboCiudades.fill = GridBagConstraints.HORIZONTAL;
		gbc_ComboCiudades.gridx = 1;
		gbc_ComboCiudades.gridy = 2;
		contentPane.add(ComboCiudades, gbc_ComboCiudades);
		
	}

}
