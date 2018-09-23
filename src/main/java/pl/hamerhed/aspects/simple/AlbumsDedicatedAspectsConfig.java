package pl.hamerhed.aspects.simple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import pl.hamerhed.domain.media.PlayerConfiguration;

@Configuration
@Import(value={PlayerConfiguration.class})
@EnableAspectJAutoProxy
public class AlbumsDedicatedAspectsConfig {
	
	@Bean
	public WarEternalMessageDisplayer warEternalMessageDisplayer() {
		return new WarEternalMessageDisplayer();
	}
	
	@Bean
	public KhaosLegionsMessageDisplayer khaosLegionsMessageDisplayer() {
		return new KhaosLegionsMessageDisplayer();
	}
}
