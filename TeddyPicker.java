import java.util.Scanner;

public class TeddyPicker {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many playlists are you choosing from?");
		int noOfPlaylists = sc.nextInt();
		sc.nextLine();
		String[] playlistNames = new String[noOfPlaylists];
		int[] playlistLengths = new int[noOfPlaylists];
		int sumOfLengths = 0;
		
		for (int i = 0; i < noOfPlaylists; i++) {
			System.out.println("Enter name of playlist: ");
			playlistNames[i] = sc.nextLine();
			System.out.println("Enter length of playlist: ");
			playlistLengths[i] = sc.nextInt();
			sc.nextLine();
			sumOfLengths += playlistLengths[i];
		}
		
		double averageLength = (double) sumOfLengths / noOfPlaylists;
		double minDifference = Math.abs (averageLength - playlistLengths[0]);
		String closestPlaylist = playlistNames[0];
		
		for (int i = 1; i < noOfPlaylists; i++) {
			double currDifference = Math.abs (averageLength - playlistLengths[i]);
			if (currDifference < minDifference) {
				minDifference = currDifference;
				closestPlaylist = playlistNames[i];
			}
		}
		
		System.out.println(closestPlaylist);
	}
}