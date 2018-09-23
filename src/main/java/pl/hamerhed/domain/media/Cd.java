package pl.hamerhed.domain.media;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
class Cd implements Disc {
	private String artist;
	private String name;
	private List<String> tracks;
	
	public Cd(String artist, String name, List<String> tracks) {
		this.artist = artist;
		this.name = name;
		this.tracks = tracks;
	}
	
	public String play(int no) {
		return tracks.get(no);
	}

	public int getTracksNumber() {
		return tracks.size();
	}
}
