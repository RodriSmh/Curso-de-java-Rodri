package gui.ejerciciosGUI.Ejercicio04;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Ejercicio04 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField tbNombre;
	private JTextField tbApellido;
	private JTextField tbEmail;
	private JTextField tbCelular;
	private JTextField tbDireccion;
	private DefaultComboBoxModel<Persona> modelo=new DefaultComboBoxModel<Persona>();
	private DefaultTableModel modeloTabla=new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio04 frame = new Ejercicio04();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private void modeloTabla() {
		modeloTabla.addColumn("Nombres");
		modeloTabla.addColumn("Apellido");
		modeloTabla.addColumn("Email");
		modeloTabla.addColumn("Celular");
		modeloTabla.addColumn("Direccion");
	}
	private void llenarComboBox() {
		modelo.addElement(new Persona("Rodrigo", "Paez", "rodrigoagp7@gmail.com","666-777-444-2233" , "Calle #5"));
		modelo.addElement(new Persona("Quetzalli", "Lopez", "Qetza@gmail.com", "665-488-4444", "Calle #6"));
		modelo.addElement(new Persona("Sofía", "Martínez", "sofia.martinez@email.com", "655-123-4567", "Avenida Principal 123"));
		modelo.addElement(new Persona("Alejandro", "Gutiérrez", "alejandro.gtz@email.com", "677-890-1234", "Calle Luna 45"));
		modelo.addElement(new Persona("Valeria", "Ramírez", "valeria.ramirez@email.com", "688-567-8901", "Paseo del Mar 78"));
		modelo.addElement(new Persona("Diego", "Hernández", "diego.hdz@email.com", "699-234-5678", "Boulevard Central 56"));
		modelo.addElement(new Persona("Camila", "Torres", "camila.torres@email.com", "611-345-6789", "Callejón del Sol 34"));
		modelo.addElement(new Persona("Javier", "Ortega", "javier.ortega@email.com", "622-456-7890", "Avenida Libertad 12"));
		modelo.addElement(new Persona("Mariana", "Silva", "mariana.silva@email.com", "633-567-8901", "Plaza Central 90"));
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Ejercicio04() {
		setAutoRequestFocus(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 500, 430));
		
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 454, 494);
		contentPane.add(panel);
		panel.setLayout(null);
		
		llenarComboBox();
		modeloTabla();
		JLabel lbPersona = new JLabel("Persona");
		lbPersona.setBounds(10, 11, 67, 30);
		lbPersona.setHorizontalAlignment(SwingConstants.CENTER);
		lbPersona.setFont(new Font("Arial", Font.PLAIN, 14));
		panel.add(lbPersona);
		
		final JComboBox cbPersona = new JComboBox();
		cbPersona.setModel(modelo);
		cbPersona.setBounds(10, 43, 230, 22);
		panel.add(cbPersona);
		
		JButton btnInsertarPersona = new JButton("Insertar Persona");
		btnInsertarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Persona p=(Persona)cbPersona.getSelectedItem();
				String nombre=p.getNombre();
				String apellido=p.getApellidos();
				String email=p.getEmail();
				String celular=p.getCelular();
				String direccion=p.getDireccion();
				String persona[]= {nombre,apellido,email,celular,direccion};
				modeloTabla.addRow(persona);
			}
		});
		btnInsertarPersona.setFont(new Font("Arial", Font.PLAIN, 12));
		btnInsertarPersona.setBounds(252, 43, 181, 23);
		panel.add(btnInsertarPersona);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 76, 433, 146);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setShowVerticalLines(true);
		table.setShowHorizontalLines(true);
		table.setModel(modeloTabla);
		table.getColumnModel().getColumn(0).setPreferredWidth(80);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		
		ListSelectionListener oyente= new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(e.getValueIsAdjusting()) {
					int fila=table.getSelectedRow();
					String nombre=modeloTabla.getValueAt(fila, 0).toString();
					String apellido=modeloTabla.getValueAt(fila, 1).toString();
					String email=modeloTabla.getValueAt(fila, 2).toString();
					String celular=modeloTabla.getValueAt(fila, 3).toString();
					String direccion=modeloTabla.getValueAt(fila, 4).toString();
					tbNombre.setText(nombre);
					tbApellido.setText(apellido);
					tbEmail.setText(email);
					tbCelular.setText(celular);
					tbDireccion.setText(direccion);
				}
				
			}
		};
		table.getSelectionModel().addListSelectionListener(oyente);
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 233, 433, 14);
		panel.add(separator);
		
		JLabel lbDatosPersona = new JLabel("Datos de la persona");
		lbDatosPersona.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lbDatosPersona.setBounds(10, 233, 143, 20);
		panel.add(lbDatosPersona);
		
		JLabel lbNombre = new JLabel("Nombre");
		lbNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lbNombre.setFont(new Font("Arial", Font.PLAIN, 14));
		lbNombre.setBounds(10, 262, 67, 30);
		panel.add(lbNombre);
		
		tbNombre = new JTextField();
		tbNombre.setBounds(10, 303, 181, 20);
		panel.add(tbNombre);
		tbNombre.setColumns(10);
		
		JLabel lbApellidos = new JLabel("Apellidos");
		lbApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		lbApellidos.setFont(new Font("Arial", Font.PLAIN, 14));
		lbApellidos.setBounds(253, 258, 67, 30);
		panel.add(lbApellidos);
		
		tbApellido = new JTextField();
		tbApellido.setColumns(10);
		tbApellido.setBounds(252, 303, 181, 20);
		panel.add(tbApellido);
		
		tbEmail = new JTextField();
		tbEmail.setColumns(10);
		tbEmail.setBounds(10, 375, 181, 20);
		panel.add(tbEmail);
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lbEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		lbEmail.setBounds(10, 334, 67, 30);
		panel.add(lbEmail);
		
		tbCelular = new JTextField();
		tbCelular.setColumns(10);
		tbCelular.setBounds(252, 375, 181, 20);
		panel.add(tbCelular);
		
		tbDireccion = new JTextField();
		tbDireccion.setColumns(10);
		tbDireccion.setBounds(10, 447, 423, 20);
		panel.add(tbDireccion);
		
		JLabel lbDireccion = new JLabel("Direccion");
		lbDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		lbDireccion.setFont(new Font("Arial", Font.PLAIN, 14));
		lbDireccion.setBounds(10, 406, 67, 30);
		panel.add(lbDireccion);
		
		JLabel lbCelular = new JLabel("Celular");
		lbCelular.setHorizontalAlignment(SwingConstants.CENTER);
		lbCelular.setFont(new Font("Arial", Font.PLAIN, 14));
		lbCelular.setBounds(252, 334, 67, 30);
		panel.add(lbCelular);
	}
}
