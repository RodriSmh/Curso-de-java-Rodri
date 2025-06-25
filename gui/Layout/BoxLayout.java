package gui.Layout;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class BoxLayout extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoxLayout frame = new BoxLayout();
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
	public BoxLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 167);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(new javax.swing.BoxLayout(contentPane, javax.swing.BoxLayout.Y_AXIS));
		
		JPanel panel1 = new JPanel();
		contentPane.add(panel1);
		panel1.setLayout(new javax.swing.BoxLayout(panel1, javax.swing.BoxLayout.X_AXIS));
		
		JButton btnNewButton = new JButton("New button");
		panel1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel1.add(btnNewButton_2);
		
		JPanel panel2 = new JPanel();
		contentPane.add(panel2);
		panel2.setLayout(new javax.swing.BoxLayout(panel2, javax.swing.BoxLayout.Y_AXIS));
		
		JButton btnNewButton_3 = new JButton("New button");
		panel2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel2.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		panel2.add(btnNewButton_5);
	}

}
