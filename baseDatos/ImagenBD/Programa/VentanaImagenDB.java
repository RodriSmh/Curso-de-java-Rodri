package baseDatos.ImagenBD.Programa;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import baseDatos.ImagenBD.Modelo.Conexion;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import javax.imageio.ImageIO;

public class VentanaImagenDB extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private ImagenDB imgPanel;
    private JButton btnMostrarImagen;
    private BufferedImage buffimg = null;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaImagenDB frame = new VentanaImagenDB();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VentanaImagenDB() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(10, 10, 400, 500);
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        // Panel de imagen
        imgPanel = new ImagenDB(null);
        contentPane.add(imgPanel, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        JButton btnCargarImagen = new JButton("Cargar Imagen");
        btnCargarImagen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarImagenABD();
            }
        });
        btnCargarImagen.setFont(new Font("Arial", Font.PLAIN, 14));
        panelBotones.add(btnCargarImagen);

        btnMostrarImagen = new JButton("Mostrar Imagen");
        btnMostrarImagen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarImagenDeBD();
            }
        });
        btnMostrarImagen.setFont(new Font("Arial", Font.PLAIN, 14));
        panelBotones.add(btnMostrarImagen);

        contentPane.add(panelBotones, BorderLayout.SOUTH);
    }

    private void cargarImagenABD() {
        JFileChooser escoger = new JFileChooser();
        escoger.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imágenes", "png", "jpg", "jpeg");
        escoger.setFileFilter(filtro);

        int seleccion = escoger.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivo = escoger.getSelectedFile();
            try (FileInputStream archivoEntrada = new FileInputStream(archivo);
                 Connection conexion = new Conexion().getConnection();
                 PreparedStatement ps = conexion.prepareStatement("INSERT INTO imagen (img) VALUES (?)")) {
                
                ps.setBinaryStream(1, archivoEntrada, (int) archivo.length());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Imagen insertada correctamente");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al insertar imagen: " + e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    private void mostrarImagenDeBD() {
        String idInput = JOptionPane.showInputDialog(this, "Digite el ID de la imagen:");
        if (idInput == null || idInput.trim().isEmpty()) return;
        
        try {
            int idimagen = Integer.parseInt(idInput);
            try (Connection conexion = new Conexion().getConnection();
                 PreparedStatement ps = conexion.prepareStatement("SELECT img FROM imagen WHERE idimagen = ?")) {
                
                ps.setInt(1, idimagen);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        try (InputStream imgStream = rs.getBinaryStream(1)) {
                            buffimg = ImageIO.read(imgStream);
                            if (buffimg != null) {
                                imgPanel.setImagen(buffimg);
                            } else {
                                JOptionPane.showMessageDialog(this, "No se pudo cargar la imagen", 
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No se encontró imagen con ese ID", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID debe ser un número válido", 
                "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar imagen: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}