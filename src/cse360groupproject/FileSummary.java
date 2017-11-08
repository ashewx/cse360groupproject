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
	private JLabel mstCommonWord;
	private JTable histTable;

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
		frame.setBounds(100, 100, 767, 467);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.3);
		panel.add(splitPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		panel_1.setLayout(new MigLayout("", "[][][][]", "[][][][][][][][][]"));
		
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
		panel_1.add(avgNumSpaces, "cell 3 3");
		
		JLabel lblAverageCharactersPer = new JLabel("Average characters per line:");
		panel_1.add(lblAverageCharactersPer, "cell 0 4");
		
		avgCharPerLn = new JLabel(""); //TODO Add values from calculations
		panel_1.add(avgCharPerLn, "cell 3 4");
		
		JLabel lblAverageWordLength = new JLabel("Average word length:");
		panel_1.add(lblAverageWordLength, "cell 0 5");
		
		avgWordLength = new JLabel(""); //TODO Add values from calculations
		panel_1.add(avgWordLength, "cell 3 5");
		
		JLabel lblMostCommonWords = new JLabel("Most common words:");
		panel_1.add(lblMostCommonWords, "cell 0 6");
		
		mstCommonWord = new JLabel(""); //TODO Add values from calculations
		panel_1.add(mstCommonWord, "cell 3 6,aligny top");
		
		JButton btnLoadFile = new JButton("Load File");
		
		panel_1.add(btnLoadFile, "cell 0 8");
		
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
		
		btnLoadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int select = histTable.getSelectedRow();
				System.out.println(select);
				if(select >= 0) {
					mWindow.refresh(mWindow.getFileHistory().get(select));
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				}
			}
		});
	}

}
