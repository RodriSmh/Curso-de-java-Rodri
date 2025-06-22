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
import javax.swing.SwingConstants;

public class SanrioVentana extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private String url;
    private JRadioButton Cinna, Mel, Pom, Kur;
    private JLabel lCinna; // Declarar como variable de clase

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
        crearEtiquetaImagen(); // Crear la etiqueta de imagen aquí
    }

    private void panel() {
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
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
        
        ActionListener radioListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Mel.isSelected()) {
                    url = urlImagen('M');
                } else if (Pom.isSelected()) {
                    url = urlImagen('P');
                } else if (Kur.isSelected()) {
                    url = urlImagen('K');
                } else if (Cinna.isSelected()) {
                    url = urlImagen('C');
                }
                actualizarImagen(); // Actualizar la imagen cuando cambia la selección
            }
        };
        
        Cinna.addActionListener(radioListener);
        Mel.addActionListener(radioListener);
        Pom.addActionListener(radioListener);
        Kur.addActionListener(radioListener);
    }

    private void crearEtiquetaImagen() {
        // Crear la etiqueta con una imagen vacía inicialmente
        lCinna = new JLabel(new ImageIcon(), SwingConstants.RIGHT);
        lCinna.setBounds(180, 50, 300, 200);
        panel.add(lCinna);
    }

    private void actualizarImagen() {
        if (url != null && !url.isEmpty()) {
            // Carga la imagen usando getResource() (funciona dentro de JARs)
            ImageIcon icon = new ImageIcon(getClass().getResource(url));
            if (icon.getImage() != null) {
                Image img = icon.getImage().getScaledInstance(
                    lCinna.getWidth(), 
                    lCinna.getHeight(), 
                    Image.SCALE_SMOOTH);
                lCinna.setIcon(new ImageIcon(img));
            } else {
                System.err.println("No se pudo cargar la imagen: " + url);
            }
        }
    }

    private String urlImagen(char c) {
        switch (c) {
            case 'K':
                return "imagenes\\Kuromi.jpg";
            case 'M':
                return "imagenes\\Melody.jpg";
            case 'P':
                return "imagenes\\pom.jpg";
            case 'C':
                return "imagenes\\Cinna.jpg";
            default:
                return "";
        }
    }
}