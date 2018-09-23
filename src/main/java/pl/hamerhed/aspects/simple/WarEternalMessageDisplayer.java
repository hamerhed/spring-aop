package pl.hamerhed.aspects.simple;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class WarEternalMessageDisplayer implements IMessageDisplayer {
																					
	//remember use '&&' when combine conditions
	//works correctly
	@Pointcut("execution(* pl.hamerhed.domain.media.MediaPlayer.playAll()) && bean(warEternalPlayer)")
	//do not work
	//@Pointcut("execution(* pl.hamerhed.domain.media.MediaPlayer.playAll()) and bean(warEternalPlayer)")
	public void playAllForWarEternal() {} 
	
	//works correctly
	//@Before("execution(* pl.hamerhed.domain.media.MediaPlayer.playAll()) && bean(warEternalPlayer)")
	//works correctly too
	//@Before("execution(* pl.hamerhed.domain.media.MediaPlayer.playAll()) and bean(warEternalPlayer)")
	@Before("playAllForWarEternal()")
	public void displayBeforeStart() {
		System.out.println("War eternal album begins");
	}

	public void displayInPause() {
		System.out.println("");
		
	}

	@After("execution(* pl.hamerhed.domain.media.MediaPlayer.playAll(..)) and bean(warEternalPlayer)")
	public void displayAfterEnd() {
		System.out.println("End of war eternal album");
		
	}

}
