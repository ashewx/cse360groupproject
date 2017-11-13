package cse360groupproject;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Help {

	private JFrame frmHelp;
	private JFrame mainFrame;

	/**
	 * Launch the application.
	 */
	public void NewHelp() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Help window = new Help(mainFrame);
					window.frmHelp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Help(JFrame frame) {
		mainFrame = frame;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHelp = new JFrame();
		frmHelp.setTitle("Help");
		frmHelp.setAlwaysOnTop(true);
		frmHelp.setBounds(100, 100, 450, 300);
		frmHelp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frmHelp.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				mainFrame.setEnabled(true);
			}
		});
	}

}
