package cse360groupproject;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

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

	private static MainWindow window;
	private JFrame frmTextAnalyzer;
	private JLabel loadedFileName;
	private JLabel numLines;
	private JLabel numBlank;
	private JLabel numSpaces;
	private JLabel numWords;
	private JLabel avrgCharPerLine;
	private JLabel avrgWordLength;
	private JLabel avrgNumLines;
	private JTextArea textArea;
	private JLabel topWord1;
	private JLabel topWord2;
	private JLabel topWord3;
	private ArrayList<TextFile> fileHistory = new ArrayList<TextFile>(); // Holds all files that were loaded
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new MainWindow();
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
		panel.setLayout(new MigLayout("", "[][][][][][][][]", "[][][][][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblFileLoaded = new JLabel("File Loaded:");
		panel.add(lblFileLoaded, "cell 1 0");
		
		loadedFileName = new JLabel("");
		panel.add(loadedFileName, "cell 3 0");
		
		JLabel lbNumLines = new JLabel("Number of lines:");
		panel.add(lbNumLines, "cell 1 2");
		
		numLines = new JLabel("");
		panel.add(numLines, "cell 3 2");
		
		JLabel lbNumberBlankLines = new JLabel("Number of blank lines:");
		panel.add(lbNumberBlankLines, "cell 1 3");
		
		numBlank = new JLabel("");
		panel.add(numBlank, "cell 3 3");
		
		JLabel lblNumOfSpaces = new JLabel("Number of spaces:");
		panel.add(lblNumOfSpaces, "cell 1 4");
		
		numSpaces = new JLabel("");
		panel.add(numSpaces, "cell 3 4");
		
		numWords = new JLabel("");
		panel.add(numWords, "cell 3 5");
		
		JLabel lblNewLabel = new JLabel("Average characters per line:");
		panel.add(lblNewLabel, "cell 1 6");
		
		avrgCharPerLine = new JLabel("");
		panel.add(avrgCharPerLine, "cell 3 6");
		
		JLabel lblAverageWordLength = new JLabel("Average word length:");
		panel.add(lblAverageWordLength, "cell 1 7");
		
		avrgWordLength = new JLabel("");
		panel.add(avrgWordLength, "cell 3 7");
		
		JLabel lblMostCommonWords = new JLabel("Most common words:");
		panel.add(lblMostCommonWords, "cell 1 8");
		
		JLabel lblNumberOfWords = new JLabel("Number of words:");
		panel.add(lblNumberOfWords, "cell 1 5");
		
		JLabel topLb1 = new JLabel("1)");
		panel.add(topLb1, "cell 2 8");
		
		topWord1 = new JLabel("");
		panel.add(topWord1, "cell 3 8");
		
		JLabel topLb2 = new JLabel("2)");
		panel.add(topLb2, "cell 2 9");
		
		topWord2 = new JLabel("");
		panel.add(topWord2, "cell 3 9");
		
		JLabel topLb3 = new JLabel("3)");
		panel.add(topLb3, "cell 2 10");
		
		topWord3 = new JLabel("");
		panel.add(topWord3, "cell 3 10");
		
		JButton btnFileHistoryStatisics = new JButton("File History Statisics");
		btnFileHistoryStatisics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileSummary nw = new FileSummary(frmTextAnalyzer, window);
				nw.NewFileSummary();
				frmTextAnalyzer.setEnabled(false);
			}
		});
		panel.add(btnFileHistoryStatisics, "cell 1 12");
		frmTextAnalyzer.getContentPane().add(splitPane);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		
		textArea = new JTextArea();
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
						textArea.read(br, null);
						TextFile file = new TextFile(chooser.getSelectedFile().getName(), textArea.getText());
						
						fileHistory.add(0, file); // Adds to file history at the start of list to organize for newest first
						refresh(file);
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
		mntmUserGuide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Help nw = new Help(frmTextAnalyzer);
				nw.NewHelp();
				frmTextAnalyzer.setEnabled(false);
			}
		});
		mnHelp.add(mntmUserGuide);
		}
	
	// Refreshes the whole window when loading a new TextFile
	public void refresh(TextFile file) {
		textArea.setText(file.getInput());
		loadedFileName.setText(file.getName());
		numLines.setText(Integer.toString(file.getNumLines()));
		numBlank.setText(Integer.toString(file.getBlankLn()));
		numSpaces.setText(Integer.toString(file.getNumSpaces()));
		numWords.setText(Integer.toString(file.getNumWords()));
		avrgCharPerLine.setText(Integer.toString(file.getAvgCharPerLn()));
		avrgWordLength.setText(Integer.toString(file.getAvgWrdLen()));

		textArea.setCaretPosition(0);
		
		try {
			topWord1.setText((String) file.getWordOccurrence().keySet().toArray()[0]);
		} catch (NullPointerException e) {
			topWord1.setText("");
		} catch(ArrayIndexOutOfBoundsException e) {
			topWord1.setText("");
		}
		try {
			topWord2.setText((String) file.getWordOccurrence().keySet().toArray()[1]);
		} catch (NullPointerException e) {
			topWord2.setText("");
		} catch(ArrayIndexOutOfBoundsException e) {
			topWord2.setText("");
		}
		try {
			topWord3.setText((String) file.getWordOccurrence().keySet().toArray()[2]);
		} catch (NullPointerException e) {
			topWord3.setText("");
		} catch(ArrayIndexOutOfBoundsException e) {
			topWord3.setText("");
		}
	}

	public ArrayList<TextFile> getFileHistory() {
		return fileHistory;
	}
}
