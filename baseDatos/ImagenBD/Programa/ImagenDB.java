package baseDatos.ImagenBD.Programa;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ImagenDB extends JPanel {
    private static final long serialVersionUID = 1L;
    private BufferedImage imagen;
    
    public ImagenDB(BufferedImage imagen) {
        this.imagen = imagen;
        setOpaque(false);
    }
    
    public void setImagen(BufferedImage nuevaImagen) {
        this.imagen = nuevaImagen;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(365, 365);
    }
}