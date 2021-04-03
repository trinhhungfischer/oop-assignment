package hust.soict.khmt.aims;

import java.util.ArrayList;
import java.util.List;

import hust.soict.khmt.aims.ReaderAllHanderSax;
import hust.soict.khmt.aims.media.Media;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class storage {
	public List<Media> mediaList = new ArrayList<>();
	
	private static final String FILENAME = ".\\src\\hust\\soict\\khmt\\aims\\storage.xml";
	
	public storage() {
		// TODO Auto-generated constructor stub
		 SAXParserFactory factory = SAXParserFactory.newInstance();

	        try {

	            SAXParser saxParser = factory.newSAXParser();

	            ReaderAllHanderSax handler = new ReaderAllHanderSax();
	            saxParser.parse(FILENAME, handler);
	            
	            this.mediaList = handler.mediaList;

	        } catch (ParserConfigurationException | SAXException | IOException e) {
	            e.printStackTrace();
	        }
	}
	

}
