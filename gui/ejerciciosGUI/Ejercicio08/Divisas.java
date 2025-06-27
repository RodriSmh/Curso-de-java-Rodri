package gui.ejerciciosGUI.Ejercicio08;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;

public class Divisas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String divisa1="";
	private String divisa2="";
	private String cantidad="";
	private JLabel lbDivisa1;
	private JLabel lbDivisa2;
	private JLabel lbCambio1;
	private JLabel lbCambio2;
	private double dinero,cambio;
	private boolean punto=true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null, "No se pudo gfe");;
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Divisas frameDivisa = new Divisas();
					frameDivisa.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Divisas() {
		divisa1 = "Estados Unidos - Dólar";
		divisa2 = "Estados Unidos - Dólar";
		setTitle("Cambio de divisas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 450);
		setSize(300, 450);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUsos = new JMenu("Usos");
		mnUsos.setFont(new Font("Arial", Font.PLAIN, 16));
		menuBar.add(mnUsos);
		
		JMenuItem mntmCalculadora = new JMenuItem("Calculadora");
		mntmCalculadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCalculadora v= new VentanaCalculadora();
				v.setVisible(true);
				dispose();
			}
		});
		mntmCalculadora.setIcon(new ImageIcon(VentanaCalculadora.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/Calculadora.png")));
		mnUsos.add(mntmCalculadora);
		
		JMenuItem mntmDivisas = new JMenuItem("Cambio de divisias");
		mntmDivisas.setIcon(new ImageIcon(VentanaCalculadora.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/divisas.png")));
		mnUsos.add(mntmDivisas);
		
		JSeparator separator = new JSeparator();
		mnUsos.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmSalir.setIcon(new ImageIcon(VentanaCalculadora.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/close-button-png-26.png")));
		mnUsos.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lbDivisa1 = new JLabel("$");
		lbDivisa1.setFont(new Font("Arial", Font.PLAIN, 36));
		GridBagConstraints gbc_lbDivisa1 = new GridBagConstraints();
		gbc_lbDivisa1.insets = new Insets(15, 15, 5, 5);
		gbc_lbDivisa1.weighty = 0.5;
		gbc_lbDivisa1.weightx = 0.5;
		gbc_lbDivisa1.fill = GridBagConstraints.BOTH;
		gbc_lbDivisa1.gridx = 0;
		gbc_lbDivisa1.gridy = 0;
		contentPane.add(lbDivisa1, gbc_lbDivisa1);
		
		lbCambio1 = new JLabel("0");
		lbCambio1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbCambio1.setFont(new Font("Arial", Font.PLAIN, 36));
		GridBagConstraints gbc_lbCambio1 = new GridBagConstraints();
		gbc_lbCambio1.insets = new Insets(15, 0, 5, 0);
		gbc_lbCambio1.gridwidth = 2;
		gbc_lbCambio1.weighty = 0.5;
		gbc_lbCambio1.weightx = 0.5;
		gbc_lbCambio1.fill = GridBagConstraints.BOTH;
		gbc_lbCambio1.gridx = 1;
		gbc_lbCambio1.gridy = 0;
		contentPane.add(lbCambio1, gbc_lbCambio1);
		
		
		
		final JComboBox<Object> comboBox1 = new JComboBox<Object>();
		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				divisa1 = comboBox1.getSelectedItem().toString();
		        actualizarSimbolosYConversion();
					
					
			}
		});
		comboBox1.setModel(new DefaultComboBoxModel<Object>(new String[] {"Estados Unidos - Dólar", "Europa - Euro", "México - Pesos Mexicanos"}));
		comboBox1.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_comboBox1 = new GridBagConstraints();
		gbc_comboBox1.weighty = 0.5;
		gbc_comboBox1.weightx = 0.5;
		gbc_comboBox1.gridwidth = 3;
		gbc_comboBox1.insets = new Insets(0, 5, 5, 5);
		gbc_comboBox1.fill = GridBagConstraints.BOTH;
		gbc_comboBox1.gridx = 0;
		gbc_comboBox1.gridy = 1;
		contentPane.add(comboBox1, gbc_comboBox1);
		
		lbDivisa2 = new JLabel("$");
		lbDivisa2.setFont(new Font("Arial", Font.PLAIN, 36));
		GridBagConstraints gbc_lbDivisa2 = new GridBagConstraints();
		gbc_lbDivisa2.weighty = 0.5;
		gbc_lbDivisa2.weightx = 0.5;
		gbc_lbDivisa2.fill = GridBagConstraints.BOTH;
		gbc_lbDivisa2.insets = new Insets(15, 15, 0, 0);
		gbc_lbDivisa2.gridx = 0;
		gbc_lbDivisa2.gridy = 2;
		contentPane.add(lbDivisa2, gbc_lbDivisa2);
		
		lbCambio2 = new JLabel("0");
		lbCambio2.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbCambio2.setFont(new Font("Arial", Font.PLAIN, 36));
		GridBagConstraints gbc_lbCambio2 = new GridBagConstraints();
		gbc_lbCambio2.insets = new Insets(15, 0, 5, 0);
		gbc_lbCambio2.gridwidth = 2;
		gbc_lbCambio2.weighty = 0.5;
		gbc_lbCambio2.weightx = 0.5;
		gbc_lbCambio2.fill = GridBagConstraints.BOTH;
		gbc_lbCambio2.gridx = 1;
		gbc_lbCambio2.gridy = 2;
		contentPane.add(lbCambio2, gbc_lbCambio2);
		
		final JComboBox<String> comboBox2 = new JComboBox<String>();
		comboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				divisa2 = comboBox2.getSelectedItem().toString();
		        actualizarSimbolosYConversion(); // Nueva función
			}
		});
		comboBox2.setModel(new DefaultComboBoxModel<String>(new String[] {"Estados Unidos - Dólar", "Europa - Euro", "México - Pesos Mexicanos"}));
		comboBox2.setFont(new Font("Arial", Font.PLAIN, 14));
		GridBagConstraints gbc_comboBox2 = new GridBagConstraints();
		gbc_comboBox2.weighty = 0.5;
		gbc_comboBox2.weightx = 0.5;
		gbc_comboBox2.gridwidth = 3;
		gbc_comboBox2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox2.fill = GridBagConstraints.BOTH;
		gbc_comboBox2.gridx = 0;
		gbc_comboBox2.gridy = 3;
		contentPane.add(comboBox2, gbc_comboBox2);
		
		

		JButton btnClear = new JButton("C");
		btnClear.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbCambio1.setText("0");
				lbCambio2.setText("0");
				cantidad="";
				punto=true;
			}
		});
		btnClear.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.weighty = 0.5;
		gbc_btnClear.weightx = 0.5;
		gbc_btnClear.fill = GridBagConstraints.BOTH;
		gbc_btnClear.insets = new Insets(0, 0, 5, 5);
		gbc_btnClear.gridx = 1;
		gbc_btnClear.gridy = 4;
		contentPane.add(btnClear, gbc_btnClear);
		JButton btnBorrar = new JButton("");
		btnBorrar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tamaño=cantidad.length();
				if(tamaño>0) {
					if(tamaño==1)
						cantidad="0";
					else
					cantidad=cantidad.substring(0, tamaño-1);
					lbCambio1.setText(cantidad);
					obtenerDinero();
				}
			}
		});
		btnBorrar.setIcon(new ImageIcon(VentanaCalculadora.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/delete (1).png")));
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBorrar.weighty = 0.5;
		gbc_btnBorrar.weightx = 0.5;
		gbc_btnBorrar.fill = GridBagConstraints.BOTH;
		gbc_btnBorrar.gridx = 2;
		gbc_btnBorrar.gridy = 4;
		contentPane.add(btnBorrar, gbc_btnBorrar);

		JButton btn7 = new JButton("7");
		btn7.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbCambio1.getText().equals("0"))
					cantidad="7";
				else
				cantidad+="7";
				lbCambio1.setText(cantidad);
				obtenerDinero();
			}
		});
		btn7.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btn7 = new GridBagConstraints();
		gbc_btn7.weighty = 0.5;
		gbc_btn7.weightx = 0.5;
		gbc_btn7.fill = GridBagConstraints.BOTH;
		gbc_btn7.insets = new Insets(0, 0, 5, 5);
		gbc_btn7.gridx = 0;
		gbc_btn7.gridy = 5;
		contentPane.add(btn7, gbc_btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbCambio1.getText().equals("0"))
					cantidad="8";
				else
				cantidad+="8";
				lbCambio1.setText(cantidad);
				obtenerDinero();
				
			}
		});
		btn8.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btn8 = new GridBagConstraints();
		gbc_btn8.weighty = 0.5;
		gbc_btn8.weightx = 0.5;
		gbc_btn8.fill = GridBagConstraints.BOTH;
		gbc_btn8.insets = new Insets(0, 0, 5, 5);
		gbc_btn8.gridx = 1;
		gbc_btn8.gridy = 5;
		contentPane.add(btn8, gbc_btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbCambio1.getText().equals("0"))
					cantidad="9";
				else
				cantidad+="9";
				lbCambio1.setText(cantidad);
				obtenerDinero();
			}
		});
		btn9.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btn9 = new GridBagConstraints();
		gbc_btn9.weighty = 0.5;
		gbc_btn9.weightx = 0.5;
		gbc_btn9.fill = GridBagConstraints.BOTH;
		gbc_btn9.insets = new Insets(0, 0, 5, 5);
		gbc_btn9.gridx = 2;
		gbc_btn9.gridy = 5;
		contentPane.add(btn9, gbc_btn9);
		
		JButton btn4 = new JButton("4");
		btn4.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbCambio1.getText().equals("0"))
					cantidad="4";
				else
				cantidad+="4";
				lbCambio1.setText(cantidad);
				obtenerDinero();
			}
		});
		btn4.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btn4 = new GridBagConstraints();
		gbc_btn4.weighty = 0.5;
		gbc_btn4.weightx = 0.5;
		gbc_btn4.fill = GridBagConstraints.BOTH;
		gbc_btn4.insets = new Insets(0, 0, 5, 5);
		gbc_btn4.gridx = 0;
		gbc_btn4.gridy = 6;
		contentPane.add(btn4, gbc_btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbCambio1.getText().equals("0"))
					cantidad="5";
				else
				cantidad+="5";
				lbCambio1.setText(cantidad);
				obtenerDinero();
			}
		});
		btn5.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btn5 = new GridBagConstraints();
		gbc_btn5.weighty = 0.5;
		gbc_btn5.weightx = 0.5;
		gbc_btn5.fill = GridBagConstraints.BOTH;
		gbc_btn5.insets = new Insets(0, 0, 5, 5);
		gbc_btn5.gridx = 1;
		gbc_btn5.gridy = 6;
		contentPane.add(btn5, gbc_btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbCambio1.getText().equals("0"))
					cantidad="6";
				else
				cantidad+="6";
				lbCambio1.setText(cantidad);
				obtenerDinero();
			}
		});
		btn6.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btn6 = new GridBagConstraints();
		gbc_btn6.weighty = 0.5;
		gbc_btn6.weightx = 0.5;
		gbc_btn6.fill = GridBagConstraints.BOTH;
		gbc_btn6.insets = new Insets(0, 0, 5, 5);
		gbc_btn6.gridx = 2;
		gbc_btn6.gridy = 6;
		contentPane.add(btn6, gbc_btn6);

		JButton btn1 = new JButton("1");
		btn1.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbCambio1.getText().equals("0"))
					cantidad="1";
				else
				cantidad+="1";
				lbCambio1.setText(cantidad);
				obtenerDinero();
			}
		});
		btn1.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btn1 = new GridBagConstraints();
		gbc_btn1.fill = GridBagConstraints.BOTH;
		gbc_btn1.weighty = 0.5;
		gbc_btn1.weightx = 0.5;
		gbc_btn1.insets = new Insets(0, 0, 5, 5);
		gbc_btn1.gridx = 0;
		gbc_btn1.gridy = 7;
		contentPane.add(btn1, gbc_btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setAlignmentX(Component.CENTER_ALIGNMENT);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbCambio1.getText().equals("0"))
					cantidad="2";
				else
				cantidad+="2";
				lbCambio1.setText(cantidad);
				obtenerDinero();
			}
		});
		btn2.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btn2 = new GridBagConstraints();
		gbc_btn2.weighty = 0.5;
		gbc_btn2.weightx = 0.5;
		gbc_btn2.fill = GridBagConstraints.BOTH;
		gbc_btn2.insets = new Insets(0, 0, 5, 5);
		gbc_btn2.gridx = 1;
		gbc_btn2.gridy = 7;
		contentPane.add(btn2, gbc_btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setAlignmentX(0.5f);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbCambio1.getText().equals("0"))
					cantidad="3";
				else
				cantidad+="3";
				lbCambio1.setText(cantidad);
				obtenerDinero();
			}
		});
		btn3.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btn3 = new GridBagConstraints();
		gbc_btn3.weighty = 0.5;
		gbc_btn3.weightx = 0.5;
		gbc_btn3.fill = GridBagConstraints.BOTH;
		gbc_btn3.insets = new Insets(0, 0, 5, 5);
		gbc_btn3.gridx = 2;
		gbc_btn3.gridy = 7;
		contentPane.add(btn3, gbc_btn3);

		JButton btn0 = new JButton("0");
		btn0.setAlignmentX(0.5f);
		btn0.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if(lbCambio1.getText().equals("0"))
					cantidad="0";
				else{
		            cantidad += "0";
		        }
		        lbCambio1.setText(cantidad);
		        obtenerDinero();
		    }
		});
		btn0.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btn0 = new GridBagConstraints();
		gbc_btn0.fill = GridBagConstraints.BOTH;
		gbc_btn0.weightx = 0.5;
		gbc_btn0.weighty = 0.5;
		gbc_btn0.insets = new Insets(0, 0, 0, 5);
		gbc_btn0.gridx = 1;
		gbc_btn0.gridy = 8;
		contentPane.add(btn0, gbc_btn0);
		
		JButton btnPunto = new JButton(".");
		btnPunto.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnPunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(punto) {
					
					if(cantidad.isEmpty())
						cantidad="0.";
					else
						cantidad+=".";
					lbCambio1.setText(cantidad);
					punto=false;
				}
			}
		});
		btnPunto.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnPunto = new GridBagConstraints();
		gbc_btnPunto.weighty = 0.5;
		gbc_btnPunto.weightx = 0.5;
		gbc_btnPunto.fill = GridBagConstraints.BOTH;
		gbc_btnPunto.insets = new Insets(0, 0, 0, 5);
		gbc_btnPunto.gridx = 2;
		gbc_btnPunto.gridy = 8;
		contentPane.add(btnPunto, gbc_btnPunto);
		
		
	}
	private void obtenerDinero() {
		cantidad= lbCambio1.getText();
		dinero=Double.parseDouble(cantidad);
		cambioDivisa();
		dinero*=cambio;
		lbCambio2.setText(String.format("%.2f", dinero));
	}
	private void cambioDivisa() {
	    if (divisa1.isEmpty() || divisa2.isEmpty()) {
	        cambio = 1.0; // Valor por defecto si no hay selección
	        return;
	    }

	    // Conversiones desde Dólar
	    if (divisa1.equals("Estados Unidos - Dólar")) {
	        if (divisa2.equals("México - Pesos Mexicanos")) cambio = 18.86;
	        else if (divisa2.equals("Europa - Euro")) cambio = 0.85;
	        else cambio = 1.0; // Misma divisa
	    }
	    // Conversiones desde Pesos Mexicanos
	    else if (divisa1.equals("México - Pesos Mexicanos")) {
	        if (divisa2.equals("Estados Unidos - Dólar")) cambio = 0.053;
	        else if (divisa2.equals("Europa - Euro")) cambio = 0.045;
	        else cambio = 1.0;
	    }
	    // Conversiones desde Euro
	    else if (divisa1.equals("Europa - Euro")) {
	        if (divisa2.equals("Estados Unidos - Dólar")) cambio = 1.17;
	        else if (divisa2.equals("México - Pesos Mexicanos")) cambio = 22.09;
	        else cambio = 1.0;
	    }
	}
	private void actualizarSimbolosYConversion() {
	    // Actualizar símbolos (tu código actual)
	    if (divisa1.equals("Estados Unidos - Dólar")) lbDivisa1.setText("$");
	    else if (divisa1.equals("Europa - Euro")) lbDivisa1.setText("€");
	    else if (divisa1.equals("México - Pesos Mexicanos")) lbDivisa1.setText("$MXN");

	    if (divisa2.equals("Estados Unidos - Dólar")) lbDivisa2.setText("$");
	    else if (divisa2.equals("Europa - Euro")) lbDivisa2.setText("€");
	    else if (divisa2.equals("México - Pesos Mexicanos")) lbDivisa2.setText("$MXN");

	    // Forzar la reconversión si ya hay cantidad ingresada
	    if (!cantidad.isEmpty()) {
	        obtenerDinero();
	    }
	}

}
