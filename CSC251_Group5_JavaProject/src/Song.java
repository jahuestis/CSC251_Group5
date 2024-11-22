
import java.util.regex.Pattern;

public class Song {
	
	private String _title;
	private String _artist;
	private Duration _length;
	
	public Song() {
		_title = "untitled";
		_artist = "no artist";
		_length = new Duration();
		
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
	
	public int getLengthSeconds() {
		return _length.getDurationSeconds();
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
		private String _duration;
		private int _durationSeconds;
		
		private Duration() {
			_duration = formatDurationStr("0:00");
			_durationSeconds = 0;
		}
		
		private Duration(String durationStr) {
			_duration = formatDurationStr(durationStr);
			// Determine duration in seconds
			String[] durationSplit = _duration.split(":");
			_durationSeconds = Integer.parseInt(durationSplit[0]) * 60 + Integer.parseInt(durationSplit[1]); 

		}
		
		private String formatDurationStr(String durationStr) {
			// Regex check that duration entered matches mm:ss format
			Pattern pattern = Pattern.compile("^\\d{1,2}:[0-5]\\d$");
			if (pattern.matcher(durationStr).matches()) {
				// Remove leading 0 in minutes for consistency
				if (durationStr.length() == 5 && durationStr.charAt(0) == '0') {
					return durationStr.substring(1);
				} else {
					return durationStr;
				}
							
			} else {
				throw new IllegalArgumentException("Duration (" + durationStr + ") entered in incorrect format (expected mm:ss/m:ss)");
			}
		}
		
		private String getDuration() {
			return _duration;
		}
		
		private int getDurationSeconds() {
			return _durationSeconds;
		}
		
		@Override
		public String toString() {
			return _duration;
		}
		
	}
	
	
}
