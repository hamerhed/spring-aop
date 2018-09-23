package pl.hamerhed.aspects.simple;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
class MessageDisplayer implements IMessageDisplayer {
	
	@Before("execution(* pl.hamerhed.domain.media.MediaPlayer.playAll(..))")
	public void displayBeforeStart() {
		System.out.println("start");
	}

	@Before("execution(* pl.hamerhed.domain.media.Disc.play(int))")
	public void displayInPause( ) {
		System.out.println("next track");
	}
	
	@After("execution(* pl.hamerhed.domain.media.MediaPlayer.playAll(..))")
	public void displayAfterEnd() {
		System.out.println("end of cd");
	}
}

