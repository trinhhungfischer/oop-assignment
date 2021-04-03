package hust.soict.khmt.aims;

import java.util.*;

import javax.xml.stream.events.EndDocument;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import hust.soict.khmt.aims.media.Book;
import hust.soict.khmt.aims.media.DigitalVideoDisc;
import hust.soict.khmt.aims.media.Media;

public class ReaderAllHanderSax extends DefaultHandler {
	
	 private StringBuilder currentValue = new StringBuilder();
	 
	 public List<Media> mediaList = new ArrayList<>();
	

	  @Override
	  public void startElement(
	          String uri,
	          String localName,
	          String qName,
	          Attributes attributes) {
		  if (qName.equalsIgnoreCase("Book"))
		  {
			  Book newBook = new Book();
			  
			  int id = Integer.parseInt(attributes.getValue("id"));
			  newBook.setId_to_store(id);
			  
			  String title = attributes.getValue("title");
			  newBook.setTitle(title);
			  
			  String category = attributes.getValue("category");
			  newBook.setCategory(category);
			  
			  newBook.setNameTag("Book");
			  
			  String[] authors = attributes.getValue("author").split(",");
			  for (String author: authors)
			  {
				  newBook.addAuthor(author);
			  }
			  
			  float cost = Float.parseFloat(attributes.getValue("cost"));
			  newBook.setCost(cost);
			  
			  mediaList.add(newBook);
		  }
		  
		  if (qName.equalsIgnoreCase("DVD"))
		  {
			  DigitalVideoDisc newDVD = new DigitalVideoDisc();
			  
			  int id = Integer.parseInt(attributes.getValue("id"));
			  newDVD.setId_to_store(id);
			  
			  String title = attributes.getValue("title");
			  newDVD.setTitle(title);
			  
			  String category = attributes.getValue("category");
			  newDVD.setCategory(category);
			  
			  float cost = Float.parseFloat(attributes.getValue("cost"));
			  newDVD.setCost(cost);

			  int length = Integer.parseInt(attributes.getValue("length"));
			  newDVD.setLength(length);
			  
			  String director = attributes.getValue("director");
			  newDVD.setDirector(director);

			  newDVD.setNameTag("DVD");
			  
			  mediaList.add(newDVD);
		  }
	  }
}
