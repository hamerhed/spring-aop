package pl.hamerhed.aspects.counter;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//@Aspect
public class ArgumentsModifierAspect {
	private int counterPlayAll = 0;
	private int counterPlayedTracks = 0;
	
	public void increaseTracksCouner() {
		counterPlayedTracks++;
	}
	
	private void increaseCounter() {
		counterPlayAll++;
	}
	
	public int getPlayAllCounter() {
		return counterPlayAll;
	}
	
	public int getPlayTrackCounter() {
		return counterPlayedTracks;
	}
	
	//@Before("execution(void pl.hamerhed.domain.media.MediaPlayer.playAll(..))")
	public void countPlayAllCall() {
		increaseCounter();
	}
	
	//@Before("execution(* pl.hamerhed.domain.media.Disc.play(int))")
	public void countPlayTrackCall() {
		increaseTracksCouner();
	}
}
