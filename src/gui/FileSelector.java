package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import main.TweetReader;

public class FileSelector extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7245548830840246993L;
	private Launcher parent;
	private JFileChooser fc;
	private JButton openBtn, searchBtn;
	private TweetReader tdr;
	
	public FileSelector(Launcher parent) {
		super(new BorderLayout());
		this.parent = parent;
		fc = new JFileChooser();
		openBtn = new JButton("Open Dataset");
		openBtn.addActionListener(this);
		searchBtn = new JButton("Search Dataset");
		searchBtn.addActionListener(this);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(openBtn);
		buttonPanel.add(searchBtn);
		add(buttonPanel, BorderLayout.PAGE_START);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == openBtn) {
            int returnVal = fc.showOpenDialog(FileSelector.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                tdr = new TweetReader(file);
                parent.newReader(tdr);
            }
        } else if(e.getSource() == searchBtn) {
        	QuerySearch qs = new QuerySearch(tdr);
        	qs.setVisible(true);
        }
	}
	
	public TweetReader getTweetReader() {
		return tdr;
	}

}
