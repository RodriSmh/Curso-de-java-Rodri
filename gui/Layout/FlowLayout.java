package gui.Layout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import java.awt.Component;

public class FlowLayout extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlowLayout frame = new FlowLayout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FlowLayout() {
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 235);
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		java.awt.FlowLayout fl_contentPane = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 5);
		contentPane.setLayout(fl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.add(panel);
		java.awt.FlowLayout fl_panel = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5);
		panel.setLayout(fl_panel);
		
		JLabel lblNewLabel = new JLabel("Digite su nombre");
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
	}
}
