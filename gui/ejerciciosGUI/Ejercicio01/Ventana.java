package gui.ejerciciosGUI.Ejercicio01;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Ventana extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel label;
	private JButton boton;
	private int c=0;
	public Ventana() {
		this.setSize(400, 400);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(300,300));
		setTitle("Ejercicio 01");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		iniciarComponentes();
	}
	private void iniciarComponentes() {
		panel();
		labels();
		boton();
	}
	private void panel() {
		panel=new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
	}
	private void labels() {
		label=new JLabel("Pulsa el boton");
		label.setFont(new Font(null, Font.PLAIN, 20));
		label.setBounds(0, 10, 400, 100);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);
	}
	private void boton() {
		boton=new JButton("Pulsa aqui");
		boton.setFont(new Font(null, Font.PLAIN, 20));
		boton.setBounds(130, 150, 130, 50);
		boton.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(boton);
	
		ActionListener click=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				c++;
				if(c==1)
					label.setText("Se ha dado un click");
				else
					label.setText(String.format("Se ha dado %d clicks", c));
			}
		};
		
		boton.addActionListener(click);
	}
	
}
