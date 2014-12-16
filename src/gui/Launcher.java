package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import main.TweetReader;

public class Launcher extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TweetReader tdr;
	private FileSelector fs;
	private JPanel contents;
	
	public Launcher() {
		this.setTitle("Tweet Reader");
		this.setBounds(0, 0, 1200, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		contents = new JPanel(new BorderLayout());
		fs = new FileSelector(this);
		contents.add(fs, BorderLayout.NORTH);
		this.add(contents);
	}
	
	public void newReader(TweetReader tReader) {
		tdr = tReader;
		TweetDisplay display = new TweetDisplay(tdr);
		contents.setVisible(false);
		contents.add(display, BorderLayout.CENTER);
		contents.setVisible(true);
	}

}
