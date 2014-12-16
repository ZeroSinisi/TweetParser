package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.TweetReader;

public class TweetDisplay extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7180828722498857988L;
	private JTextField id, guid, link, pubdata, author, title, description, source, code, coords;
	private int index;
	private TweetReader tdr;
	private JComboBox<String> indexPicker;
	
	public TweetDisplay(TweetReader tdr) {
		super(new GridLayout(11,1));
		this.tdr = tdr;
		indexPicker = new JComboBox<String>(tdr.getIndices());
		indexPicker.addActionListener(this);
		index = Integer.valueOf((String) indexPicker.getSelectedItem());
		this.add(indexPicker);
		id = new JTextField("ID: " + tdr.getTweet(index).getId());
		id.setEditable(false);
		this.add(id);
		guid = new JTextField("GUID: " + tdr.getTweet(index).getGuid());
		guid.setEditable(false);
		this.add(guid);
		link = new JTextField("Link: " + tdr.getTweet(index).getLink());
		link.setEditable(false);
		this.add(link);
		pubdata = new JTextField("Pubdata: " + tdr.getTweet(index).getPubdata());
		pubdata.setEditable(false);
		this.add(pubdata);
		author = new JTextField("Author: " + tdr.getTweet(index).getAuthor());
		author.setEditable(false);
		this.add(author);
		title = new JTextField("Title: " + tdr.getTweet(index).getTitle());
		title.setEditable(false);
		this.add(title);
		description = new JTextField("Description: " + tdr.getTweet(index).getDescription());
		description.setEditable(false);
		this.add(description);
		source = new JTextField("Source: " + tdr.getTweet(index).getSource());
		source.setEditable(false);
		this.add(source);
		code = new JTextField("Code: " + tdr.getTweet(index).getCode());
		code.setEditable(false);
		this.add(code);
		coords = new JTextField("Coords: " + tdr.getTweet(index).getCoords());
		coords.setEditable(false);
		this.add(coords);
	}
	
	private void regenerateDisplay() {
		this.setVisible(false);
		this.removeAll();
		this.add(indexPicker);
		id = new JTextField("ID: " + tdr.getTweet(index).getId());
		id.setEditable(false);
		this.add(id);
		guid = new JTextField("GUID: " + tdr.getTweet(index).getGuid());
		guid.setEditable(false);
		this.add(guid);
		link = new JTextField("Link: " + tdr.getTweet(index).getLink());
		link.setEditable(false);
		this.add(link);
		pubdata = new JTextField("Pubdata: " + tdr.getTweet(index).getPubdata());
		pubdata.setEditable(false);
		this.add(pubdata);
		author = new JTextField("Author: " + tdr.getTweet(index).getAuthor());
		author.setEditable(false);
		this.add(author);
		title = new JTextField("Title: " + tdr.getTweet(index).getTitle());
		title.setEditable(false);
		this.add(title);
		description = new JTextField("Description: " + tdr.getTweet(index).getDescription());
		description.setEditable(false);
		this.add(description);
		source = new JTextField("Source: " + tdr.getTweet(index).getSource());
		source.setEditable(false);
		this.add(source);
		code = new JTextField("Code: " + tdr.getTweet(index).getCode());
		code.setEditable(false);
		this.add(code);
		coords = new JTextField("Coords: " + tdr.getTweet(index).getCoords());
		coords.setEditable(false);
		this.add(coords);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		index = Integer.valueOf((String) indexPicker.getSelectedItem());
		regenerateDisplay();
		System.out.println("Display Regened");
	}

}
