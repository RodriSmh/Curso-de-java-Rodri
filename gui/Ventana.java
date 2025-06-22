package gui;
//import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Ventana extends JFrame{
	private static final long serialVersionUID = 1L;
	JPanel panel=new JPanel();
	JTextField caja;
	boolean activado=false;
	public Ventana() {
		this.setSize(500, 500);
		setLocationRelativeTo(null);
//		setLocation(500, 100);
//		setBounds(500, 100, 500, 500);
//		setResizable(false);
		setMinimumSize(new Dimension(300,200));
//		this.getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("El mejor programa");
		iniciarComponentes();
		
	}
	
	private void iniciarComponentes() {
		colocarPaneles();
		labels();
		cajaTexto();
		colocarBotones();
		if(activado==true) {
			
		etiquetas();
		colocaRadioBotones();
		colocarBotonesActivacion();
		cajaTexto();
		areaTexto();
		checkbox();
		comboBox();
		password();
		tablas();
		listas();
		}
	}
	private void colocarPaneles() {
		panel=new JPanel();
//		panel.setBackground(Color.white);
		panel.setLayout(null);
		this.getContentPane().add(panel);
		
	}
	private void labels() {
		JLabel label1=new JLabel("Ingresa un nombre: ");
		label1.setBounds(10,10,200,50);
		panel.add(label1);
	
	}
	
	
	private void listas() {
		
		DefaultListModel<Persona> modelo= new DefaultListModel<Persona>();
		
		Persona persona= new Persona("Rodrigo",28,"Mexicana");
		Persona persona1 = new Persona("Quetzalli",28,"Mexicana");
		Persona persona2 = new Persona("María",28,"Mexicana");
		Persona persona3 = new Persona("Carlos",28,"Mexicana");
		Persona persona4 = new Persona("Ana",28,"Mexicana");
		Persona persona5 = new Persona("Luis",28,"Mexicana");
		modelo.addElement(persona);
		modelo.addElement(persona1);
		modelo.addElement(persona2);
		modelo.addElement(persona3);
		modelo.addElement(persona4);
		modelo.addElement(persona5);
		

		JList<Persona> lista=new JList<Persona>(modelo);
		lista.setBounds(10, 10, 200, 300);
		panel.add(lista);
		
JScrollPane scroll=new JScrollPane(lista,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		scroll.setBounds(10, 10, 300, 100);
		panel.add(scroll);
	}
	private void tablas() {
		DefaultTableModel modelo=new DefaultTableModel();
		
		modelo.addColumn("Nombre");
		modelo.addColumn("edad");
		JTable tabla=new JTable(modelo);
		
		String [] persona= {"28","Rodrigo"};
		String[] persona1 = {"28", "Quetzalli"};
		String[] persona2 = {"30", "María"};
		String[] persona3 = {"25", "Carlos"};
		String[] persona4 = {"35", "Ana"};
		String[] persona5 = {"40", "Luis"};
		
		modelo.addRow(persona);
		modelo.addRow(persona1);
		modelo.addRow(persona2);
		modelo.addRow(persona3);
		modelo.addRow(persona4);
		modelo.addRow(persona5);
		
		
//		tabla.setBounds(10, 10, 300, 100);
//		panel.add(tabla);
		JScrollPane scroll=new JScrollPane(tabla,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		scroll.setBounds(10, 10, 300, 100);
		panel.add(scroll);
	}
	private void password() {
		JPasswordField pass=new JPasswordField();
		pass.setBounds(10, 10, 200, 20);
		panel.add(pass);
		String contraseña="";
		pass.setText("hola");
		for (char i : pass.getPassword()) {
			contraseña+=i;
		}
		System.out.println(contraseña);
	}
	private void comboBox() {
//		String []paises= {"Peru","Mexico","Argentina"};
//		JComboBox lista=new JComboBox(paises);
//		lista.setBounds(10, 10, 200, 50);
//		panel.add(lista);
		Persona persona1=new Persona("Rodrigo", 28, "Mexicano");
		DefaultComboBoxModel<Persona> modelo=new DefaultComboBoxModel<Persona>();
		modelo.addElement(persona1);
		JComboBox<Persona> lista= new JComboBox<Persona>(modelo);
		lista.setBounds(10, 10, 200, 50);
		panel.add(lista);
	}
	private void checkbox() {
		JCheckBox check=new JCheckBox("hola");
		check.setBounds(20, 20, 100, 40);
		panel.add(check);
		JCheckBox check2=new JCheckBox("hola 2");
		check2.setBounds(20, 50, 100, 40);
		panel.add(check2);
		JCheckBox check3=new JCheckBox("hola");
		check3.setBounds(20, 80, 100, 40);
		panel.add(check3);
	}
	private void areaTexto() {
		JTextArea areaTexto=new JTextArea();
		areaTexto.setBounds(10, 20, 300, 200);
		JScrollPane barra=new JScrollPane(areaTexto,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		barra.setBounds(10, 20, 300, 200);
//		barra.setVerticalScrollBarPolicy();
//		barra.setHorizontalScrollBarPolicy();
		panel.add(barra);
//		panel.add(areaTexto);
	}
	private void cajaTexto() {
		caja=new JTextField();
		caja.setBounds(10,50,200,20);
		panel.add(caja);
	}
	private void colocarBotonesActivacion() {
		JToggleButton activacion=new JToggleButton("opcion 1",true);
		activacion.setBounds(10, 20, 100, 50);
		panel.add(activacion);
		
		JToggleButton activacion2=new JToggleButton("opcion 2",true);
		activacion2.setBounds(10, 70, 100, 50);
		panel.add(activacion2);
		
		ButtonGroup grupo=new ButtonGroup();
		grupo.add(activacion);
		grupo.add(activacion2);
	}
	private void colocaRadioBotones() {
		JRadioButton radiobutton=new JRadioButton("Opcion 1",true);
		radiobutton.setBounds(10, 10, 100, 50);
		panel.add(radiobutton);
		
		JRadioButton radiobutton2=new JRadioButton("Opcion 2",false);
		radiobutton2.setBounds(10, 50, 100, 50);
		panel.add(radiobutton2);
		
		ButtonGroup grupo=new ButtonGroup();
		grupo.add(radiobutton);
		grupo.add(radiobutton2);
	}
	private void colocarBotones() {
		JButton boton=new JButton("Saludar");
		boton.setBounds(100, 100, 100, 40);
		panel.add(boton);
		
		JButton borrar=new JButton("Borrar");
		borrar.setBounds(250, 100, 100, 40);
		panel.add(borrar);
		
		final JLabel label2=new JLabel("hola");
		label2.setBounds(10,60,200,50);
		label2.setVisible(false);
		panel.add(label2);
		ActionListener accion=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				label2.setText("Hola, "+caja.getText());
				label2.setVisible(true);
				
			}
		};
		ActionListener accionBorrar=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				label2.setText("");
				caja.setText("");
				label2.setVisible(false);
				
			}
		};
		boton.addActionListener(accion);
		borrar.addActionListener(accionBorrar);
	}
	private void etiquetas() {
		
		JLabel label=new JLabel("Hola",SwingConstants.CENTER);
		String urlImagen="C:\\Users\\640 G5\\eclipse-workspace\\SistemasOperativos\\CursoDJava\\gui\\Bauhaus.svg";
		ImageIcon imagen=new ImageIcon(urlImagen);
		JLabel label2=new JLabel(imagen);
		label2.setBounds(5, 5, imagen.getIconWidth(), imagen.getIconHeight());
		label2.setBounds(5, 5, 300, 200);
		label2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(label2.getWidth(), label2.getHeight(), Image.SCALE_SMOOTH)));
		
//		label.setText("Hola como estas");
		panel.add(label);
		label.setBounds(10, 200, 200, 50);
		label.setFont(new Font(null, Font.PLAIN, 20));
		label2.setOpaque(true);
//		label2.setBackground(Color.black);
//		label.setForeground(Color.green);
		panel.add(label2);
		
	}
	
}