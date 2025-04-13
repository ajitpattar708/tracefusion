package com.tracefusion;


import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
public class TracingAspectTest {
	
	
	
	@Test
	public void testTracingAspect() {
		SpanSender mockSender = span ->assertEquals("200", span.g)
		
	}

}
