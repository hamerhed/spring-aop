package pl.hamerhed.aspects.simple;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.hamerhed.domain.media.MediaPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {SimpleAspectConfig.class})
public class SimpleAspectsTest {
	
	@Autowired
	private MediaPlayer khaosLegionsPlayer;
	
	@Autowired
	private MediaPlayer warEternalPlayer;
	
	@Rule
	public final SystemOutRule out = new SystemOutRule().enableLog();
		
	@Before
	public void setUp() {
		out.clearLog();
	}
	
	@Test
	public void testBeforeAspect() throws Exception {
		assertNotNull(khaosLegionsPlayer);
		khaosLegionsPlayer.play(0);
		
		assertEquals("next track\nplay kltrack1\n", out.getLogWithNormalizedLineSeparator());
		out.clearLog();
		khaosLegionsPlayer.play(1);
		assertEquals("next track\nplay kltrack2\n", out.getLogWithNormalizedLineSeparator());
	}
	
	@Test
	public void testAllAspect() throws Exception {
		assertNotNull(khaosLegionsPlayer);
		khaosLegionsPlayer.playAll();
		
		StringBuilder builder = new StringBuilder();
		builder.append("start\n")
		.append("next track\n").append("play kltrack1\n").append("next track\n").append("play kltrack2\n")
		.append("end of cd\n");
		assertEquals(builder.toString(), out.getLogWithNormalizedLineSeparator());
	}
	
	@Test
	public void testwarEternalPlayAllWithAspect() throws Exception {
		assertNotNull(khaosLegionsPlayer);
		warEternalPlayer.playAll();
		
		StringBuilder builder = new StringBuilder();
		builder.append("start\n")
		.append("next track\n").append("play track1\n").append("next track\n").append("play track2\n")
		.append("end of cd\n");
		assertEquals(builder.toString(), out.getLogWithNormalizedLineSeparator());
	}
}
