package pl.hamerhed.aspects.simple;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.hamerhed.domain.media.MediaPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {AlbumsDedicatedAspectsConfig.class})
public class AlbumsDedicatedAspectsTest {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private MediaPlayer warEternalPlayer;
	
	@Autowired
	private MediaPlayer khaosLegionsPlayer;
	
	@Rule
	public final SystemOutRule out = new SystemOutRule().enableLog();
	
	@Before
	public void setUp() {
		out.clearLog();
	}
	
	@Test
	public void printBeans() throws Exception {
		String[] names = applicationContext.getBeanDefinitionNames();
		for (String name : names) {
			System.out.println("bean=" + name);
		}
	}
	
	@Test
	public void testWarEternalDedicatedAspect() throws Exception {
		assertNotNull(warEternalPlayer);
		warEternalPlayer.playAll();
		
		StringBuilder builder = new StringBuilder();
		builder.append("War eternal album begins\n")
		.append("play track1\n").append("play track2\n")
		.append("End of war eternal album\n");
		assertEquals(builder.toString(), out.getLogWithNormalizedLineSeparator());
	}
	
	@Test
	public void testKhaosLegionsDedicatedAspect() throws Exception {
		assertNotNull(khaosLegionsPlayer);
		khaosLegionsPlayer.playAll();
		
		StringBuilder builder = new StringBuilder();
		builder.append("Khaos legions album begins\n")
		.append("play kltrack1\n").append("play kltrack2\n")
		.append("End of Khaos legions album\n");
		assertEquals(builder.toString(), out.getLogWithNormalizedLineSeparator());
	}
}
