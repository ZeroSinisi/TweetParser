package main;

public class Tweet {

	private String id, guid, link, pubdata, author, title, description, source, code, coords;
	private String[] fields;
	
	public Tweet(String dataLine) {
		fields = dataLine.split("\",\"");
		String[] ids = fields[0].split(",\"");
		id = ids[0];
		guid = ids[1];
		link = fields[1];
		pubdata = fields[2];
		author = fields[3];
		title = fields[4];
		description = fields[5];
		source = fields[6];
		code = fields[7];
		coords = fields[8];
	}
	
	public String[] toStringArray() {
		return fields;
	}
	
	public String getId() {
		return id;
	}
	
	public String getGuid() {
		return guid;
	}
	
	public String getLink() {
		return link;
	}
	
	public String getPubdata() {
		return pubdata;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getSource() {
		return source;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getCoords() {
		return coords;
	}
	
}
