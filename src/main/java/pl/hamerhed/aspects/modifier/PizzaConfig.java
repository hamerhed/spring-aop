package pl.hamerhed.aspects.modifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class PizzaConfig {
	
	@Bean
	public Pizza pizzaWithSalami() {
		return new Pizza("pizza with salami");
	}
	
	@Bean
	public Pizza pizzaBolonia() {
		return new Pizza("bolonia pizza");
	}
	
	@Bean
	public PizzaModifier pizzaModifier() {
		return new PizzaModifier();
	}
}
