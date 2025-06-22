package gui.ejerciciosGUI.Ejercicio02;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
//import javax.swing.SwingConstants;

public class SanrioVentana extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel panel;
//    private String url;
    private JRadioButton Cinna, Mel, Pom, Kur;
    private JLabel etiqueta,imagen;
//    private JLabel lCinna; // Declarar como variable de clase

    public SanrioVentana() {
        this.setSize(500, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Personajes de Sanrio");
        componentes();
    }

    private void componentes() {
        panel();
        colocaRadioBotones();
        etiqueta();
        
    }

    private void panel() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    private void etiqueta() {
    	etiqueta= new JLabel("Escoje tu personaje favorito");
    	etiqueta.setBounds(10, 10, 250, 40);
    	panel.add(etiqueta);
    }
    private void colocaRadioBotones() {
        Cinna = new JRadioButton("CinnamonRoll", false);
        Cinna.setBounds(10, 50, 150, 50);
        panel.add(Cinna);
        
        Mel = new JRadioButton("My Melody", false);
        Mel.setBounds(10, 90, 100, 50);
        panel.add(Mel);

        Pom = new JRadioButton("Pompompuri", false);
        Pom.setBounds(10, 130, 100, 50);
        panel.add(Pom);

        Kur = new JRadioButton("Kuromi", false);
        Kur.setBounds(10, 170, 100, 50);
        panel.add(Kur);
        
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(Cinna);
        grupo.add(Mel);
        grupo.add(Pom);
        grupo.add(Kur);
        
        
        eventoAccion();        
    }
    private void eventoAccion() {
    	
    	imagen=new JLabel();
    	imagen.setBounds(180,50,300,200);
    	panel.add(imagen);
    	
    	final ImageIcon imKuromi=new ImageIcon(getClass().getResource("/gui/ejerciciosGUI/Ejercicio02/imagenes/Kuromi.jpg"));
    	ActionListener evento1=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				imagen.setIcon(new ImageIcon(imKuromi.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(),Image.SCALE_SMOOTH )));
				
			}
		};
		final ImageIcon imMelody=new ImageIcon(getClass().getResource("/gui/ejerciciosGUI/Ejercicio02/imagenes/Melody.jpg"));
		ActionListener evento2=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				imagen.setIcon(new ImageIcon(imMelody.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(),Image.SCALE_SMOOTH )));
			}
		};
		final ImageIcon imPom=new ImageIcon(getClass().getResource("/gui/ejerciciosGUI/Ejercicio02/imagenes/pom.jpg"));
		ActionListener evento3=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				imagen.setIcon(new ImageIcon(imPom.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(),Image.SCALE_SMOOTH )));
			}
		};
		final ImageIcon imCinna=new ImageIcon(getClass().getResource("/gui/ejerciciosGUI/Ejercicio02/imagenes/Cinna.jpg"));
		ActionListener evento4=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				imagen.setIcon(new ImageIcon(imCinna.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(),Image.SCALE_SMOOTH )));
			}
		};
		Kur.addActionListener(evento1);
		Mel.addActionListener(evento2);
		Pom.addActionListener(evento3);
		Cinna.addActionListener(evento4);
		
    }



    
}