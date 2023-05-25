import java.io.*;
import java.util.*;
/**
 * 
 * @author PaulBergeron <br>
 * 
 * Prog 8 <br>
 * Due 3/30/2023 10:30am <br>
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
		String placeholder = null;
		String artist = null;
		String name=null;
		int runtime=0;
		double price=0.0;
		char choice;
		SongBergeron userSongs;
		PlaylistBergeron songList = new PlaylistBergeron();
		File file = null;
		int numInputs;
		Scanner scanner=null;
		SongBergeron longest;
		SongBergeron shortest;
		
		
		
		//greeting
		System.out.println("Hello and welcome to my code, this project will be assisting you in the creation of a personalized music playlist!");
		
		//file inputs
		System.out.println("What is the name of the file?");
		placeholder=kb.next();
		file = new File(placeholder);
		try {
			scanner = new Scanner(file);
			numInputs=scanner.nextInt();
			for(int a=0;a<(numInputs);a++) {
				name=scanner.next();
				artist=scanner.next();
				runtime=scanner.nextInt();
				price=scanner.nextDouble();
				userSongs=new SongBergeron(name,artist,runtime,price);
				if (songList.addToPlaylist(userSongs)) {
		            System.out.println("Song "+(a+1)+" imported successfully!\n");
		        }//if 
			 else {
		            System.out.println("Playlist is full! Cannot add song.\n");
		        }//else

			}//for
			
		}//try 
		catch (FileNotFoundException e) {
			System.out.println("Error, file not found");
		}//catch
		
		//menu
		do {
			System.out.println("\n\nA: Add a Song to the Playlist\r\n" + "L: Find the Longest Song in the Playlist\r\n"
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
				System.out.println("what is the name of the file");
				placeholder=kb.next();
				
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
				if(songList.findLongest()!=null) {
					longest=songList.findLongest();
					System.out.println(longest.toString());
				}//if
				
				else System.out.println("There are no songs, thus there is no longest song.\n");
				break;
				
				//prints shortest song
			case 'S':
				if(songList.findLongest()!=null) {
					shortest=songList.findShortest();
					System.out.println(shortest.toString());
				}//if
				else System.out.println("There are no songs, thus there is no shortest song.\n");
				break;
				
				//prints number of songs
			case 'N':
				System.out.println("There are "+ songList.getSize()+" songs in the playlist\n");
				break;
				
				//prints total cost of songs in playlist
			case 'T':
				System.out.printf("The total cost of all the songs in the playlist is $%,.2f", songList.calcTotalCost());
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