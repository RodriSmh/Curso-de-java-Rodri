package gui.ejerciciosGUI.Ejercicio08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JButton;

public class VentanaCalculadora extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String cadenaNumeros="";
	private JLabel lbNumeros;
	private double numero1;
	private JLabel lblMuestra;
	private String operacion="null";
	private double resultado;
	private boolean activado=true,punto=true;
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
					VentanaCalculadora frameCalculadora = new VentanaCalculadora();
					frameCalculadora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaCalculadora() {
		setTitle("Calculadora");
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
		mntmCalculadora.setIcon(new ImageIcon(VentanaCalculadora.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/Calculadora.png")));
		mnUsos.add(mntmCalculadora);
		
		JMenuItem mntmDivisas = new JMenuItem("Cambio de divisias");
		mntmDivisas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Divisas v=new Divisas();
				v.setVisible(true);
				dispose();
			}
		});
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
		contentPane.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {30, 30, 30, 30};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblMuestra = new JLabel("");
		lblMuestra.setHorizontalTextPosition(SwingConstants.CENTER);
		lblMuestra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMuestra.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_lblMuestra = new GridBagConstraints();
		gbc_lblMuestra.weighty = 0.5;
		gbc_lblMuestra.weightx = 0.5;
		gbc_lblMuestra.insets = new Insets(0, 0, 5, 10);
		gbc_lblMuestra.fill = GridBagConstraints.BOTH;
		gbc_lblMuestra.gridwidth = 4;
		gbc_lblMuestra.gridx = 0;
		gbc_lblMuestra.gridy = 0;
		contentPane.add(lblMuestra, gbc_lblMuestra);
		
		lbNumeros = new JLabel("0");
		lbNumeros.setFont(new Font("Arial", Font.PLAIN, 36));
		GridBagConstraints gbc_lbNumeros = new GridBagConstraints();
		gbc_lbNumeros.insets = new Insets(0, 0, 5, 0);
		gbc_lbNumeros.weighty = 0.5;
		gbc_lbNumeros.weightx = 0.5;
		gbc_lbNumeros.fill = GridBagConstraints.BOTH;
		gbc_lbNumeros.gridwidth = 4;
		gbc_lbNumeros.gridx = 0;
		gbc_lbNumeros.gridy = 1;
		contentPane.add(lbNumeros, gbc_lbNumeros);
		
		JButton btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMuestra.setText("");
				lbNumeros.setText("0");
				cadenaNumeros="";
				numero1=0;
				operacion="null";
				punto=true;
			}
		});
		btnClear.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnClear = new GridBagConstraints();
		gbc_btnClear.weighty = 0.5;
		gbc_btnClear.weightx = 0.5;
		gbc_btnClear.fill = GridBagConstraints.BOTH;
		gbc_btnClear.insets = new Insets(0, 0, 5, 5);
		gbc_btnClear.gridx = 0;
		gbc_btnClear.gridy = 2;
		contentPane.add(btnClear, gbc_btnClear);
		
		JButton btnRaizCuadrada = new JButton("");
		btnRaizCuadrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					lblMuestra.setText(cadenaNumeros+" √ ");
