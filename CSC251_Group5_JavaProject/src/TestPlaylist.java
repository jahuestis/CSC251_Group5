
public class TestPlaylist {
	
	public static void main(String[] args) {
	
		Playlist myPlaylist = new Playlist("My Playlist");
		Song song1 = new Song("Debaser", "Pixies", "2:52");
		Song song2 = new Song("Spaceship", "Kanye West", "05:24");
		Song song3 = new Song("Dogs", "Pink Floyd", "17:05");
		Song song4 = new Song("Road", "Nick Drake", "1:59"); 
		Song song5 = new Song("Billie Jean", "Michael Jackson", "4:54"); 
		Song song6 = new Song("In Bloom", "Nirvana", "4:15"); 
		
		myPlaylist.add(song1);
		myPlaylist.add(song2);
		myPlaylist.add(song3);
		myPlaylist.add(song4);
		myPlaylist.add(song5);
		myPlaylist.add(song6);
		System.out.println(myPlaylist);
		
		System.out.println("\nRemove index 2");
		
		myPlaylist.remove(2);
		System.out.println(myPlaylist);
		
		System.out.println("\nGet index 2");
		
		System.out.println(myPlaylist.get(2));
		
		System.out.println("\nShuffle");
		
		myPlaylist.shuffle();
		System.out.println(myPlaylist);	
		
		System.out.println("\nSort by default (order added)");
		
		myPlaylist.sortByDefault();
		System.out.println(myPlaylist);
		
		System.out.println("\nAdd blank song");
		
		myPlaylist.add(new Song());
		System.out.println(myPlaylist);
		
		
		System.out.println("\nSort by title");
		
		myPlaylist.sortByTitle();
		System.out.println(myPlaylist);
		
		System.out.println("\nSort by artist");
		
		myPlaylist.sortByArtist();
		System.out.println(myPlaylist);
		
		System.out.println("\nSort by length");
		
		myPlaylist.sortByLength();
		System.out.println(myPlaylist);
		
		
		
	}
}
