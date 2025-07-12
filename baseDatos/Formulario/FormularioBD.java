package baseDatos.Formulario;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class FormularioBD extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private final ButtonGroup grupoGenero = new ButtonGroup(); // ButtonGroup para los radio buttons
    private JRadioButton rdbtnHombre ;
    private JRadioButton rdbtnMujer;
    private JSpinner spinnerEdad;
    private JCheckBox chckbxFutbol;
    private JCheckBox chckbxBasquet;
    private JCheckBox chckbxBeisbol;
    private JCheckBox chckbxNewTenis;
    private JCheckBox chckbxNatacion;
    private JPanel panel;
    private JLabel lblNewLabel_2;
    private JPanel panel_1;
    private JButton btnMostrarRegistro;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormularioBD frame = new FormularioBD();
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
    public FormularioBD() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 454, 446);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[]{0, 0};
        gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 64, 32, 0, 0, 0, 0, 0, 0, 0};
        gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        contentPane.setLayout(gbl_contentPane);
        
        JLabel lblNewLabel = new JLabel("Formulario");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel.weightx = 0.5;
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Seleccione Genero");
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 10, 5, 0);
        gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 1;
        contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
        
        rdbtnHombre = new JRadioButton("Hombre");
        grupoGenero.add(rdbtnHombre); // Añadir al ButtonGroup
        GridBagConstraints gbc_rdbtnHombre = new GridBagConstraints();
        gbc_rdbtnHombre.insets = new Insets(0, 0, 5, 0);
        gbc_rdbtnHombre.fill = GridBagConstraints.BOTH;
        gbc_rdbtnHombre.gridx = 0;
        gbc_rdbtnHombre.gridy = 2;
        contentPane.add(rdbtnHombre, gbc_rdbtnHombre);
        
        rdbtnMujer = new JRadioButton("Mujer");
        grupoGenero.add(rdbtnMujer); // Añadir al ButtonGroup
        GridBagConstraints gbc_rdbtnMujer = new GridBagConstraints();
        gbc_rdbtnMujer.insets = new Insets(0, 0, 5, 0);
        gbc_rdbtnMujer.fill = GridBagConstraints.BOTH;
        gbc_rdbtnMujer.gridx = 0;
        gbc_rdbtnMujer.gridy = 3;
        contentPane.add(rdbtnMujer, gbc_rdbtnMujer);
        
        panel = new JPanel();
        panel.setLayout(null);
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(0, 0, 5, 0);
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 4;
        contentPane.add(panel, gbc_panel);
        
        lblNewLabel_2 = new JLabel("¿Cual es su edad?");
        lblNewLabel_2.setBounds(10, 13, 127, 18);
        lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
        panel.add(lblNewLabel_2);
        
        spinnerEdad = new JSpinner();
        spinnerEdad.setBounds(147, 13, 60, 45);
        panel.add(spinnerEdad);
        spinnerEdad.setAutoscrolls(true);
        spinnerEdad.setFont(new Font("Arial", Font.PLAIN, 20));
        
        JLabel lblNewLabel_3 = new JLabel("Seleccione sus deportes favoritos");
        lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
        GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
        gbc_lblNewLabel_3.insets = new Insets(0, 10, 5, 0);
        gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
        gbc_lblNewLabel_3.gridx = 0;
        gbc_lblNewLabel_3.gridy = 5;
        contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
        
        chckbxFutbol = new JCheckBox("Futbol");
        GridBagConstraints gbc_chckbxFutbol = new GridBagConstraints();
        gbc_chckbxFutbol.insets = new Insets(0, 0, 5, 0);
        gbc_chckbxFutbol.fill = GridBagConstraints.BOTH;
        gbc_chckbxFutbol.gridx = 0;
        gbc_chckbxFutbol.gridy = 6;
        contentPane.add(chckbxFutbol, gbc_chckbxFutbol);
        
        chckbxBasquet = new JCheckBox("basquetball");
        GridBagConstraints gbc_chckbxBasquet = new GridBagConstraints();
        gbc_chckbxBasquet.fill = GridBagConstraints.BOTH;
        gbc_chckbxBasquet.insets = new Insets(0, 0, 5, 0);
        gbc_chckbxBasquet.gridx = 0;
        gbc_chckbxBasquet.gridy = 7;
        contentPane.add(chckbxBasquet, gbc_chckbxBasquet);
        
        chckbxNewTenis = new JCheckBox("Tenis");
        GridBagConstraints gbc_chckbxNewTenis = new GridBagConstraints();
        gbc_chckbxNewTenis.fill = GridBagConstraints.BOTH;
        gbc_chckbxNewTenis.insets = new Insets(0, 0, 5, 0);
        gbc_chckbxNewTenis.gridx = 0;
        gbc_chckbxNewTenis.gridy = 8;
        contentPane.add(chckbxNewTenis, gbc_chckbxNewTenis);
        
        chckbxNatacion = new JCheckBox("Natacion");
        GridBagConstraints gbc_chckbxNatacion = new GridBagConstraints();
        gbc_chckbxNatacion.fill = GridBagConstraints.BOTH;
        gbc_chckbxNatacion.insets = new Insets(0, 0, 5, 0);
        gbc_chckbxNatacion.gridx = 0;
        gbc_chckbxNatacion.gridy = 9;
        contentPane.add(chckbxNatacion, gbc_chckbxNatacion);
        
        chckbxBeisbol = new JCheckBox("Beisbol");
        GridBagConstraints gbc_chckbxBeisbol = new GridBagConstraints();
        gbc_chckbxBeisbol.insets = new Insets(0, 0, 5, 0);
        gbc_chckbxBeisbol.fill = GridBagConstraints.BOTH;
        gbc_chckbxBeisbol.gridx = 0;
        gbc_chckbxBeisbol.gridy = 10;
        contentPane.add(chckbxBeisbol, gbc_chckbxBeisbol);
        
        panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.fill = GridBagConstraints.BOTH;
        gbc_panel_1.gridx = 0;
        gbc_panel_1.gridy = 11;
        contentPane.add(panel_1, gbc_panel_1);
        
        JButton btnInsertar = new JButton("Insertar registro");
        panel_1.add(btnInsertar);
        btnInsertar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Conexion con= new Conexion();
        		PreparedStatement ps=null;
        		String genero="";
        		int edad=0;
        		boolean futbol=false;
        		boolean basquetball=false;
        		boolean tenis=false;
        		boolean natacion=false;
        		boolean beisbol=false;
        		
        		if(rdbtnHombre.isSelected())
        			genero="Hombre";
        		else if(rdbtnMujer.isSelected())
        			genero="Mujer";
        		edad=Integer.parseInt(spinnerEdad.getValue().toString());
        		
        		if(chckbxFutbol.isSelected())
        			futbol=true;
        		if(chckbxBasquet.isSelected())
        			basquetball=true;
        		if(chckbxNewTenis.isSelected())
        			tenis=true;
        		if(chckbxNatacion.isSelected())
        			natacion=true;
        		if(chckbxBeisbol.isSelected())
        			beisbol=true;
        		
        		try {
					Connection conexion=con.getConnection();
					ps=conexion.prepareStatement("insert into gustospersona (genero,edad,futbol,basquet,tenis,natacion,beisbol) values (?,?,?,?,?,?,?)");
					ps.setString(1, genero);
					ps.setInt(2, edad);
					ps.setBoolean(3, futbol);
					ps.setBoolean(4, basquetball);
					ps.setBoolean(5, tenis);
					ps.setBoolean(6, natacion);
					ps.setBoolean(7, beisbol);
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Se inserto correctamente");
					conexion.close();
					
				} catch (Exception e2) {
					System.err.println(e2);
				}
        	}
        });
        btnInsertar.setFont(new Font("Arial", Font.PLAIN, 15));
        
        btnMostrarRegistro = new JButton("Mostrar Registro");
        btnMostrarRegistro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Conexion con= new Conexion();
        		PreparedStatement ps=null;
        		ResultSet rs=null;
        		
        		
        		try {
					Connection conexion=con.getConnection();
					ps=conexion.prepareStatement("select genero,edad,futbol,basquet,tenis,natacion,beisbol from gustospersona where id=?");
					ps.setInt(1, 1);
					rs=ps.executeQuery();
					
					while(rs.next()) {
						if(rs.getString("genero").equals("Hombre")) {
							rdbtnHombre.setSelected(true);
						}
						if(rs.getString("genero").equals("Mujer")) {
							rdbtnMujer.setSelected(true);
						}
						spinnerEdad.setValue(rs.getInt("edad"));
						if(rs.getBoolean("futbol"))
							chckbxFutbol.setSelected(true);
						if(rs.getBoolean("basquet"))
							chckbxBasquet.setSelected(true);
						if(rs.getBoolean("tenis"))
							chckbxNewTenis.setSelected(true);
						if(rs.getBoolean("natacion"))
							chckbxNatacion.setSelected(true);
						if(rs.getBoolean("beisbol"))
							chckbxBeisbol.setSelected(true);
												
					}
					
					conexion.close();
					
				} catch (Exception e2) {
					System.err.println(e2);
				}
        	}
        });
        btnMostrarRegistro.setFont(new Font("Arial", Font.PLAIN, 15));
        panel_1.add(btnMostrarRegistro);
    }
}