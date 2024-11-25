
import java.util.ArrayList;
import java.util.Collections;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Playlist {
	
	ArrayList<PlaylistSlot> _playlist;
	String _title;
	int _peakSize = 0;
	
	public Playlist(String title) {
		_playlist = new ArrayList<PlaylistSlot>();
		_title = title;
	}
	
	public void add(Song song) {
		_playlist.add(new PlaylistSlot(song, _peakSize));
		_peakSize ++;
	}
	
	public void remove(int index) {
		_playlist.remove(index);
		
	}
	
	public Song get(int index) {
		return _playlist.get(index).getSong();
	}
	
	public int size() {
		return _playlist.size();
	}
	
	public void shuffle() {
		Collections.shuffle(_playlist);
	}
	
	public void sortByTitle() {
		Collections.sort(_playlist, (obj1, obj2) -> {
			PlaylistSlot a = (PlaylistSlot) obj1;
			PlaylistSlot b = (PlaylistSlot) obj2;
			if (a.getSongTitle().toUpperCase().compareTo(b.getSongTitle().toUpperCase()) < 0) return -1;
			if (a.getSongTitle().toUpperCase().compareTo(b.getSongTitle().toUpperCase()) > 0) return 1;
			return 0;
		});
	}
	
	public void sortByArtist() {
		Collections.sort(_playlist, (obj1, obj2) -> {
			PlaylistSlot a = (PlaylistSlot) obj1;
			PlaylistSlot b = (PlaylistSlot) obj2;
			if (a.getSongArtist().toUpperCase().compareTo(b.getSongArtist().toUpperCase()) < 0) return -1;
			if (a.getSongArtist().toUpperCase().compareTo(b.getSongArtist().toUpperCase()) > 0) return 1;
			return 0;
		});
	}
	
	public void sortByLength() {
		Collections.sort(_playlist, (obj1, obj2) -> {
			PlaylistSlot a = (PlaylistSlot) obj1;
			PlaylistSlot b = (PlaylistSlot) obj2;
			if (a.getSongLengthSeconds() < b.getSongLengthSeconds()) return -1;
			if (a.getSongLengthSeconds() > b.getSongLengthSeconds()) return 1;
			return 0;
		});
	}
	
	public void sortByDefault() {
		Collections.sort(_playlist, (obj1, obj2) -> {
			PlaylistSlot a = (PlaylistSlot) obj1;
			PlaylistSlot b = (PlaylistSlot) obj2;
			if (a.getDefaultPosition() < b.getDefaultPosition()) return -1;
			if (a.getDefaultPosition() > b.getDefaultPosition()) return 1;
			return 0;
		});
	}
	
	public String getTitle() {
		return _title;
	}
	
	@Override
	public String toString() {
		String result = _title;
		for (int i = 0; i < size(); i++) {
			result += "\n" + i + ": " + get(i);
		}
		return result;
	}
	
	class PlaylistSlot {
		private Song _song;
		private int _defaultPosition;
		
		private PlaylistSlot(Song song, int defaultPosition) {
			_song = song;
			_defaultPosition = defaultPosition;
		}
		
		private Song getSong() {
			return _song;
		}
		
		private String getSongTitle() {
			return _song.getTitle();
		}
		
		private String getSongArtist() {
			return _song.getArtist();
		}
		
		private int getSongLengthSeconds() {
			return _song.getLengthSeconds();
		}
		
		private int getDefaultPosition() {
			return _defaultPosition;
		}
		
	}

	public void savePlaylist() {

		try {
			// create a file called "playlist.txt"
			
			String fileName = getTitle().replaceAll(" ", "_").toLowerCase() + ".txt";
			File file = new File(fileName);

			// PrintWriter to write to the file
			PrintWriter saver = new PrintWriter(new FileWriter(fileName));			
			
			// write to the file
			saver.println(this.toString());

			// close the PrintWriter
			saver.close();	

			// print "Playlist saved" confirmation
			System.out.println("Playlist saved");

		} catch (Exception e) {

			// in case of error, Print "Playlist could not be saved"

			System.out.println("Playlist could not be saved");
			System.out.println(e); 

		}
        

	}
}
