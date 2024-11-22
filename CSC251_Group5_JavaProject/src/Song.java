
import java.util.regex.Pattern;

public class Song {
	
	String _title;
	String _artist;
	Duration _length;
	
	public Song() {
		_title = "empty";
		_artist = "empty";
		_length = new Duration("0:00");
		
	}
	
	public Song(String title, String artist, String length) {
		_title = title;
		_artist = artist;
		_length = new Duration(length);
	}
	
	public Song(String title, String artist, Duration length) {
		_title = title;
		_artist = artist;
		_length = length;
	}
	
	public String getTitle() {
		return _title;
	}
	
	public String getArtist() {
		return _artist;
	}
	
	public Duration getLength() {
		return _length;
	}
	
	public void setTitle(String title) {
		_title = title;
	}
	
	public void setArtist(String artist) {
		_artist = artist;
	}
	
	public void setLength(String length) {
		_length = new Duration(length);
	}
	
	public void setLength(Duration length) {
		_length = length;
	}
	
	@Override
	public String toString() {
		return _artist + " - " + _title + " (" + _length + ")";
	}
	
	
	class Duration {
		String _duration;
		int _durationSeconds;
		
		// Duration from String
		public Duration(String duration) {
			// Regex check that duration entered matches mm:ss format
			Pattern pattern = Pattern.compile("^\\d{1,2}:[0-5]\\d$");
			if (pattern.matcher(duration).matches()) {
				// Remove leading 0 in minutes for consistency
				if (duration.length() == 5 && duration.charAt(0) == '0') {
					_duration = duration.substring(1);
				} else {
					_duration = duration;
				}
				
				// Determine duration in seconds
				String[] durationSplit = _duration.split(":");
				_durationSeconds = Integer.parseInt(durationSplit[0]) * 60 + Integer.parseInt(durationSplit[1]); 
				
			} else {
				throw new IllegalArgumentException("Duration (" + duration + ") entered in incorrect format (expected mm:ss/m:ss)");
			}

		}
		
		public String getDuration() {
			return _duration;
		}
		
		public int getDurationSeconds() {
			return _durationSeconds;
		}
		
		@Override
		public String toString() {
			return _duration;
		}
		
	}
	
	
}
