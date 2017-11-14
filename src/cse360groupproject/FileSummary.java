package cse360groupproject;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FileSummary {
	private MainWindow mWindow;
	private JFrame frame;
	private JFrame mainFrame;
	private JLabel avgNumLines;
	private JLabel avgNumBlankLn;
	private JLabel avgNumSpaces;
	private JLabel avgCharPerLn;
	private JLabel avgWordLength;
	private JTable histTable;
	private JLabel topWord1;
	private JLabel topWord2;
	private JLabel topWord3;

	/**
	 * Launch the application.
	 */
	public void NewFileSummary() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileSummary window = new FileSummary(mainFrame, mWindow);
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
	public FileSummary(JFrame frame, MainWindow window) {
		mainFrame = frame;
		this.mWindow = window;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setTitle("File History");
		frame.setBounds(100, 100, 798, 475);
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
		panel_1.setLayout(new MigLayout("", "[][][][]", "[][][][][][][][][][]"));
		
		JLabel lblAverageNumberOf = new JLabel("Average number of lines:");
		panel_1.add(lblAverageNumberOf, "cell 0 1");
		
		avgNumLines = new JLabel(""); //TODO Add values from calculations
		panel_1.add(avgNumLines, "cell 2 1");
		
		JLabel lblAverageNumberOf_1 = new JLabel("Average number of blank lines:");
		panel_1.add(lblAverageNumberOf_1, "cell 0 2");
		
		avgNumBlankLn = new JLabel(""); //TODO Add values from calculations
		panel_1.add(avgNumBlankLn, "cell 2 2");
		
		JLabel lblAverageNumberOf_2 = new JLabel("Average number of spaces:");
		panel_1.add(lblAverageNumberOf_2, "cell 0 3");
		
		avgNumSpaces = new JLabel(""); //TODO Add values from calculations
		panel_1.add(avgNumSpaces, "cell 2 3");
		
		JLabel lblAverageCharactersPer = new JLabel("Average characters per line:");
		panel_1.add(lblAverageCharactersPer, "cell 0 4");
		
		avgCharPerLn = new JLabel(""); //TODO Add values from calculations
		panel_1.add(avgCharPerLn, "cell 2 4");
		
		JLabel lblAverageWordLength = new JLabel("Average word length:");
		panel_1.add(lblAverageWordLength, "cell 0 5");
		
		avgWordLength = new JLabel(""); //TODO Add values from calculations
		panel_1.add(avgWordLength, "cell 2 5");
		
		JLabel lblMostCommonWords = new JLabel("Most common words:");
		panel_1.add(lblMostCommonWords, "cell 0 6");
		
		JLabel topLb1 = new JLabel("1)");
		panel_1.add(topLb1, "cell 1 6");
		
		topWord1 = new JLabel("");
		panel_1.add(topWord1, "cell 2 6");
		
		JLabel topLb2 = new JLabel("2)");
		panel_1.add(topLb2, "cell 1 7");
		
		topWord2 = new JLabel("");
		panel_1.add(topWord2, "cell 2 7");
		
		JLabel topLb3 = new JLabel("3)");
		panel_1.add(topLb3, "cell 1 8");
		
		topWord3 = new JLabel("");
		panel_1.add(topWord3, "cell 2 8");
		
		JButton btnLoadFile = new JButton("Load File");
		
		panel_1.add(btnLoadFile, "cell 0 9");
		
		btnLoadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int select = histTable.getSelectedRow(); // Get selected file by index
				if(select >= 0) {
					mWindow.refresh(mWindow.getFileHistory().get(select)); // Refresh text area of MainWindow
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); // Close window
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		
		//headers for the table
        String[] columns = new String[] {
            "File Name", "Date Loaded"
        };
 
        //initialize table model with data
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            public boolean isCellEditable(int row, int column)
            {
              return false; //This causes all cells to be not editable
            }
        };
        
        // Add file list to table model
        for(int i = 0; i < mWindow.getFileHistory().size(); i++) {
        	String name = mWindow.getFileHistory().get(i).getName();
        	String date = mWindow.getFileHistory().get(i).getDate();
        	
        	Object[] data = {name, date};
        	
        	model.addRow(data);
        }
		
		histTable = new JTable(model);
		histTable.setFillsViewportHeight(true);
		histTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		histTable.setCellSelectionEnabled(false);
		histTable.setRowSelectionAllowed(true);
		scrollPane.setViewportView(histTable);

		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				mainFrame.setEnabled(true);
			}
		});
		
		refresh();
	}
	
	// Refreshes the whole window when loading a new TextFile
		public void refresh() {
			avgNumLines.setText("TODO");
			avgNumBlankLn.setText("TODO");
			avgNumSpaces.setText("TODO");
			avgCharPerLn.setText("TODO");
			avgWordLength.setText("TODO");
			
			// TODO: Get the top 3 words
			topWord1.setText("TODO");
			topWord2.setText("TODO");
			topWord3.setText("TODO");
		}

}
