package baseDatos.RegistroUsuarios.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import baseDatos.RegistroUsuarios.modelo.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class RegistroUsuarios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tbUsuario;
	private JTextField tbNombre;
	private JTextField tbCorreo;
	private JButton btnRegistrar;
	private JPasswordField pfContraseña;
	private JPasswordField pfConfirmar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroUsuarios frame = new RegistroUsuarios();
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
	public RegistroUsuarios() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Inicio.registro=null;
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 319, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.weightx = 0.5;
		gbc_lblUsuario.insets = new Insets(20, 0, 5, 5);
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.gridx = 0;
		gbc_lblUsuario.gridy = 0;
		contentPane.add(lblUsuario, gbc_lblUsuario);
		
		tbUsuario = new JTextField();
		tbUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_tbUsuario = new GridBagConstraints();
		gbc_tbUsuario.insets = new Insets(20, 20, 5, 20);
		gbc_tbUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbUsuario.gridx = 1;
		gbc_tbUsuario.gridy = 0;
		contentPane.add(tbUsuario, gbc_tbUsuario);
		tbUsuario.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_lblContraseña = new GridBagConstraints();
		gbc_lblContraseña.anchor = GridBagConstraints.EAST;
		gbc_lblContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_lblContraseña.gridx = 0;
		gbc_lblContraseña.gridy = 1;
		contentPane.add(lblContraseña, gbc_lblContraseña);
		
		pfContraseña = new JPasswordField();
		pfContraseña.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_pfContraseña = new GridBagConstraints();
		gbc_pfContraseña.insets = new Insets(0, 20, 5, 20);
		gbc_pfContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_pfContraseña.gridx = 1;
		gbc_pfContraseña.gridy = 1;
		contentPane.add(pfContraseña, gbc_pfContraseña);
		
		JLabel lblConfirmar = new JLabel("<html>Confirmar Contraseña</html>");
		lblConfirmar.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_lblConfirmar = new GridBagConstraints();
		gbc_lblConfirmar.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmar.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmar.gridx = 0;
		gbc_lblConfirmar.gridy = 2;
		contentPane.add(lblConfirmar, gbc_lblConfirmar);
		
		pfConfirmar = new JPasswordField();
		pfConfirmar.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_pfConfirmar = new GridBagConstraints();
		gbc_pfConfirmar.insets = new Insets(0, 20, 5, 20);
		gbc_pfConfirmar.fill = GridBagConstraints.HORIZONTAL;
		gbc_pfConfirmar.gridx = 1;
		gbc_pfConfirmar.gridy = 2;
		contentPane.add(pfConfirmar, gbc_pfConfirmar);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		tbNombre = new JTextField();
		tbNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_tbNombre = new GridBagConstraints();
		gbc_tbNombre.insets = new Insets(0, 20, 5, 20);
		gbc_tbNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbNombre.gridx = 1;
		gbc_tbNombre.gridy = 3;
		contentPane.add(tbNombre, gbc_tbNombre);
		tbNombre.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Correo");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		tbCorreo = new JTextField();
		tbCorreo.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_tbCorreo = new GridBagConstraints();
		gbc_tbCorreo.insets = new Insets(0, 20, 5, 20);
		gbc_tbCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbCorreo.gridx = 1;
		gbc_tbCorreo.gridy = 4;
		contentPane.add(tbCorreo, gbc_tbCorreo);
		tbCorreo.setColumns(10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario=new Usuario();
				SQLUsuario sqlUsuario=new SQLUsuario();
				
				String contraseña=new String(pfContraseña.getPassword());
				String confirmar=new String(pfConfirmar.getPassword());
				
				if(tbNombre.getText().equals("")||contraseña.equals("")||confirmar.equals("")||tbCorreo.getText().equals("")||tbUsuario.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor ingresa todas los datos pedidos");
				}else {
					if(contraseña.equals(confirmar)) {
						
						String nuevaContraseña=CifrarContraseña.md5(contraseña);
						if(sqlUsuario.verificarUsuario(tbUsuario.getText())==0) {
							if(sqlUsuario.comprobarEmail(tbCorreo.getText())) {
								usuario.setNombre(tbNombre.getText());
								usuario.setContraseña(nuevaContraseña);
								usuario.setCorreo(tbCorreo.getText());
								usuario.setUsuario(tbUsuario.getText());
								usuario.setIdTipo_usuario(1);
								if(sqlUsuario.registrar(usuario)) {
									JOptionPane.showMessageDialog(null, "Se registro correctamente el usuario");
									limpiarCajas();
									
								}
								else
									JOptionPane.showMessageDialog(null, "error al registrar usuario");
							}
							else
								JOptionPane.showMessageDialog(null, "error patron de correo incorrecto");
						}else
							JOptionPane.showMessageDialog(null, "error usuario ya existe");
					}
					else
						JOptionPane.showMessageDialog(null, "Las contraseñas no coniciden");
				}
			}
		});
		btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_btnRegistrar = new GridBagConstraints();
		gbc_btnRegistrar.insets = new Insets(0, 0, 20, 0);
		gbc_btnRegistrar.gridx = 1;
		gbc_btnRegistrar.gridy = 5;
		contentPane.add(btnRegistrar, gbc_btnRegistrar);
		
	}
	private void limpiarCajas() {
		tbUsuario.setText("");
		pfConfirmar.setText("");
		pfContraseña.setText("");
		tbNombre.setText("");
		tbCorreo.setText("");
	}

}
