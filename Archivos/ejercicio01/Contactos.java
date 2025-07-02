package Archivos.ejercicio01;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.JTable;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Contactos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel modeloTabla=new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Contactos dialog = new Contactos(null,true);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	private void cargarModeloTabla() {
		modeloTabla.addColumn("Nombre");
		modeloTabla.addColumn("Correo");
		modeloTabla.addColumn("Celular");
		leerContactos();
	}
	private void leerContactos() {
		try {
			FileReader lector=new FileReader("CursoDJava/Archivos/ejercicio01/agendaContactos.txt");
			BufferedReader lectura= new BufferedReader(lector);
			String cadena=lectura.readLine();
			String fila[];
			while(cadena!=null) {
				fila=cadena.split("%");
				modeloTabla.addRow(fila);
				cadena=lectura.readLine();
			}
			lectura.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Contactos(Frame owner, boolean modal) {
		super(owner, modal);
		setLocationRelativeTo(null);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		cargarModeloTabla();
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0};
		gbl_contentPanel.rowHeights = new int[]{50, 132, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("Mostrar contactos existentes");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.insets = new Insets(0, 10, 5, 0);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
		    JScrollPane scrollPane = new JScrollPane();
		    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		    
		    GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		    gbc_scrollPane.insets = new Insets(10, 10, 10, 10);
		    gbc_scrollPane.fill = GridBagConstraints.BOTH;
		    gbc_scrollPane.gridx = 0;
		    gbc_scrollPane.gridy = 1;
		    contentPanel.add(scrollPane, gbc_scrollPane);
		    
		    table = new JTable();
		    table.setColumnSelectionAllowed(true);
		    table.setCellSelectionEnabled(true);
		    table.setShowVerticalLines(true);
		    table.setShowHorizontalLines(true);
		    table.setModel(modeloTabla);
		    table.getColumnModel().getColumn(0).setPreferredWidth(80);
		    table.getColumnModel().getColumn(1).setPreferredWidth(80);
		    table.getColumnModel().getColumn(2).setPreferredWidth(80);
		    table.setFillsViewportHeight(true);
		    table.setFont(new Font("Arial", Font.PLAIN, 16));
		    
		    scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
