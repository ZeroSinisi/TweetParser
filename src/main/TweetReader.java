package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TweetReader {

	private BufferedReader rdr = null;
	private HashMap<Integer,Tweet> tweets = null;
	private Integer[] indices = null;
	
	public TweetReader(File f) {
		try {
			rdr = new BufferedReader(new FileReader(f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String dataLine = null;
		tweets = new HashMap<Integer,Tweet>();
		try {
			while((dataLine = rdr.readLine()) != null) {
				char first = dataLine.charAt(0);
				if(Character.isDigit(first)) {
					Tweet tweet = new Tweet(dataLine);
					tweets.put(Integer.valueOf(tweet.getId()), tweet);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		indices = tweets.keySet().toArray(new Integer[tweets.size()]);
	}
	
	public Tweet getTweet(int index) {
		return tweets.get(index);
	}
	
	public String[] getIndices() {
		String[] indexStrings = new String[indices.length];
		for(int i = 0; i < indices.length; i++) {
			indexStrings[i] = String.valueOf(indices[i]);
		}
		return indexStrings;
	}
	
	public int getInstances(String query) {
		int instances = 0;
		for(Tweet tweet: tweets.values()) {
			String contents = tweet.getDescription();
			if((contents.toLowerCase()).contains(query.toLowerCase())) {
				instances++;
			}
		}
		return instances;
	}

}
