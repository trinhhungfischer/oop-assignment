package hust.soict.khmt.aims.media;

import java.util.*;

public class CompactDiscs extends Disc
implements Playable
{

	private String title;
	private String category;
	private float cost;
	private String nameTag = "CD";
	
	public String getNameTag() {
		return nameTag;
	}

	public void setNameTag(String nameTag) {
		this.nameTag = nameTag;
	}

	private String artist;
	private List<Track> trackList = new ArrayList<Track>();
	
	public CompactDiscs() {
		// TODO Auto-generated constructor stub
	}

	public void addTrack(Track aTrack)
	{
		for (Track track : trackList)
		{
			if (aTrack.equals(track))
			{
				System.out.println("This track had been added");
				return;
			}
		}
		trackList.add(aTrack);
		System.out.println("This track added sucessfully");
	}
	
	public void removeTrack(Track aTrack)
	{
		for (int i = 0; i < trackList.size(); i++ )
		{
			if (trackList.get(i).equals(aTrack)) {
				trackList.remove(i);
				System.out.println("Remove this track sucessfully");
				return;
			}
		}
		System.out.println("This track hadn't been added before");
	}
	
	public int getLength()
	{
		int sum = 0;
		for (Track track : trackList)
		{
			sum += track.getLength();
		}
		return sum;
	}
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
		for (Track track : trackList)
		{
			track.play();
		}
	}
	
	@Override
	public void print(int i, int idFree) {
		// TODO Auto-generated method stub
		super.print(i, idFree);

		String price;
		if (idFree == i)
			price = "Free";
		else
			price = Float.toString(this.getCost()) + " $";
		System.out.println((i + 1) + ". CD - Has  " + trackList.size() + " track(s) with " + this.getLength() + " minutes : " + price);
	}
	
}
