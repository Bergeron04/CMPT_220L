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
}//SongBergeron

/**
 * null constructor
 */
public SongBergeron() {
	myName="";
	myArtist="";
	myRuntime=0;
	myPrice=0;
}//SongBergeron

/**
 * charges the value of myName instance variable to parameter value
 * @param newName		name of the song
 */
public void setName(String newName) {
	myName=newName;
}//setName

/**
 * charges the value of myArtist instance variable to parameter value
 * @param newArtist		artist of the song
 */
public void setArtist(String newArtist) {
	myArtist=newArtist;
}//setArtist

/**
 * charges the value of myRuntime instance variable to parameter value
 * @param newRuntime	runtime of the song
 */
public void setRuntime(int newRuntime) {
	myRuntime=newRuntime;
}//setRuntime

/**
 * charges the value of myPrice instance variable to parameter value
 * @param newPrice	price of the song
 */
public void setPrice(double newPrice) {
	myPrice=newPrice;
}//setPrice

/**
 * method that returns name of the song
 * @return returns the name of song
 */
public String getName() {
	return myName;
}//getName

/**
 * method that returns artist of the song
 * @return returns artist of the song
 */
public String getArtist() {
	return myArtist;
}//getArtist

/**
 * method that returns runtime of the song
 * @return returns runtime of the song
 */
public int getRuntime() {
	return myRuntime;
}//getRuntiome

/**
 * method that returns price of the song
 * @return returns price of the song
 */
public double getPrice() {
	return myPrice;
}//getPrice

/**
 * prints out all data about a song
 */
public String toString() {
	String ans="The name of the song is "+myName;
	ans+="\nThe artist of the song is "+myArtist;
	ans+="\nThe runtime of the song is "+myRuntime;
	ans+="\nThe price of the song is $"+myPrice+"\n";
	return ans;
}//toString

}//SongBergeron
