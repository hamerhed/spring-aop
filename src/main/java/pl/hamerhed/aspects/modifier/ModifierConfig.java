package pl.hamerhed.aspects.modifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ModifierConfig {

	@Bean
	public Converter countriesConverter() {
		return new CountiresConverter();
	}
	@Bean
	public InputParamsModifier paramsModifier() {
		return new InputParamsModifier();
	}
}
