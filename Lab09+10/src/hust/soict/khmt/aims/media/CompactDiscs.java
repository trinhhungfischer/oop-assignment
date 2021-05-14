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
	private static List<CompactDiscs> CDList = new ArrayList<>();
	
	public CompactDiscs() {
		// TODO Auto-generated constructor stub
		CDList.add(this);
	}

	
	public static List<CompactDiscs> getCDList() {
		return CompactDiscs.CDList;
	}

	public static void setCDList(List<CompactDiscs> CDList) {
		CompactDiscs.CDList = CDList;
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
		if (this.getLength() > 0)
			for (Track track : trackList) {
				track.play();
			}
	}

	@Override
	public String print(int i, int idFree) {
		// TODO Auto-generated method stub
		super.print(i, idFree);

		String price;
		if (idFree >= 0)
			price = "Free";
		else
			price = Float.toString(this.getCost()) + " $";
		return ((i + 1) + ". CD - Has  " + trackList.size() + " track(s) with " + this.getLength()
				+ " minutes : " + price + "\n");
	}

	@Override
	public int compareTo(Object o) {
		if (!(o instanceof CompactDiscs)) {
			return o.getClass().toString().compareTo(CompactDiscs.class.toString());
		} else {
			CompactDiscs item = (CompactDiscs) o;
			if (Integer.compare(this.trackList.size(), item.trackList.size()) != 0)
				return Integer.compare(this.trackList.size(), item.trackList.size());
			else
				return Integer.compare(this.getLength(), item.getLength());
		}
	}
	
	public String printTrack()
	{
		StringBuffer strBuilder = new StringBuffer();
		for (int i =0; i < trackList.size(); i++)
		{
			strBuilder.append(trackList.get(i).printInStore());
		}
		return strBuilder.toString();
	}
}