//					numero1=Double.parseDouble(cadenaNumeros);
					cadenaNumeros="";
					operacion="Raiz";
					punto=true;
				
			}
		});
		btnRaizCuadrada.setIcon(new ImageIcon(VentanaCalculadora.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/raizCuadrada.png")));
		GridBagConstraints gbc_btnRaizCuadrada = new GridBagConstraints();
		gbc_btnRaizCuadrada.weighty = 0.5;
		gbc_btnRaizCuadrada.weightx = 0.5;
		gbc_btnRaizCuadrada.fill = GridBagConstraints.BOTH;
		gbc_btnRaizCuadrada.insets = new Insets(0, 0, 5, 5);
		gbc_btnRaizCuadrada.gridx = 1;
		gbc_btnRaizCuadrada.gridy = 2;
		contentPane.add(btnRaizCuadrada, gbc_btnRaizCuadrada);
		
		JButton btnDividir = new JButton("");
		btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbNumeros.getText()=="0")
					cadenaNumeros="0";	
				if(activado==true) {
					numero1=Double.parseDouble(cadenaNumeros);
					lblMuestra.setText(cadenaNumeros+" / ");
					cadenaNumeros="";
					operacion="Dividir";
					activado = false;
					punto=true;
				}
			}
		});
		btnDividir.setIcon(new ImageIcon(VentanaCalculadora.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/dividir.png")));
		GridBagConstraints gbc_btnDividir = new GridBagConstraints();
		gbc_btnDividir.weighty = 0.5;
		gbc_btnDividir.weightx = 0.5;
		gbc_btnDividir.fill = GridBagConstraints.BOTH;
		gbc_btnDividir.insets = new Insets(0, 0, 5, 5);
		gbc_btnDividir.gridx = 2;
		gbc_btnDividir.gridy = 2;
		contentPane.add(btnDividir, gbc_btnDividir);
		
		JButton btnBorrar = new JButton("");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tamaño=cadenaNumeros.length();
				if(tamaño>0) {
					if(tamaño==1)
						cadenaNumeros="0";
					else
					cadenaNumeros=cadenaNumeros.substring(0, tamaño-1);
					lbNumeros.setText(cadenaNumeros);
				}
			}
		});
		btnBorrar.setIcon(new ImageIcon(VentanaCalculadora.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/delete (1).png")));
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.insets = new Insets(0, 0, 5, 0);
		gbc_btnBorrar.weighty = 0.5;
		gbc_btnBorrar.weightx = 0.5;
		gbc_btnBorrar.fill = GridBagConstraints.BOTH;
		gbc_btnBorrar.gridx = 3;
		gbc_btnBorrar.gridy = 2;
		contentPane.add(btnBorrar, gbc_btnBorrar);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbNumeros.getText()=="0")
					cadenaNumeros="7";	
				else
					cadenaNumeros+="7";
				lbNumeros.setText(cadenaNumeros);
				activado=true;
			}
		});
		btn7.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btn7 = new GridBagConstraints();
		gbc_btn7.weighty = 0.5;
		gbc_btn7.weightx = 0.5;
		gbc_btn7.fill = GridBagConstraints.BOTH;
		gbc_btn7.insets = new Insets(0, 0, 5, 5);
		gbc_btn7.gridx = 0;
		gbc_btn7.gridy = 3;
		contentPane.add(btn7, gbc_btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbNumeros.getText()=="0")
					cadenaNumeros="8";	
				else
					cadenaNumeros="8";
				lbNumeros.setText(cadenaNumeros);
				activado=true;
				
			}
		});
		btn8.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btn8 = new GridBagConstraints();
		gbc_btn8.weighty = 0.5;
		gbc_btn8.weightx = 0.5;
		gbc_btn8.fill = GridBagConstraints.BOTH;
		gbc_btn8.insets = new Insets(0, 0, 5, 5);
		gbc_btn8.gridx = 1;
		gbc_btn8.gridy = 3;
		contentPane.add(btn8, gbc_btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbNumeros.getText()=="0")
					cadenaNumeros="9";	
				else
					cadenaNumeros+="9";
				lbNumeros.setText(cadenaNumeros);
				activado=true;
			}
		});
		btn9.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btn9 = new GridBagConstraints();
		gbc_btn9.weighty = 0.5;
		gbc_btn9.weightx = 0.5;
		gbc_btn9.fill = GridBagConstraints.BOTH;
		gbc_btn9.insets = new Insets(0, 0, 5, 5);
		gbc_btn9.gridx = 2;
		gbc_btn9.gridy = 3;
		contentPane.add(btn9, gbc_btn9);
		
		JButton btnMultiplicacion = new JButton("X");
		btnMultiplicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbNumeros.getText()=="0")
					cadenaNumeros="0";	
				if(activado==true) {
					numero1=Double.parseDouble(cadenaNumeros);
					lblMuestra.setText(cadenaNumeros+" x ");
					cadenaNumeros="";
					operacion="Multiplicar";
					activado = false;
					punto=true;
				}
			}
		});
		btnMultiplicacion.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnMultiplicacion = new GridBagConstraints();
		gbc_btnMultiplicacion.insets = new Insets(0, 0, 5, 0);
		gbc_btnMultiplicacion.fill = GridBagConstraints.BOTH;
		gbc_btnMultiplicacion.weighty = 0.5;
		gbc_btnMultiplicacion.weightx = 0.5;
		gbc_btnMultiplicacion.gridx = 3;
		gbc_btnMultiplicacion.gridy = 3;
		contentPane.add(btnMultiplicacion, gbc_btnMultiplicacion);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbNumeros.getText()=="0")
					cadenaNumeros="4";	
				else
				cadenaNumeros+="4";
				lbNumeros.setText(cadenaNumeros);
				activado=true;
			}
		});
		btn4.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btn4 = new GridBagConstraints();
		gbc_btn4.weighty = 0.5;
		gbc_btn4.weightx = 0.5;
		gbc_btn4.fill = GridBagConstraints.BOTH;
		gbc_btn4.insets = new Insets(0, 0, 5, 5);
		gbc_btn4.gridx = 0;
		gbc_btn4.gridy = 4;
		contentPane.add(btn4, gbc_btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbNumeros.getText()=="0")
					cadenaNumeros="5";	
				else
				cadenaNumeros+="5";
				lbNumeros.setText(cadenaNumeros);
				activado=true;
			}
		});
		btn5.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btn5 = new GridBagConstraints();
		gbc_btn5.weighty = 0.5;
		gbc_btn5.weightx = 0.5;
		gbc_btn5.fill = GridBagConstraints.BOTH;
		gbc_btn5.insets = new Insets(0, 0, 5, 5);
		gbc_btn5.gridx = 1;
		gbc_btn5.gridy = 4;
		contentPane.add(btn5, gbc_btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbNumeros.getText()=="0")
					cadenaNumeros="6";	
				else
				cadenaNumeros+="6";
				lbNumeros.setText(cadenaNumeros);
				activado=true;
			}
		});
		btn6.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btn6 = new GridBagConstraints();
		gbc_btn6.weighty = 0.5;
		gbc_btn6.weightx = 0.5;
		gbc_btn6.fill = GridBagConstraints.BOTH;
		gbc_btn6.insets = new Insets(0, 0, 5, 5);
		gbc_btn6.gridx = 2;
		gbc_btn6.gridy = 4;
		contentPane.add(btn6, gbc_btn6);
		
		JButton btnMenos = new JButton("-");
		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbNumeros.getText()=="0")
					cadenaNumeros="0";	
				if(activado==true) {
					numero1=Double.parseDouble(cadenaNumeros);
					lblMuestra.setText(cadenaNumeros+" - ");
					cadenaNumeros="";
					operacion="Restar";
					activado = false;
					punto=true;
				}
			}
		});
		btnMenos.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnMenos = new GridBagConstraints();
		gbc_btnMenos.fill = GridBagConstraints.BOTH;
		gbc_btnMenos.weighty = 0.5;
		gbc_btnMenos.weightx = 0.5;
		gbc_btnMenos.insets = new Insets(0, 0, 5, 0);
		gbc_btnMenos.gridx = 3;
		gbc_btnMenos.gridy = 4;
		contentPane.add(btnMenos, gbc_btnMenos);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbNumeros.getText()=="0")
					cadenaNumeros="1";	
				else
					cadenaNumeros+="1";
				lbNumeros.setText(cadenaNumeros);
				activado=true;
			}
		});
		btn1.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btn1 = new GridBagConstraints();
		gbc_btn1.fill = GridBagConstraints.BOTH;
		gbc_btn1.weighty = 0.5;
		gbc_btn1.weightx = 0.5;
		gbc_btn1.insets = new Insets(0, 0, 5, 5);
		gbc_btn1.gridx = 0;
		gbc_btn1.gridy = 5;
		contentPane.add(btn1, gbc_btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbNumeros.getText()=="0")
					cadenaNumeros="2";	
				else
					cadenaNumeros+="2";
				lbNumeros.setText(cadenaNumeros);
				activado=true;
			}
		});
		btn2.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btn2 = new GridBagConstraints();
		gbc_btn2.weighty = 0.5;
		gbc_btn2.weightx = 0.5;
		gbc_btn2.fill = GridBagConstraints.BOTH;
		gbc_btn2.insets = new Insets(0, 0, 5, 5);
		gbc_btn2.gridx = 1;
		gbc_btn2.gridy = 5;
		contentPane.add(btn2, gbc_btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbNumeros.getText()=="0")
					cadenaNumeros="3";	
				else
					cadenaNumeros+="3";
				lbNumeros.setText(cadenaNumeros);
				activado=true;
			}
		});
		btn3.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btn3 = new GridBagConstraints();
		gbc_btn3.weighty = 0.5;
		gbc_btn3.weightx = 0.5;
		gbc_btn3.fill = GridBagConstraints.BOTH;
		gbc_btn3.insets = new Insets(0, 0, 5, 5);
		gbc_btn3.gridx = 2;
		gbc_btn3.gridy = 5;
		contentPane.add(btn3, gbc_btn3);
		
		JButton btnMas = new JButton("+");
		btnMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbNumeros.getText()=="0")
					cadenaNumeros="0";	
				if(activado==true) {
					numero1=Double.parseDouble(cadenaNumeros);
					lblMuestra.setText(cadenaNumeros+" + ");
					cadenaNumeros="";
					operacion="Sumar";
					activado = false;
					punto=true;
				}
			}
		});
		btnMas.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnMas = new GridBagConstraints();
		gbc_btnMas.insets = new Insets(0, 0, 5, 0);
		gbc_btnMas.fill = GridBagConstraints.BOTH;
		gbc_btnMas.gridx = 3;
		gbc_btnMas.gridy = 5;
		contentPane.add(btnMas, gbc_btnMas);
		
		JButton btnMasMenos = new JButton("");
		btnMasMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Double.parseDouble(lbNumeros.getText())!=0 ) {
					if(cadenaNumeros.charAt(0)!='-') {
						cadenaNumeros= "-"+cadenaNumeros;
					}else
						cadenaNumeros= cadenaNumeros.substring(1,cadenaNumeros.length());
					lbNumeros.setText(cadenaNumeros);
					
				}
			}
		});
		btnMasMenos.setIcon(new ImageIcon(VentanaCalculadora.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/masmenos.png")));
		GridBagConstraints gbc_btnMasMenos = new GridBagConstraints();
		gbc_btnMasMenos.weighty = 0.5;
		gbc_btnMasMenos.weightx = 0.5;
		gbc_btnMasMenos.fill = GridBagConstraints.BOTH;
		gbc_btnMasMenos.insets = new Insets(0, 0, 0, 5);
		gbc_btnMasMenos.gridx = 0;
		gbc_btnMasMenos.gridy = 6;
		contentPane.add(btnMasMenos, gbc_btnMasMenos);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cadenaNumeros!="") {
					if(lbNumeros.getText()=="0")
						cadenaNumeros="0";	
					else
					cadenaNumeros+="0";
					lbNumeros.setText(cadenaNumeros);	
					activado=true;
				}
			}
		});
		btn0.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btn0 = new GridBagConstraints();
		gbc_btn0.fill = GridBagConstraints.BOTH;
		gbc_btn0.weightx = 0.5;
		gbc_btn0.weighty = 0.5;
		gbc_btn0.insets = new Insets(0, 0, 0, 5);
		gbc_btn0.gridx = 1;
		gbc_btn0.gridy = 6;
		contentPane.add(btn0, gbc_btn0);
		
		JButton btnPunto = new JButton(".");
		btnPunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(punto) {
					if(cadenaNumeros=="") {
						cadenaNumeros+="0.";
						lbNumeros.setText(cadenaNumeros);	
						activado=true;
					}else {
						cadenaNumeros+=".";
						lbNumeros.setText(cadenaNumeros);	
						activado=true;
					}
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
		gbc_btnPunto.gridy = 6;
		contentPane.add(btnPunto, gbc_btnPunto);
		
		JButton btnIgual = new JButton("=");
		btnIgual.addActionListener(new ActionListener() {
			double numero2;
			
			public void actionPerformed(ActionEvent e) {
				if(Double.parseDouble(lbNumeros.getText())==0)
					cadenaNumeros="0";	
				if(operacion.equals("null")) {
					lblMuestra.setText(cadenaNumeros);
				}else if(operacion.equals("Sumar")) {
					numero2=Double.parseDouble(cadenaNumeros);
					resultado=numero1+numero2;
					lbNumeros.setText(String.format("%.2f", resultado));
					cadenaNumeros=String.valueOf(resultado);
					operacion="null";
				}else if(operacion.equals("Restar")) {
					numero2=Double.parseDouble(cadenaNumeros);
					resultado=numero1-numero2;
					lbNumeros.setText(String.format("%.2f", resultado));
					cadenaNumeros=String.valueOf(resultado);
					operacion="null";
				}else if(operacion.equals("Multiplicar")) {
					numero2=Double.parseDouble(cadenaNumeros);
					resultado=numero1*numero2;
					lbNumeros.setText(String.format("%.2f", resultado));
					cadenaNumeros=String.valueOf(resultado);
					operacion="null";
				}else if(operacion.equals("Dividir")) {
					numero2=Double.parseDouble(cadenaNumeros);
					resultado=numero1/numero2;
					lbNumeros.setText(String.format("%.2f", resultado));
					cadenaNumeros=String.valueOf(resultado);
					operacion="null";
				}else if(operacion.equals("Raiz")) {
					numero1=Double.parseDouble(cadenaNumeros);
//					resultado=numero1+numero2;
					resultado=Math.sqrt(numero1);
					lbNumeros.setText(String.format("%.2f", resultado));
					cadenaNumeros=String.valueOf(resultado);
					operacion="null";
				}
				lblMuestra.setText("");
				activado=true;
				
				
			}
		});
		btnIgual.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_btnIgual = new GridBagConstraints();
		gbc_btnIgual.weighty = 0.5;
		gbc_btnIgual.weightx = 0.5;
		gbc_btnIgual.fill = GridBagConstraints.BOTH;
		gbc_btnIgual.gridx = 3;
		gbc_btnIgual.gridy = 6;
		contentPane.add(btnIgual, gbc_btnIgual);
	}

}
