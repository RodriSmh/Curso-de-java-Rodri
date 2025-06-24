package gui.ejerciciosGUI.Ejercicio05;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.Color;
import javax.swing.JButton;

public class VentanaCronometro extends JFrame {
	private Timer tiempo;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int centecimas=0,segundos=0,minutos=0,horas=0;
	private JLabel lbTiempo;
	private JButton btnIniciar,btnDetener,btnPausar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCronometro frame = new VentanaCronometro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private ActionListener accion=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			centecimas++;
			if(centecimas==100) {
				segundos++;
				centecimas=0;
			}
			if(segundos==60) {
				segundos=0;
				minutos++;
			}
			if(minutos==60) {
				horas++;
				minutos=0;
			}
			actualizaEtiqueta();
		}
	};
	
	
	
	private void actualizaEtiqueta() {
		String texto =
				(horas<=9?"0":"")+horas+
				(minutos<=9?":0":"")+minutos+
				(segundos<=9?":0":"")+segundos+
				(centecimas<=9?":0":":")+centecimas;
		lbTiempo.setText(texto);
	}
	/**
	 * Create the frame.
	 */
	public VentanaCronometro() {
		setResizable(false);
		setTitle("Cronometro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setLocationRelativeTo(null);
		
		
		tiempo=new Timer(10,accion);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 677, 209);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnDetener = new JButton("Detener");
		btnDetener.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tiempo.stop();
				btnIniciar.setEnabled(true);
				btnIniciar.setText("Iniciar");
				btnPausar.setEnabled(false);
				btnDetener.setEnabled(false);
				horas=0;
				minutos=0;
				segundos=0;
				centecimas=0;
				actualizaEtiqueta();
			}
		});
		btnDetener.setFont(new Font("Arial", Font.PLAIN, 18));
		btnDetener.setBounds(525, 138, 118, 23);
		panel.add(btnDetener);
		
		btnPausar = new JButton("Pausar");
		btnPausar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tiempo.stop();
				btnIniciar.setEnabled(true);
				btnPausar.setEnabled(false);
			}
		});
		btnPausar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnPausar.setBounds(356, 138, 118, 23);
		panel.add(btnPausar);
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tiempo.start();
				btnIniciar.setEnabled(false);
				btnIniciar.setText("Reanudar");
				btnPausar.setEnabled(true);
				btnDetener.setEnabled(true);
			}
		});
		
		btnIniciar.setFont(new Font("Arial", Font.PLAIN, 18));
		btnIniciar.setBounds(191, 138, 118, 23);
		panel.add(btnIniciar);
		
		lbTiempo = new JLabel("00:00:00:00");
		lbTiempo.setForeground(new Color(0, 0, 255));
		lbTiempo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
		lbTiempo.setBounds(302, 77, 262, 36);
		panel.add(lbTiempo);
		
		JLabel lbCronometroLetras = new JLabel("Cronometro");
		lbCronometroLetras.setForeground(new Color(128, 0, 0));
		lbCronometroLetras.setHorizontalAlignment(SwingConstants.CENTER);
		lbCronometroLetras.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 40));
		lbCronometroLetras.setBounds(281, 11, 271, 57);
		panel.add(lbCronometroLetras);
		
		JLabel lbImagenCronometro = new JLabel("Crono");
		lbImagenCronometro.setLabelFor(lbImagenCronometro);
		lbImagenCronometro.setIcon(new ImageIcon(VentanaCronometro.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/crono.png")));
		lbImagenCronometro.setBounds(0, 11, 150, 150);
		panel.add(lbImagenCronometro);
		
		JLabel lbImagenFondo = new JLabel("");
		lbImagenFondo.setVerticalAlignment(SwingConstants.TOP);
		lbImagenFondo.setIcon(new ImageIcon(VentanaCronometro.class.getResource("/gui/ejerciciosGUI/Ejercicio05/imagenes/race.jpg")));
		lbImagenFondo.setBounds(0, 0, 677, 193);
		panel.add(lbImagenFondo);
	}
}
