package hust.soict.khmt.aims.utils;

import java.util.ArrayList;
import java.util.List;

import hust.soict.khmt.aims.gui.Menu;
import hust.soict.khmt.aims.media.Book;
import hust.soict.khmt.aims.media.DigitalVideoDisc;
import hust.soict.khmt.aims.media.Media;
import hust.soict.khmt.aims.media.Track;

import org.xml.sax.SAXException;

import javax.swing.ImageIcon;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class Storage {
	public static List<Media> mediaList = new ArrayList<>();

	public Storage() {
		// TODO Auto-generated constructor stub
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		try {

			SAXParser saxParser = factory.newSAXParser();

			ReaderAllHanderSax handler = new ReaderAllHanderSax();
			saxParser.parse(Menu.class.getResource("/hust/soict/khmt/aims/asset/storage.xml").toString(), handler);

			Storage.mediaList = handler.mediaList;

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	public static String showStore() {
		String str = "";
		for (int i = 0; i < mediaList.size(); i++) {
			str += mediaList.get(i).printInStore();
		}
		return str;
	}
	
	public static String showBook()
	{
		String str = "";
		for (int i = 0; i < mediaList.size(); i++) {
			if (mediaList.get(i).getClass() == Book.class)
				str += mediaList.get(i).printInStore();
		}
		return str;
	}
	
	public static String showDVD()
	{
		String str = "";
		for (int i = 0; i < mediaList.size(); i++) {
			if (mediaList.get(i).getClass() == DigitalVideoDisc.class)
				str += mediaList.get(i).printInStore();
		}
		return str;
	}
	
	public static String showTrack()
	{
		String str = "";
		for (int i = 0; i < mediaList.size(); i++) {
			if (mediaList.get(i).getClass() == Track.class)
				str += mediaList.get(i).printInStore();
		}
		return str;
	}
}
