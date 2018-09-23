package pl.hamerhed.aspects.simple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import pl.hamerhed.domain.media.PlayerConfiguration;

@Configuration
@Import(value= {PlayerConfiguration.class})
public class SimpleAspectConfig {
	//important apspects need to be configured as beans otherwise they are invisible
	//can not use the interface as returned object. Aspect need to be an implementation class.
	@Bean
	public MessageDisplayer messageDisplayer() {
		return new MessageDisplayer();
	}
}
