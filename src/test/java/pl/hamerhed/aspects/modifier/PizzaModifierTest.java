package pl.hamerhed.aspects.modifier;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {PizzaConfig.class})
public class PizzaModifierTest {

	@Autowired
	private Pizza pizzaWithSalami;
	
	@Autowired
	private Pizza pizzaBolonia;
	
	@Test
	public void testPizzaWithSalamiAndCheese() throws Exception {
		assertEquals("pizza with salami and cheese", pizzaWithSalami.getPizza());
	}
	
	@Test
	public void pizzaBoloniaTest() throws Exception {
		assertEquals("bolonia pizza", pizzaBolonia.getPizza());
		
	}
}
