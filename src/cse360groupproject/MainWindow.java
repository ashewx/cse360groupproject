package cse360groupproject;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class MainWindow {

	private JFrame frmTextAnalyzer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmTextAnalyzer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTextAnalyzer = new JFrame();
		frmTextAnalyzer.setTitle("Text Analyzer");
		frmTextAnalyzer.setBounds(100, 100, 1146, 657);
		frmTextAnalyzer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTextAnalyzer.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.3);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new MigLayout("", "[][][][][]", "[][][][][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblFileLoaded = new JLabel("File Loaded:");
		panel.add(lblFileLoaded, "cell 1 0");
		
		JLabel loadedFileName = new JLabel("");
		panel.add(loadedFileName, "cell 4 0");
		
		JLabel lbNumLines = new JLabel("Number of lines:");
		panel.add(lbNumLines, "cell 1 2");
		
		JLabel numLines = new JLabel(""); // TODO Make listener to change values upon loading new values
		panel.add(numLines, "cell 4 2");
		
		JLabel lbNumberBlankLines = new JLabel("Number of blank lines:");
		panel.add(lbNumberBlankLines, "cell 1 3");
		
		JLabel numBlank = new JLabel(""); // TODO Make listener to change values upon loading new values
		panel.add(numBlank, "cell 4 3");
		
		JLabel lblNumOfSpaces = new JLabel("Number of spaces:");
		panel.add(lblNumOfSpaces, "cell 1 4");
		
		JLabel numSpaces = new JLabel(""); // TODO Make listener to change values upon loading new values
		panel.add(numSpaces, "cell 4 4");
		
		JLabel numWords = new JLabel(""); // TODO Make listener to change values upon loading new values
		panel.add(numWords, "cell 4 5");
		
		JLabel lblNewLabel = new JLabel("Average characters per line:");
		panel.add(lblNewLabel, "cell 1 6");
		
		JLabel avrgCharPerLine = new JLabel(""); // TODO Make listener to change values upon loading new values
		panel.add(avrgCharPerLine, "cell 4 6");
		
		JLabel lblAverageWordLength = new JLabel("Average Word Length:");
		panel.add(lblAverageWordLength, "cell 1 7");
		
		JLabel avrgWordLength = new JLabel(""); // TODO Make listener to change values upon loading new values
		panel.add(avrgWordLength, "cell 4 7");
		
		JLabel lblMostCommonWords = new JLabel("Most common words:");
		panel.add(lblMostCommonWords, "cell 1 8");
		
		JLabel lblNumberOfWords = new JLabel("Number of Words:");
		panel.add(lblNumberOfWords, "cell 1 5");
		
		JLabel mostCmnWords = new JLabel(""); // TODO Make listener to change values upon loading new values
		panel.add(mostCmnWords, "cell 4 8");
		
		JButton btnFileHistoryStatisics = new JButton("File History Statisics");
		btnFileHistoryStatisics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileSummary nw = new FileSummary(frmTextAnalyzer);
				nw.NewFileSummary();
				frmTextAnalyzer.setEnabled(false);
			}
		});
		panel.add(btnFileHistoryStatisics, "cell 1 21");
		frmTextAnalyzer.getContentPane().add(splitPane);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JMenuBar menuBar = new JMenuBar();
		frmTextAnalyzer.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmLoadFile = new JMenuItem("Load File");
		mntmLoadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				
				// Validate file is .txt
				int rc = chooser.showOpenDialog(null);
			    while (rc == JFileChooser.APPROVE_OPTION
			        && !chooser.getSelectedFile().getName().endsWith(".txt")) {
			      JOptionPane.showMessageDialog(null, "The file "
			          + chooser.getSelectedFile() + " is not a valid text source file.",
			          "Open Error", JOptionPane.ERROR_MESSAGE);
			      rc = chooser.showOpenDialog(null);
			    }
			    
			    // Do stuff with .txt file
			    File f = chooser.getSelectedFile();
				if(f == null || !chooser.getSelectedFile().getName().endsWith(".txt")) {
					System.out.println("No file selected!");
				} else {
					try
					{
						String filename = f.getAbsolutePath();
						FileReader reader = new FileReader(filename);
						BufferedReader br = new BufferedReader(reader);
						loadedFileName.setText(chooser.getSelectedFile().getName());
						textArea.read(br, null);
						br.close();
						textArea.requestFocus();
					}
					catch(Exception e)
					{
						JOptionPane.showMessageDialog(null, e);
					}
				}
			}
		});
		mnFile.add(mntmLoadFile);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmUserGuide = new JMenuItem("User Guide");
		mnHelp.add(mntmUserGuide);
		}
}
