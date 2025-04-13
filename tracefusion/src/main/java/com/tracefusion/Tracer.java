package com.tracefusion;

public interface Tracer {
	TraceSpan startSpan(String operation);
	void endSpan(TraceSpan span);
	void sendSpan(TraceSpan span);

}
