import java.util.*;
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
 * Inputs: menu choice,artist,name,runtime,price
 * 
 * Outputs: menu, invalid inputs, sucess/failure of adding song, longest song, shortest song, number of songs, total cost, details of playlist, quit, greeting, goodbye
 *
 * Certification of authenticity: I certify this lab is entirely my own work.
 *
 */
public class MusicDemoBergeron {
	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		// variables
		String placeholder;
		String artist;
		String name;
		int runtime;
		double price;
		char choice;
		SongBergeron userSongs = new SongBergeron();
		PlaylistBergeron songList = new PlaylistBergeron();
		
		//greeting
		System.out.println("Hello and welcome to my code, this project will be assisting you in the creation of a personalized music playlist!");
		
		//menu
		do {
			System.out.println("A: Add a Song to the Playlist\r\n" + "L: Find the Longest Song in the Playlist\r\n"
					+ "S: Find the Shortest Song in the Playlist\r\n" + "N: Find the Number of Songs in the Playlist\r\n"
					+ "T: Find the Total Cost of all Songs in the Playlist\r\n"
					+ "P: Print out Details about all Songs in the Playlist\r\n" + "Q: Quit");
			
			//menu selection
			placeholder = kb.next().toUpperCase();
			choice = placeholder.charAt(0);
			
			//switch for menu selection
			switch (choice) {
			//gets song details and adds to playlist
			case 'A':
				System.out.println("Please enter the name of the song: ");
				name = kb.next();
				
				
				System.out.println("Please enter the artist of the song: ");
				artist = kb.next();
				
				System.out.println("Please enter the runtime of the song: ");
				runtime = kb.nextInt();
				while(runtime<=0) {
					System.out.println("Please enter a positive number");
					runtime=kb.nextInt();
				}//while
				
				System.out.println("Please enter the price of the song: ");
				price = kb.nextDouble();
				while(price<=0) {
					System.out.println("Please enter a positive number");
					price=kb.nextDouble();
				}//while
				
				
				userSongs=new SongBergeron(name,artist,runtime,price);
				 if (songList.addToPlaylist(userSongs)) {
			            System.out.println("Song added successfully!\n");
			        }//if 
				 else {
			            System.out.println("Playlist is full! Cannot add song.\n");
			        }//else
				break;
				
				//prints longest song
			case 'L':
				if(songList.getSize()!=0)
					System.out.println(songList.findLongest());
				else System.out.println("There are no songs, thus there is no longest song.\n");
				break;
				
				//prints shortest song
			case 'S':
				if(songList.getSize()!=0)
					System.out.println(songList.findShortest());
				else System.out.println("There are no songs, thus there is no shortest song.\n");
				break;
				
				//prints number of songs
			case 'N':
				System.out.println("There are "+ songList.getSize()+" songs in the playlist\n");
				break;
				
				//prints total cost of songs in playlist
			case 'T':
				System.out.println("The total cost of all the songs in the playlist is $"+songList.calcTotalCost()+"\n");
				break;
				
				//prints details of all songs in playlists
			case 'P':
				if(songList.getSize()>0)
					songList.printFullPlaylist();
				else System.out.println("There are no details to print as there are no songs");
				break;
				
				//quits menu
			case 'Q':
				System.out.println("Goodbye! Thank you for using my code.\n");
				break;
			default:
				System.out.println("Invalid Input, Please try again\n");
				break;
			}//switch

		} while(choice!='Q');//while
		
	}// main

}// class