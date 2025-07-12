package baseDatos.RegistroUsuarios.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static RegistroUsuarios registro;
	public static IniciarSesion IniciarSesion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(registro==null) {
					registro = new RegistroUsuarios();
					registro.setVisible(true);
				}
			}
		});
		btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRegistrar.setBounds(62, 107, 123, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(IniciarSesion==null) {
					IniciarSesion=new IniciarSesion();
					IniciarSesion.setVisible(true);
				}
			}
		});
		btnIniciarSesion.setFont(new Font("Arial", Font.PLAIN, 15));
		btnIniciarSesion.setBounds(234, 107, 123, 23);
		contentPane.add(btnIniciarSesion);
	}
}
