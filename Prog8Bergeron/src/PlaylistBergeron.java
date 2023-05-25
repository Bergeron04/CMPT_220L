/**
 * 
 * @author paulbergeron <br>
 * 
 * Prog 8 <br> 
 * Due 3/30/2023 10:30am <br>
 * 
 * Purpose: this provides a simple solution for managing a playlist of songs. It allows the user to perform operations such as adding songs to a playlist, 
 * finding the longest and shortest songs, calculating the total cost of all songs in the playlist, then displaying them.
 * 
 * Inputs: songs,playlits
 * 
 * Outputs: invalid inputs, sucess/failure of adding song, longest song, shortest song, number of songs, total cost, details of playlist
 *
 * Certification of authenticity: I certify this lab is entirely my own work.
 *
 */
public class PlaylistBergeron {
	SongBergeron[] mySongs;
	int mySize;
		public PlaylistBergeron() {
			mySize=0;
			mySongs = new SongBergeron[10];
		}//null constructor
	public int getSize() {
		return mySize;
		
	}//getSize
	
	/**
	 * this method adds a new song to the playlit as long as it isnt full
	 * @param newSong name of the song
	 * @return returns if adding a song to playlist was a success
	 */
	public boolean addToPlaylist(SongBergeron newSong) {
		boolean success=false;
		if(mySize<mySongs.length) {
			mySongs[mySize]=newSong;
			mySize++;
			success=true;
		}//if
		return success;
	}//addToPlaylist
	
	/**
	 * returns the longest song in the playlist
	 * @return the longest song in the playlist
	 */
	public SongBergeron findLongest() {
		SongBergeron longest=null;
		if(mySize!=0)
			longest=mySongs[0];
		for(int i =1; i<mySize;i++) {
			if(mySongs[i].getRuntime()>longest.getRuntime())
				longest=mySongs[i];
		}//for
		return longest;
	}//findLongest
	
	/**
	 * returns the shortest song in the playlist
	 * @return the shortest song in the playlist
	 */
	public SongBergeron findShortest() {
		SongBergeron shortest=null;
		if(mySize!=0)
			shortest=mySongs[0];
		for(int i =0; i<mySize;i++) {
			if(i==0||mySongs[i].getRuntime()<shortest.getRuntime())
				shortest=mySongs[i];
		}//for
		return shortest;
	}//method
	
	/**
	 * returns the total cost of songs in the playlist
	 * @return total cost of songs in playlist
	 */
	public double calcTotalCost() {
		double total=0.0;
		for(int i =0; i<mySize;i++) {
			total+=mySongs[i].getPrice();
		}//for
		return total;
	}//method
	
	/**
	 * prints all  data about every song in the playlist
	 */
	public void  printFullPlaylist() {
		for(int i =0; i<mySize;i++) {
			System.out.println("Song #"+(i+1)+":\n"+mySongs[i].toString());
		}//for
	}//method
}//class