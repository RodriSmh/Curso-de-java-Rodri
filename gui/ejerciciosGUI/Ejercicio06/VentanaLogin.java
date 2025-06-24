package gui.ejerciciosGUI.Ejercicio06;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class VentanaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static VentanaLogin frame;
	private JTextField tbUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaLogin();
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
	public VentanaLogin() {
		setUndecorated(true);
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 470);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 400, 470);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JLabel lbLogin = new JLabel("");
		lbLogin.setHorizontalAlignment(SwingConstants.CENTER);
		final ImageIcon log=new ImageIcon(getClass().getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/login.png"));
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario="Rodri";
				String contraseña="1809";
				
				if(usuario.equals(tbUsuario.getText())) {
//					JOptionPane.showMessageDialog(null, "Inicio sesion correcto");
					String contraseñaObtenida="";
					for(int i=0;i<passwordField.getPassword().length;i++)
						contraseñaObtenida+=passwordField.getPassword()[i];
					
					if(contraseña.equals(contraseñaObtenida))
						JOptionPane.showMessageDialog(null, "Inicio sesion correcto");
					else
						JOptionPane.showMessageDialog(null, "Contraseña desconocida");
				}
				else
					JOptionPane.showMessageDialog(null, "Usuario desconocido");
				
				
			}
		});
		btnLogin.setBounds(277, 412, 101, 26);
		panel.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
		passwordField.setBounds(162, 360, 150, 20);
		panel.add(passwordField);
		
		tbUsuario = new JTextField();
		tbUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		tbUsuario.setBounds(162, 308, 150, 20);
		panel.add(tbUsuario);
		tbUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 18));
		lblContrasea.setBounds(30, 364, 120, 16);
		panel.add(lblContrasea);
		
		JLabel lbUsuario = new JLabel("Usuario:");
		lbUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lbUsuario.setFont(new Font("Arial", Font.BOLD, 18));
		lbUsuario.setForeground(new Color(255, 255, 255));
		lbUsuario.setBounds(65, 312, 85, 16);
		panel.add(lbUsuario);
		lbLogin.setIcon(new ImageIcon(log.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
		
		lbLogin.setBounds(77, 50, 250, 250);
		panel.add(lbLogin);
		btnSalir.setBounds(277, 13, 101, 26);
		panel.add(btnSalir);
		
		JLabel lbBackground = new JLabel("");
		lbBackground.setIcon(new ImageIcon(VentanaLogin.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/backg.jpg")));
		lbBackground.setBounds(0, 0, 406, 491);
		panel.add(lbBackground);
	}
}
