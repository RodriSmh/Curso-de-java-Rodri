package Archivos.ejercicio02;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.jDialog.VentanaPrincipalJdialog;

import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tbNombre;
	private JTextField tbEdad;
	private JTextField tbPeso;
	private JTextField tbEstatura;
	private static VentanaPrincipalJdialog frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setTitle("Registro de Atletas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 351);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		mnMenu.setFont(new Font("Arial", Font.PLAIN, 15));
		menuBar.add(mnMenu);
		
		JMenuItem mntmMenuAtletas = new JMenuItem("Mostrar altletas registrados");
		mntmMenuAtletas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtletasRegistrados a=new AtletasRegistrados(frame,true);
				a.setVisible(true);
			}
		});
		mntmMenuAtletas.setIcon(new ImageIcon(Registro.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/runner.png")));
		mntmMenuAtletas.setFont(new Font("Arial", Font.PLAIN, 15));
		mnMenu.add(mntmMenuAtletas);
		
		JSeparator separator = new JSeparator();
		mnMenu.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmSalir.setIcon(new ImageIcon(Registro.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/close-button-png-26.png")));
		mntmSalir.setFont(new Font("Arial", Font.PLAIN, 15));
		mnMenu.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 36));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.weightx = 1.0;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tbNombre = new JTextField();
		tbNombre.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_tbNombre = new GridBagConstraints();
		gbc_tbNombre.insets = new Insets(0, 0, 10, 5);
		gbc_tbNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbNombre.gridx = 1;
		gbc_tbNombre.gridy = 1;
		contentPane.add(tbNombre, gbc_tbNombre);
		tbNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Edad");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tbEdad = new JTextField();
		tbEdad.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_tbEdad = new GridBagConstraints();
		gbc_tbEdad.insets = new Insets(0, 0, 10, 5);
		gbc_tbEdad.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbEdad.gridx = 1;
		gbc_tbEdad.gridy = 2;
		contentPane.add(tbEdad, gbc_tbEdad);
		tbEdad.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Peso (kg)");
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		tbPeso = new JTextField();
		tbPeso.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_tbPeso = new GridBagConstraints();
		gbc_tbPeso.insets = new Insets(0, 0, 10, 5);
		gbc_tbPeso.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbPeso.gridx = 1;
		gbc_tbPeso.gridy = 3;
		contentPane.add(tbPeso, gbc_tbPeso);
		tbPeso.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Estatura (cm)");
		lblNewLabel_4.setForeground(SystemColor.text);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		tbEstatura = new JTextField();
		tbEstatura.setFont(new Font("Arial", Font.PLAIN, 20));
		GridBagConstraints gbc_tbEstatura = new GridBagConstraints();
		gbc_tbEstatura.insets = new Insets(0, 0, 10, 5);
		gbc_tbEstatura.fill = GridBagConstraints.HORIZONTAL;
		gbc_tbEstatura.gridx = 1;
		gbc_tbEstatura.gridy = 4;
		contentPane.add(tbEstatura, gbc_tbEstatura);
		tbEstatura.setColumns(10);
		
		JButton btnNewButton = new JButton("Registrar Atleta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre=tbNombre.getText();
				int edad=Integer.parseInt(tbEdad.getText());
				double peso=Double.parseDouble(tbPeso.getText());
				int estatura=Integer.parseInt(tbEstatura.getText());
				
				Atleta atleta=new Atleta(nombre,edad,peso,estatura);
				escribirBinario(atleta);
				tbNombre.setText("");
				tbEdad.setText("");
				tbPeso.setText("");
				tbEstatura.setText("");
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 5;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}
	private void escribirBinario(Atleta atleta) {
		try {
			FileOutputStream archivo=new FileOutputStream("CursoDJava/Archivos/ejercicio02/RegistroAtletas.bin",true);
			AñadirBinario escribir=new AñadirBinario(archivo);
			escribir.writeObject(atleta);
			escribir.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
