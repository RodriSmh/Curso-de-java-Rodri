package baseDatos.ejemplo_mvc.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField tbNumero1;
	public JTextField tbNumero2;
	public JTextField tbResultado;
	public JButton btnSumar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
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
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 183);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tbNumero1 = new JTextField();
		tbNumero1.setBounds(10, 56, 96, 20);
		contentPane.add(tbNumero1);
		tbNumero1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("+");
		lblNewLabel.setBounds(117, 59, 49, 14);
		contentPane.add(lblNewLabel);
		
		tbNumero2 = new JTextField();
		tbNumero2.setBounds(141, 56, 96, 20);
		contentPane.add(tbNumero2);
		tbNumero2.setColumns(10);
		
		btnSumar = new JButton("sumar");
		btnSumar.setBounds(247, 55, 89, 23);
		contentPane.add(btnSumar);
		
		tbResultado = new JTextField();
		tbResultado.setBounds(340, 56, 96, 20);
		contentPane.add(tbResultado);
		tbResultado.setColumns(10);
	}
}
