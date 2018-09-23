package pl.hamerhed.domain.media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
class CdPlayer implements MediaPlayer {

	private Disc disc;
	
	@Autowired
	public CdPlayer(final Disc disc) {
		this.disc = disc;
	}
	
	public void playAll() {
		for(int i = 0; i < disc.getTracksNumber(); i++) {
			System.out.println("play " + disc.play(i));
		}
		
	}

	public void play(int no) {
		System.out.println("play " + disc.play(no));
	}
	


}
