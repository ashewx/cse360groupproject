package cse360groupproject;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;


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
	 * @throws Exception 
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
		
		// Set up PDF controller
		SwingController controller = new SwingController(); 
		SwingViewBuilder factory = new SwingViewBuilder(controller); 
		JPanel viewerComponentPanel = factory.buildViewerPanel(); 
		controller.getDocumentViewController().setAnnotationCallback( 
				new org.icepdf.ri.common.MyAnnotationCallback( 
						controller.getDocumentViewController())); 
		
		// Add PDF controller to JFrame
		frmHelp.add(viewerComponentPanel); 
		// Find Help file in Jar executable
		URL help1 = getClass().getResource("Help.pdf");
		controller.openDocument(help1);
		frmHelp.pack(); 
		
		frmHelp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frmHelp.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				mainFrame.setEnabled(true);
			}
		});
	}

}
