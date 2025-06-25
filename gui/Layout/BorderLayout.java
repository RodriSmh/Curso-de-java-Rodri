package gui.Layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
public class BorderLayout extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorderLayout frame = new BorderLayout();
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
	public BorderLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(new java.awt.BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		contentPane.add(panel, java.awt.BorderLayout.NORTH);
		panel.setPreferredSize(new Dimension(100,100));
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setPreferredSize(new Dimension(100,100));
		contentPane.add(panel_1, java.awt.BorderLayout.WEST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_7 = new JButton("New button");
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_6 = new JButton("New button");
		panel_1.add(btnNewButton_6);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.RED);
		panel_2.setBorder(null);
		panel_2.setPreferredSize(new Dimension(100,100));
		contentPane.add(panel_2, java.awt.BorderLayout.CENTER);
		
		JButton btnNewButton_10 = new JButton("New button");
		panel_2.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("New button");
		panel_2.add(btnNewButton_11);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel_3.setPreferredSize(new Dimension(100,100));
		contentPane.add(panel_3, java.awt.BorderLayout.SOUTH);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		panel_3.add(btnNewButton_5);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.GREEN);
		panel_4.setPreferredSize(new Dimension(100,100));
		contentPane.add(panel_4, java.awt.BorderLayout.EAST);
		
		JButton btnNewButton_8 = new JButton("New button");
		panel_4.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("New button");
		panel_4.add(btnNewButton_9);
	}

}
