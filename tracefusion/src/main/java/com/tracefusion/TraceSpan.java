package com.tracefusion;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class TraceSpan {
	public TraceSpan(String traceId, String spanId, String parentSpanId, String operation) {

		this.traceId = traceId;
		this.spanId = spanId;
		this.parentSpanId = parentSpanId;
		this.operation = operation;
		this.startTime = System.currentTimeMillis();

		this.tags = new HashMap<>();
		this.context = new HashMap<>();
	}

	private String traceId;
	private String spanId;
	private String parentSpanId;
	private String operation;
	private long startTime;
	private long endTime;
	private Map<String, String> tags;// https.status =200
	private Map<String, Object> context; // eg userId :"123"

	public void end() {

		this.endTime = System.currentTimeMillis();
	}

	public void addContext(String key, Object value) {
		context.put(key, value);

	}

	public void addTag(String key, String value) {
		tags.put(key, value);
	}

	public String toJson() {
		return new Gson().toJson(this);
	}

}
