package gui.jtree;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JTree;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;

public class jtreeVentana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultMutableTreeNode raiz= new DefaultMutableTreeNode("Raiz");
	private DefaultTreeModel modeloTree=new DefaultTreeModel(raiz);
	private JTree tree ;
	private JLabel lbRojo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jtreeVentana frame = new jtreeVentana();
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
	public jtreeVentana() {
		cargarJtree();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{271, 73, 0};
		gbl_contentPane.rowHeights = new int[]{64, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		tree = new JTree(modeloTree);
		GridBagConstraints gbc_tree = new GridBagConstraints();
		gbc_tree.insets = new Insets(0, 0, 0, 5);
		gbc_tree.weighty = 0.5;
		gbc_tree.fill = GridBagConstraints.BOTH;
		gbc_tree.gridx = 0;
		gbc_tree.gridy = 0;
		contentPane.add(tree, gbc_tree);
		
		lbRojo = new JLabel("");
		GridBagConstraints gbc_lbRojo = new GridBagConstraints();
		gbc_lbRojo.gridx = 1;
		gbc_lbRojo.gridy = 0;
		contentPane.add(lbRojo, gbc_lbRojo);
		TreeSelectionListener oyenteTree=new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode nodoSeleccionado= (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				eventoNodoSeleccionado(nodoSeleccionado);
			}
		};
		tree.getSelectionModel().addTreeSelectionListener(oyenteTree);
	}
	private void eventoNodoSeleccionado(DefaultMutableTreeNode nodo){
		if(nodo.toString().equals("Rojo"))
			lbRojo.setIcon(new ImageIcon(getClass().getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/Cuadro rojo.png")));
		if(nodo.toString().equals("Azul"))
			lbRojo.setIcon(new ImageIcon(getClass().getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/large-blue-square_1f7e6.png")));
			
	}
	private void cargarJtree() {
		DefaultMutableTreeNode Colores= new DefaultMutableTreeNode("Colores");
		DefaultMutableTreeNode ColoresRojo= new DefaultMutableTreeNode("Rojo");
		DefaultMutableTreeNode ColoresAzul= new DefaultMutableTreeNode("Azul");
		DefaultMutableTreeNode Deportes= new DefaultMutableTreeNode("Deportes");
		raiz.add(Deportes);
		raiz.add(Colores);
		Colores.add(ColoresRojo);
		Colores.add(ColoresAzul);
	}

}
