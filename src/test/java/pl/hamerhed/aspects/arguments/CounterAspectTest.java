package pl.hamerhed.aspects.arguments;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.hamerhed.domain.media.MediaPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:pl/hamerhed/aspects/arguments/counter_aspects_config.xml"})
public class CounterAspectTest {

	@Autowired
	private MediaPlayer warEternalPlayer;
	
	@Autowired
	private MediaPlayer khaosLegionsPlayer;
	
	@Autowired
	private ArgumentsModifierAspect counter;
	
	
	@Test
	public void testCountingAspect() throws Exception {
		assertNotNull(warEternalPlayer);
		assertNotNull(khaosLegionsPlayer);
		assertNotNull(counter);
		
		warEternalPlayer.playAll();
		khaosLegionsPlayer.playAll();
		
		assertEquals(2, counter.getPlayAllCounter());
		
		warEternalPlayer.playAll();
		assertEquals(3, counter.getPlayAllCounter());
		
		warEternalPlayer.play(0);
		warEternalPlayer.play(0);
		khaosLegionsPlayer.play(0);
		khaosLegionsPlayer.play(1);
		
		assertEquals(10, counter.getPlayTrackCounter());
		
	}
}
