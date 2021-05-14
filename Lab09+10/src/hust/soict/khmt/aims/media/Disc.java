package hust.soict.khmt.aims.media;

import hust.soict.khmt.aims.exceptions.PlayerException;

public class Disc extends Media implements Playable {

	protected String director;
	protected int length;

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Disc() {
		// TODO Auto-generated constructor stub
	}

	public Disc(String director) {
		this.director = director;
	}

	public Disc(String director, int length) {
		this.director = director;
		this.length = length;
	}

	@Override
	public void play() throws PlayerException {
		// TODO Auto-generated method stub

	}
}
