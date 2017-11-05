package com.gitspringboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:scheduler.properties")
public class SchedulerProperties {

	@Value("${ninty-Days}")
	private long nintyDays;

	public long getNintyDays() {
		return nintyDays;
	}

	public void setNintyDays(long nintyDays) {
		this.nintyDays = nintyDays;
	}
	
	
}
