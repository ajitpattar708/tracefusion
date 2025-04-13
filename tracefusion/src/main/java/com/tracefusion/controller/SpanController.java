package com.tracefusion.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.tracefusion.TraceSpan;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SpanController {

	private final List<TraceSpan> spans = Collections.synchronizedList(new ArrayList<TraceSpan>());

	@PostMapping("/spans")
	ResponseEntity<Void> recieveSpan(@RequestBody TraceSpan span) {
		spans.add(span);
		log.info("span recieved : " + span.toJson());
		return ResponseEntity.accepted().build();

	}

	@GetMapping("/traces")
		public List<TraceSpan> getTraces()
	{
		return spans;
	}

}
