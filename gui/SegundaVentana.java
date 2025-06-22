package gui;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class SegundaVentana extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel panel=new JPanel();
	JTextArea areaTexto;
	JTextField caja;
	JButton boton;
	boolean activado=false;
	public SegundaVentana() {
		this.setSize(550, 500);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(300,200));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("El mejor programa");
		iniciarComponentes();
		
	}
	private void iniciarComponentes() {
		colocarPaneles();
		areaTexto();
		botones();
		cajaTexto();
		
	}
	private void colocarPaneles() {
		panel=new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);	
		if(activado==true) {
			movimientoMouse();
			mouseScroll();

		}
	}
	private void cajaTexto() {
		caja=new JTextField();
		caja.setBounds(10,50,200,20);
		panel.add(caja);
		eventosKey();
	}
	private void eventosKey() {
		KeyListener kl=new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
//				areaTexto.append("keyTyped\n");
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
//				areaTexto.append("keyReleased\n");
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
//				areaTexto.append("keyPressed\n");
				if(e.getKeyChar()=='p')
					areaTexto.append("Precionaste la letra P\n");
				if(e.getKeyChar()=='\n')
					areaTexto.append("enter \n");
				if(e.getKeyChar()==' ')
					areaTexto.append("barra de espacio\n");
				
			}
		};
		caja.addKeyListener(kl);
	}
	private void mouseScroll() {
		MouseWheelListener mw=new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				if(e.getPreciseWheelRotation()==-1)
				areaTexto.append("Moviendo el scroll hacia arriba\n");
				else if(e.getPreciseWheelRotation()==1)
					areaTexto.append("Moviendo el scroll hacia abajo\n");		
			}
		};
		panel.addMouseWheelListener(mw);
	}
	private void movimientoMouse() {
		MouseMotionListener mml=new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				areaTexto.append("Mouse moved\n");
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				areaTexto.append("Mouse dragged\n");
				
			}
		};
		panel.addMouseMotionListener(mml);
	}
	private void areaTexto() {
		areaTexto=new JTextArea();
		areaTexto.setBounds(250, 20, 200, 300);
		JScrollPane barra=new JScrollPane(areaTexto,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		barra.setBounds(250, 20, 200, 300);
		panel.add(barra);
	}
	private void botones() {
		boton=new JButton("Click");
		boton.setBounds(10, 230, 100, 40);
		if(activado)
			panel.add(boton);
		mouseListener();
	}
	private void mouseListener() {
		MouseListener mL=new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
//				areaTexto.append("Released\n");
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
//				areaTexto.append("pressed\n");
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
//				areaTexto.append("exited\n");
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
//				areaTexto.append("Entered\n");
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
//				areaTexto.append("Click\n");
				if(e.isAltDown())
					areaTexto.append("alt\n");
				else if (e.isControlDown())
					areaTexto.append("control\n");
				else if (e.isShiftDown())
					areaTexto.append("shift\n");
				else if(e.isMetaDown())
					areaTexto.append("click derecho\n");
				
				if(e.getClickCount()==2)
					areaTexto.append("doble click\n");
				
			}
		};
		
		boton.addMouseListener(mL);
	}
}
