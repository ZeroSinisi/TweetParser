package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import main.TweetReader;

public class QuerySearch extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3389092436393347759L;
	private JPanel contents;
	private JTextField searchBar, instanceDisplay;
	private JButton searchBtn;
	private TweetReader tdr;
	
	public QuerySearch(TweetReader tdr) {
		this.setTitle("Tweet Search");
		this.setBounds(0, 0, 250, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.tdr = tdr;
		
		contents = new JPanel(new BorderLayout());
		searchBar = new JTextField();
		instanceDisplay = new JTextField();
		searchBtn = new JButton("Search");
		searchBtn.addActionListener(this);
		
		instanceDisplay.setEditable(false);
		instanceDisplay.setText("0");
		
		contents.add(searchBar, BorderLayout.CENTER);
		contents.add(instanceDisplay, BorderLayout.EAST);
		contents.add(searchBtn, BorderLayout.SOUTH);
		this.add(contents);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == searchBtn) {
			contents.setVisible(false);
			instanceDisplay.setText(String.valueOf(tdr.getInstances(searchBar.getText())));
			contents.setVisible(true);
		}
	}

}
