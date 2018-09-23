package pl.hamerhed.aspects.simple;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class KhaosLegionsMessageDisplayer implements IMessageDisplayer {

	//bean name or id cannot have quotes
	@Before("execution(* pl.hamerhed.domain.media.MediaPlayer.playAll()) && bean(khaosLegionsPlayer)")
	public void displayBeforeStart() {
		System.out.println("Khaos legions album begins");
	}

	public void displayInPause() {
				
	}

	@After("execution(* pl.hamerhed.domain.media.MediaPlayer.playAll()) and bean(khaosLegionsPlayer)")
	public void displayAfterEnd() {
		System.out.println("End of Khaos legions album");
	}

}
