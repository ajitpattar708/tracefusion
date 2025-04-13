package com.tracefusion;

import java.util.UUID;

public class DefaultTracer implements Tracer {

	private final String serviceName;

	private final SpanSender sender;

	public DefaultTracer(String serviceName, SpanSender sender) {

		this.serviceName = serviceName;
		this.sender = sender;
	}

	@Override
	public TraceSpan startSpan(String operation) {
		String traceId = UUID.randomUUID().toString(); // simplified // use thread-local for apps
		String spanId = UUID.randomUUID().toString();
		return new TraceSpan(traceId, spanId, null, serviceName + ":" + operation);
	}

	@Override
	public void endSpan(TraceSpan span) {
		span.end();
		sendSpan(span);

	}

	@Override
	public void sendSpan(TraceSpan span) {
		sender.send(span);

	}

}
