package gui.Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import java.awt.GridBagLayout;
import javax.swing.JPopupMenu;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagConstraints;
import java.awt.Dimension;

public class BarraMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BarraMenu frame = new BarraMenu();
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
	public BarraMenu() {
		setMinimumSize(new Dimension(200, 300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		final JPopupMenu popupMenu = new JPopupMenu();
		addPopup(this, popupMenu);
		
		JMenuItem mntmVentanaGrande = new JMenuItem("Ventana mas grande");
		mntmVentanaGrande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSize(500,500);
				
			}
		});
		popupMenu.add(mntmVentanaGrande);
		
		JMenuItem mntmVentanaPequeña = new JMenuItem("Ventana mas pequeña");
		mntmVentanaPequeña.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSize(200,200);
			}
		});
		popupMenu.add(mntmVentanaPequeña);
		
		JMenu mnCambiarColor = new JMenu("Cambiar Color");
		popupMenu.add(mnCambiarColor);
		
		JMenuItem mntmRojo = new JMenuItem("Rojo");
		mntmRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.red);
			}
		});
		mntmRojo.setIcon(new ImageIcon(BarraMenu.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/Cuadro rojo.png")));
		mnCambiarColor.add(mntmRojo);
		
		JMenuItem mntmAzul = new JMenuItem("Azul");
		mntmAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.blue);
			}
		});
		mntmAzul.setIcon(new ImageIcon(BarraMenu.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/large-blue-square_1f7e6.png")));
		mnCambiarColor.add(mntmAzul);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{431, 0};
		gbl_contentPane.rowHeights = new int[]{22, 235, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.isPopupTrigger())
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
					
			}
		});
		
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenu mnNewMenu = new JMenu("abrir");
		mnFile.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Arichivo 1");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Archivo 2");
		mnNewMenu.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		mntmSalir.setIcon(new ImageIcon(BarraMenu.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/close-button-png-26.png")));
		mnFile.add(mntmSalir);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		mnEdit.add(mnNewMenu_1);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_1 = new JCheckBoxMenuItem("New check item");
		mnNewMenu_1.add(chckbxmntmNewCheckItem_1);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("New check item");
		mnNewMenu_1.add(chckbxmntmNewCheckItem);
		
		JMenu mnNewMenu_2 = new JMenu("New menu");
		mnEdit.add(mnNewMenu_2);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("New radio item");
		buttonGroup.add(rdbtnmntmNewRadioItem);
		mnNewMenu_2.add(rdbtnmntmNewRadioItem);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_1 = new JRadioButtonMenuItem("New radio item");
		buttonGroup.add(rdbtnmntmNewRadioItem_1);
		mnNewMenu_2.add(rdbtnmntmNewRadioItem_1);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_2 = new JRadioButtonMenuItem("New radio item");
		buttonGroup.add(rdbtnmntmNewRadioItem_2);
		mnNewMenu_2.add(rdbtnmntmNewRadioItem_2);
		GridBagConstraints gbc_menuBar = new GridBagConstraints();
		gbc_menuBar.fill = GridBagConstraints.BOTH;
		gbc_menuBar.gridx = 0;
		gbc_menuBar.gridy = 0;
		contentPane.add(menuBar, gbc_menuBar);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
