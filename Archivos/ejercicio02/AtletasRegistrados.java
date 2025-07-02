package Archivos.ejercicio02;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AtletasRegistrados extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTable table;
    private DefaultTableModel modeloTabla = new DefaultTableModel();

    public static void main(String[] args) {
        try {
            AtletasRegistrados dialog = new AtletasRegistrados(null, true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarModeloTabla() {
        // Limpiar modelo si ya tenía datos
        modeloTabla.setRowCount(0);
        
        // Configurar columnas
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Edad");
        modeloTabla.addColumn("Peso (kg)");
        modeloTabla.addColumn("Estatura (cm)");
        
        // Cargar datos
        leerBinario();
    }

    private void leerBinario() {
        try (FileInputStream archivo = new FileInputStream("CursoDJava/Archivos/ejercicio02/RegistroAtletas.bin");
             ObjectInputStream lectura = new ObjectInputStream(archivo)) {
            
            while (true) {
                try {
                    Atleta atleta = (Atleta) lectura.readObject();
                    modeloTabla.addRow(new Object[]{
                        atleta.getNombre(),
                        atleta.getEdad(),
                        atleta.getPeso(),
                        atleta.getEstatura()
                    });
                } catch (EOFException e) {
                    // Fin normal del archivo
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, 
                "Archivo no encontrado: CursoDJava/Archivos/ejercicio02/RegistroAtletas.bin", 
                "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, 
                "Error de lectura: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, 
                "Clase Atleta no encontrada", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public AtletasRegistrados(Frame owner, boolean modal) {
        super(owner, modal);
        setTitle("Registro de Atletas");
        setBackground(SystemColor.activeCaption);
        getContentPane().setBackground(SystemColor.activeCaption);
        setBounds(100, 100, 600, 400); // Tamaño aumentado para mejor visualización
        getContentPane().setLayout(new BorderLayout());
        
        // Configurar panel principal
        contentPanel.setBackground(SystemColor.activeCaption);
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        
        // Configurar layout
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[]{0, 0};
        gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
        gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        contentPanel.setLayout(gbl_contentPanel);
        
        // Título
        JLabel lblNewLabel = new JLabel("Mostrando los atletas registrados");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 15, 0);
        gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        contentPanel.add(lblNewLabel, gbc_lblNewLabel);
        
        // Configurar tabla y scroll pane
        cargarModeloTabla();
        table = new JTable(modeloTabla);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setRowHeight(25); // Altura de fila aumentada para mejor legibilidad
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.insets = new Insets(0, 0, 0, 0);
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 1;
        contentPanel.add(scrollPane, gbc_scrollPane);
        
        // Panel de botones
        JPanel buttonPane = new JPanel();
        buttonPane.setBackground(SystemColor.activeCaption);
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        
        JButton okButton = new JButton("Regresar");
        okButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        okButton.setFont(new Font("Arial", Font.PLAIN, 16));
        buttonPane.add(okButton);
        getRootPane().setDefaultButton(okButton);
    }
}
