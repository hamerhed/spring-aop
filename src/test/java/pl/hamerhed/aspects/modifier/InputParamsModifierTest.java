package pl.hamerhed.aspects.modifier;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {ModifierConfig.class})
public class InputParamsModifierTest {

	@Autowired
	private Converter converter;
	
	@Test
	public void testModifyingInputParameters() throws Exception {
		Map<String, String> map = converter.getMap(Arrays.asList("Germany", "China", "Croatia"));
		assertEquals(4,  map.size());
		assertTrue(map.containsKey("Poland"));
		assertTrue(map.containsKey("Germany"));
		assertTrue(map.containsKey("China"));
		assertTrue(map.containsKey("Croatia"));
	}
}
