package gui.ejerciciosGUI.Ejercicio07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Ejercicio07 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio07 frame = new Ejercicio07();
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
	public Ejercicio07() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 480, 640);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		scrollPane.setViewportView(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0};
		gbl_panel.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lbImagenRedSocial = new JLabel("");
		lbImagenRedSocial.setAlignmentY(0.0f);
		lbImagenRedSocial.setIcon(new ImageIcon(Ejercicio07.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/RedSocial.jpg")));
		GridBagConstraints gbc_lbImagenRedSocial = new GridBagConstraints();
		gbc_lbImagenRedSocial.insets = new Insets(0, 10, 0, 0);
		gbc_lbImagenRedSocial.gridheight = 2;
		gbc_lbImagenRedSocial.gridx = 0;
		gbc_lbImagenRedSocial.gridy = 0;
		panel.add(lbImagenRedSocial, gbc_lbImagenRedSocial);
		
		JLabel lbTituloRedSocial = new JLabel("Titulo: Red Social");
		lbTituloRedSocial.setVerticalAlignment(SwingConstants.TOP);
		lbTituloRedSocial.setIconTextGap(0);
		lbTituloRedSocial.setAlignmentY(0.0f);
		lbTituloRedSocial.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lbTituloRedSocial = new GridBagConstraints();
		gbc_lbTituloRedSocial.anchor = GridBagConstraints.NORTHWEST;
		gbc_lbTituloRedSocial.gridheight = 2;
		gbc_lbTituloRedSocial.fill = GridBagConstraints.BOTH;
		gbc_lbTituloRedSocial.insets = new Insets(0, 20, 20, 0);
		gbc_lbTituloRedSocial.gridx = 1;
		gbc_lbTituloRedSocial.gridy = 0;
		panel.add(lbTituloRedSocial, gbc_lbTituloRedSocial);
		
		JLabel lbGeneroRedSocial = new JLabel("Genero: Drama");
		lbGeneroRedSocial.setFont(new Font("Arial", Font.PLAIN, 15));
		lbGeneroRedSocial.setHorizontalTextPosition(SwingConstants.LEFT);
		lbGeneroRedSocial.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lbGeneroRedSocial = new GridBagConstraints();
		gbc_lbGeneroRedSocial.insets = new Insets(50, 20, 0, 0);
		gbc_lbGeneroRedSocial.anchor = GridBagConstraints.NORTHWEST;
		gbc_lbGeneroRedSocial.gridx = 1;
		gbc_lbGeneroRedSocial.gridy = 1;
		panel.add(lbGeneroRedSocial, gbc_lbGeneroRedSocial);
		
		JLabel lbImagenJobs = new JLabel("");
		lbImagenJobs.setIcon(new ImageIcon(Ejercicio07.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/Jobs.jpg")));
		GridBagConstraints gbc_lbImagenJobs = new GridBagConstraints();
		gbc_lbImagenJobs.gridheight = 2;
		gbc_lbImagenJobs.insets = new Insets(10, 10, 0, 0);
		gbc_lbImagenJobs.gridx = 0;
		gbc_lbImagenJobs.gridy = 2;
		panel.add(lbImagenJobs, gbc_lbImagenJobs);
		
		JLabel lbTituloJobs = new JLabel("Titulo: JOBS\r\n");
		lbTituloJobs.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lbTituloJobs = new GridBagConstraints();
		gbc_lbTituloJobs.insets = new Insets(10, 20, 0, 0);
		gbc_lbTituloJobs.fill = GridBagConstraints.BOTH;
		gbc_lbTituloJobs.anchor = GridBagConstraints.NORTHWEST;
		gbc_lbTituloJobs.gridx = 1;
		gbc_lbTituloJobs.gridy = 2;
		panel.add(lbTituloJobs, gbc_lbTituloJobs);
		
		JLabel lbGeneroJobs = new JLabel("Genero: Drama");
		lbGeneroJobs.setFont(new Font("Arial", Font.PLAIN, 15));
		lbGeneroJobs.setVerticalTextPosition(SwingConstants.TOP);
		lbGeneroJobs.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_lbGeneroJobs = new GridBagConstraints();
		gbc_lbGeneroJobs.insets = new Insets(30, 20, 5, 0);
		gbc_lbGeneroJobs.anchor = GridBagConstraints.NORTHWEST;
		gbc_lbGeneroJobs.gridx = 1;
		gbc_lbGeneroJobs.gridy = 3;
		panel.add(lbGeneroJobs, gbc_lbGeneroJobs);
		
		JLabel lbImagenEnigma = new JLabel("");
		lbImagenEnigma.setIcon(new ImageIcon(Ejercicio07.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/CodigoEnigma.jpg")));
		GridBagConstraints gbc_lbImagenEnigma = new GridBagConstraints();
		gbc_lbImagenEnigma.insets = new Insets(10, 10, 0, 0);
		gbc_lbImagenEnigma.gridheight = 2;
		gbc_lbImagenEnigma.gridx = 0;
		gbc_lbImagenEnigma.gridy = 4;
		panel.add(lbImagenEnigma, gbc_lbImagenEnigma);
		
		JLabel lbTituloEnigma = new JLabel("Titulo: Codigo Enigma");
		lbTituloEnigma.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lbTituloEnigma = new GridBagConstraints();
		gbc_lbTituloEnigma.anchor = GridBagConstraints.NORTHWEST;
		gbc_lbTituloEnigma.insets = new Insets(10, 20, 0, 0);
		gbc_lbTituloEnigma.gridx = 1;
		gbc_lbTituloEnigma.gridy = 4;
		panel.add(lbTituloEnigma, gbc_lbTituloEnigma);
		
		JLabel lbGeneroEnigma = new JLabel("Genero: Biografico");
		lbGeneroEnigma.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_lbGeneroEnigma = new GridBagConstraints();
		gbc_lbGeneroEnigma.insets = new Insets(20, 20, 0, 0);
		gbc_lbGeneroEnigma.anchor = GridBagConstraints.NORTHWEST;
		gbc_lbGeneroEnigma.gridx = 1;
		gbc_lbGeneroEnigma.gridy = 5;
		panel.add(lbGeneroEnigma, gbc_lbGeneroEnigma);
		
		JLabel lbImagenAprendices = new JLabel("");
		lbImagenAprendices.setIcon(new ImageIcon(Ejercicio07.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/Aprendices.jpg")));
		GridBagConstraints gbc_lbImagenAprendices = new GridBagConstraints();
		gbc_lbImagenAprendices.gridheight = 2;
		gbc_lbImagenAprendices.insets = new Insets(10, 10, 0, 0);
		gbc_lbImagenAprendices.gridx = 0;
		gbc_lbImagenAprendices.gridy = 6;
		panel.add(lbImagenAprendices, gbc_lbImagenAprendices);
		
		JLabel lbTituloAprendices = new JLabel("Titulo: Aprendices fuera de linea");
		lbTituloAprendices.setFont(new Font("Arial", Font.BOLD, 18));
		GridBagConstraints gbc_lbTituloAprendices = new GridBagConstraints();
		gbc_lbTituloAprendices.insets = new Insets(10, 20, 0, 10);
		gbc_lbTituloAprendices.gridx = 1;
		gbc_lbTituloAprendices.gridy = 6;
		panel.add(lbTituloAprendices, gbc_lbTituloAprendices);
		
		JLabel lbGeneroAprendices = new JLabel("Genero: Comedia");
		lbGeneroAprendices.setFont(new Font("Arial", Font.PLAIN, 15));
		GridBagConstraints gbc_lbGeneroAprendices = new GridBagConstraints();
		gbc_lbGeneroAprendices.insets = new Insets(20, 20, 0, 0);
		gbc_lbGeneroAprendices.anchor = GridBagConstraints.NORTHWEST;
		gbc_lbGeneroAprendices.gridx = 1;
		gbc_lbGeneroAprendices.gridy = 7;
		panel.add(lbGeneroAprendices, gbc_lbGeneroAprendices);
	}

}
