package com.tracefusion.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tracefusion.DefaultTracer;
import com.tracefusion.HttpSpanSender;
import com.tracefusion.Tracer;

@Configuration
public class TraceFusionConfig {

	@Bean
	public Tracer tracer() {
		return new DefaultTracer("sample-app", new HttpSpanSender("http://localhost:9000"));
	}
}
