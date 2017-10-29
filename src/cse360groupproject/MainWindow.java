package cse360groupproject;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

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
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		splitPane.setRightComponent(textArea);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new MigLayout("", "[][][][][]", "[][][][][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lbNumLines = new JLabel("Number of lines:");
		panel.add(lbNumLines, "cell 1 2");
		
		JLabel numLines = new JLabel("null");
		panel.add(numLines, "cell 4 2");
		
		JLabel lbNumberBlankLines = new JLabel("Number of blank lines:");
		panel.add(lbNumberBlankLines, "cell 1 3");
		
		JLabel numBlank = new JLabel("null");
		panel.add(numBlank, "cell 4 3");
		
		JLabel lblNumOfSpaces = new JLabel("Number of spaces:");
		panel.add(lblNumOfSpaces, "cell 1 4");
		
		JLabel numSpaces = new JLabel("null");
		panel.add(numSpaces, "cell 4 4");
		
		JLabel numWords = new JLabel("null");
		panel.add(numWords, "cell 4 5");
		
		JLabel lblNewLabel = new JLabel("Average characters per line:");
		panel.add(lblNewLabel, "cell 1 6");
		
		JLabel avrgCharPerLine = new JLabel("null");
		panel.add(avrgCharPerLine, "cell 4 6");
		
		JLabel lblAverageWordLength = new JLabel("Average Word Length:");
		panel.add(lblAverageWordLength, "cell 1 7");
		
		JLabel avrgWordLength = new JLabel("null");
		panel.add(avrgWordLength, "cell 4 7");
		
		JLabel lblMostCommonWords = new JLabel("Most common words:");
		panel.add(lblMostCommonWords, "cell 1 8");
		
		JLabel lblNumberOfWords = new JLabel("Number of Words:");
		panel.add(lblNumberOfWords, "cell 1 5");
		
		JLabel mostCmnWords = new JLabel("null");
		panel.add(mostCmnWords, "cell 4 8");
		
		JButton btnFileHistoryStatisics = new JButton("File History Statisics");
		panel.add(btnFileHistoryStatisics, "cell 1 21");
		frmTextAnalyzer.getContentPane().add(splitPane);
		
		JMenuBar menuBar = new JMenuBar();
		frmTextAnalyzer.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmLoadFile = new JMenuItem("Load File");
		mnFile.add(mntmLoadFile);
		
		JMenuItem mntmFileHistory = new JMenuItem("File History");
		mnFile.add(mntmFileHistory);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmUserGuide = new JMenuItem("User Guide");
		mnHelp.add(mntmUserGuide);
	}
}
