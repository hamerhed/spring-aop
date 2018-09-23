package pl.hamerhed.domain.media;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class PlayerConfiguration {
	
	@Bean
	public Disc warEternalCd() {
		return new Cd("Arch Enemy", "War eternal", Arrays.asList("track1", "track2"));
	}
	
	@Bean
	public Disc khaosLegionsCd() {
		return new Cd("Arch Enemy", "Khaos legions", Arrays.asList("kltrack1", "kltrack2"));
	}
	
	@Bean
	public MediaPlayer warEternalPlayer() {
		return new CdPlayer(warEternalCd());
	}
	
	@Bean
	public MediaPlayer khaosLegionsPlayer() {
		return new CdPlayer(khaosLegionsCd());
	}
}
