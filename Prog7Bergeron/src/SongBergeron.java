/**
 * 
 * @author paulp
 * 
 * Prog 7
 * Due 3/27/2023 10:30am
 * 
 * Purpose: this provides a simple solution for managing a playlist of songs. It allows the user to perform operations such as adding songs to a playlist, 
 * finding the longest and shortest songs, calculating the total cost of all songs in the playlist, then displaying them.
 * 
 * Inputs: artist,name,runtime,price
 * 
 * Outputs: arist, runtime, name, price
 *
 * Certification of authenticity: I certify this lab is entirely my own work.
 *
 */
public class SongBergeron {
String myName;
String myArtist;
int myRuntime;
double myPrice;

/**
 * Constructor to create SongBergeron object
 * 
 * @param newName	name of the song
 * @param newArtist		artists name
 * @param newRuntime	runtime of the song
 * @param newPrice		price of the song
 */
public SongBergeron(String newName, String newArtist, int newRuntime, double newPrice) {
	myName=newName;
	myArtist=newArtist;
	myRuntime=newRuntime;
	myPrice=newPrice;
}

/**
 * null constructor
 */
public SongBergeron() {
	myName="";
	myArtist="";
	myRuntime=0;
	myPrice=0;
}

/**
 * charges the value of myName instance variable to parameter value
 * @param newName		name of the song
 */
public void setName(String newName) {
	myName=newName;
}

/**
 * charges the value of myArtist instance variable to parameter value
 * @param newArtist		artist of the song
 */
public void setArtist(String newArtist) {
	myArtist=newArtist;
}

/**
 * charges the value of myRuntime instance variable to parameter value
 * @param newRuntime	runtime of the song
 */
public void setRuntime(int newRuntime) {
	myRuntime=newRuntime;
}

/**
 * charges the value of myPrice instance variable to parameter value
 * @param newPrice	price of the song
 */
public void setPrice(double newPrice) {
	myPrice=newPrice;
}

/**
 * method that returns name of the song
 * @return returns the name of song
 */
public String getName() {
	return myName;
}

/**
 * method that returns artist of the song
 * @return returns artist of the song
 */
public String getArtist() {
	return myArtist;
}

/**
 * method that returns runtime of the song
 * @return returns runtime of the song
 */
public int getRuntime() {
	return myRuntime;
}

/**
 * method that returns price of the song
 * @return returns price of the song
 */
public double getPrice() {
	return myPrice;
}

/**
 * prints out all data about a song
 */
public String toString() {
	String ans="The name of the song is "+myName;
	ans+="\nThe artist of the song is "+myArtist;
	ans+="\nThe runtime of the song is "+myRuntime;
	ans+="\nThe price of the song is "+myPrice+"\n";
	return ans;
}

}
