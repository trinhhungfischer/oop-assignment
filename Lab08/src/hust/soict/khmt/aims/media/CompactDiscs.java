package hust.soict.khmt.aims.media;

import java.util.*;

public class CompactDiscs extends Disc implements Playable {
	private String nameTag = "CD";

	public String getNameTag() {
		return nameTag;
	}

	public void setNameTag(String nameTag) {
		this.nameTag = nameTag;
	}

	private List<Track> trackList = new ArrayList<Track>();

	public CompactDiscs() {
		// TODO Auto-generated constructor stub
	}

	public void addTrack(Track aTrack) {
		if (trackList.contains(aTrack))
			System.out.println("This track had been added");
		else {
			trackList.add(aTrack);
			System.out.println("This track added sucessfully");
		}
	}

	public void removeTrack(Track aTrack) {
		for (int i = 0; i < trackList.size(); i++) {
			if (trackList.get(i).equals(aTrack)) {
				trackList.remove(i);
				System.out.println("Remove this track sucessfully");
				return;
			}
		}
		System.out.println("This track hadn't been added before");
	}

	public int getLength() {
		int sum = 0;
		for (Track track : trackList) {
			sum += track.getLength();
		}
		return sum;
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		for (Track track : trackList) {
			track.play();
		}
	}

	@Override
	public void print(int i, int idFree) {
		// TODO Auto-generated method stub
		super.print(i, idFree);

		String price;
		if (idFree >= 0)
			price = "Free";
		else
			price = Float.toString(this.getCost()) + " $";
		System.out.println((i + 1) + ". CD - Has  " + trackList.size() + " track(s) with " + this.getLength()
				+ " minutes : " + price);
	}

	@Override
	public int compareTo(Object o) {
		if (!(o instanceof CompactDiscs)) {
			return o.getClass().toString().compareTo(CompactDiscs.class.toString());
		} else {
			CompactDiscs item = (CompactDiscs) o;
			if (Integer.compare(this.trackList.size(), item.trackList.size()) != 0)
				return Integer.compare(this.trackList.size(), item.trackList.size());
			else return Integer.compare(this.getLength(), item.getLength());
		}
	}
}
