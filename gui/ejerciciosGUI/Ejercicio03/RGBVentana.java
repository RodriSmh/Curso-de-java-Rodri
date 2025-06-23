package gui.ejerciciosGUI.Ejercicio03;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RGBVentana extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lEtiqueta;
	private JButton btRojo,btVerde,btAzul;
	private int pulsado=0,cRojo=0,cVerde=0,cAzul=0;
	public RGBVentana() {
		this.setSize(390,220);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Juego RGB");
		iniciarComponentes();
	}
	private void iniciarComponentes() {
		colocarPanel();
		colocarEtiqueta();
		colocarBotones();
	}
	private void colocarPanel() {
		panel=new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
		eventos();
	}
	private void colocarEtiqueta() {
		lEtiqueta=new JLabel("Color(Rojo, Verde, Azul)");
		lEtiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		lEtiqueta.setBounds(80, 30, 280, 30);
		
		lEtiqueta.setFont(new Font("Arial", 1, 15));
		panel.add(lEtiqueta);
	}
	private void colocarBotones() {
		/**
		 * pulsado = 1 boton rojo
		 * pulsado = 2 boton verde
		 * pulsado = 3 boton azul*/
		btRojo=new JButton("Rojo");
		btRojo.setBounds(20, 90, 100, 30);
		btRojo.setForeground(Color.red);
		btRojo.setFont(new Font("Arial", 1, 17));
		panel.add(btRojo);
		btVerde=new JButton("Verde");
		btVerde.setBounds(140, 90, 100, 30);
		btVerde.setForeground(Color.GREEN);
		btVerde.setFont(new Font("Arial", 1, 17));
		panel.add(btVerde);
		btAzul=new JButton("Azul");
		btAzul.setBounds(260, 90, 100, 30);
		btAzul.setForeground(Color.blue);
		btAzul.setFont(new Font("Arial", 1, 17));
		panel.add(btAzul);
		
		
ActionListener ARojo= new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				pulsado=1;
			}
		};
		ActionListener AVerde=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				pulsado=2;
			}
		};
		ActionListener AAzul=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				pulsado=3;
			}
		};
		btRojo.addActionListener(ARojo);
		btVerde.addActionListener(AVerde);
		btAzul.addActionListener(AAzul);
		
	}
	private void eventos(){
		
		
		MouseWheelListener evento=new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				if(pulsado!=0) {
					lEtiqueta.setForeground(Color.white);
					if(pulsado==1) {
						cRojo+=e.getWheelRotation();
						if(cRojo>255)
							cRojo=255;
						if(cRojo<0)
							cRojo=0;
					}else if(pulsado==2) {
						cVerde+=e.getWheelRotation();
						if(cVerde<0)
							cVerde=0;
						if(cVerde>255)
							cVerde=255;
					}else if(pulsado==3) {
						cAzul+=e.getWheelRotation();
						if(cAzul<0)
							cAzul=0;
						if(cAzul>255)
							cAzul=255;
					}
				}
				if(cRojo==255&&cVerde==255&&cAzul==255)
					lEtiqueta.setForeground(Color.black);
				lEtiqueta.setText(String.format("Color Rojo=%d Verde=%d Azul=%d",cRojo,cVerde,cAzul));
				panel.setBackground(new Color(cRojo,cVerde,cAzul));
			}
		};
		
		panel.addMouseWheelListener(evento);
	}
	
	
}
