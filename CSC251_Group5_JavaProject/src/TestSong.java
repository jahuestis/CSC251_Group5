
public class TestSong {

	public static void main(String[] args) {

		Song song1 = new Song("Debaser", "Pixies", "2:52");
		Song song2 = new Song("Spaceship", "Kanye West", "05:24");
		Song song3 = new Song("Dogs", "Pink Floyd", "17:05");
		Song song4 = new Song("Short", "Bob", "00:24"); 
		Song song5 = new Song("Blank", "Bob", "0:00"); 
		Song song6 = new Song("Max length", "Bob", "99:59"); 
		
		System.out.println(song1);
		System.out.println(song2);
		System.out.println(song3);
		System.out.println(song4);
		System.out.println(song5);
		System.out.println(song6);

		try {
			Song song7 = new Song("Too Long", "Bob", "100:00");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Song song8 = new Song("Missing Minutes", "Bob", ":21");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Song song9 = new Song("Only Seconds", "Bob", "49");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Song song10 = new Song("Too Many Seconds", "Bob", "0:60");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Song song11 = new Song("Not Enough Seconds", "Bob", "4:1");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Song song12 = new Song("Negative Minutes", "Bob", "-1:20");
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			Song song13 = new Song("Negative Seconds", "Bob", "2:-5");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Song song14 = new Song();
		System.out.println(song14);
		
		song14.setTitle("Road");
		song14.setArtist("Nick Drake");
		song14.setLength("1:59");
		System.out.println(song14);
		
		
	}

}
