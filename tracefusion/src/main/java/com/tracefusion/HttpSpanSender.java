package com.tracefusion;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class HttpSpanSender implements  SpanSender{
	
	private final HttpClient client  = HttpClient.newHttpClient();
	private final String collectorUrl;

	public HttpSpanSender(String collectorUrl) {
	
		this.collectorUrl = collectorUrl;
	}

	@Override
	public void send(TraceSpan span) {
	   HttpRequest request =  HttpRequest.newBuilder()
	    .uri(URI.create(collectorUrl+ "/spans"))
	    .header("Content-Type", "application/json")
	    .POST(HttpRequest.BodyPublishers.ofString(span.toJson()))
	    .build();
	    
	    client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
		
	}

}
