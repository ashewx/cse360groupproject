package cse360groupproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

public class FileSummary {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void NewFileSummary() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileSummary window = new FileSummary();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FileSummary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 574, 467);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		panel.add(splitPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		panel_1.setLayout(new MigLayout("", "[]", "[][][][][][][]"));
		
		JLabel lblAverageNumberOf = new JLabel("Average number of lines:");
		panel_1.add(lblAverageNumberOf, "cell 0 1");
		
		JLabel lblAverageNumberOf_1 = new JLabel("Average number of blank lines:");
		panel_1.add(lblAverageNumberOf_1, "cell 0 2");
		
		JLabel lblAverageNumberOf_2 = new JLabel("Average number of spaces:");
		panel_1.add(lblAverageNumberOf_2, "cell 0 3");
		
		JLabel lblAverageCharactersPer = new JLabel("Average characters per line:");
		panel_1.add(lblAverageCharactersPer, "cell 0 4");
		
		JLabel lblAverageWordLength = new JLabel("Average word length:");
		panel_1.add(lblAverageWordLength, "cell 0 5");
		
		JLabel lblMostCommonWords = new JLabel("Most common words:");
		panel_1.add(lblMostCommonWords, "cell 0 6");
		
		JPanel panel_2 = new JPanel();
		splitPane.setRightComponent(panel_2);
	}

}
