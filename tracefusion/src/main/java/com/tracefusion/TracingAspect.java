package com.tracefusion;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class TracingAspect {
	private final Tracer tracer;

	public TracingAspect(Tracer tracer) {

		this.tracer = tracer;
	}

	@Around("@annotaion(org.springframework.web.bind.annotation.RequestMapping)")
	public Object traceEndpoint(ProceedingJoinPoint joinPoint) throws Throwable {

		TraceSpan span = tracer.startSpan(joinPoint.getSignature().toShortString());
		try {

			Object result = joinPoint.proceed();
			span.addTag("http.status", "200");
			span.addContext("result", result);

			return result;
		} catch (Exception e) {
			span.addTag("http.sttus", "500");
			span.addContext("error", e.getMessage());
			throw e;
		} finally {

			tracer.endSpan(span);
		}

	}

}
