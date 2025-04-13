#TraceFusion -contextual Tracing for java

 Tracefusion is an open-source java library and tool that enhances distributed tracing by
 capturing runtime context(e.g varibles sates, method flows) alongside traditional span data.
 Built for the Java ecosystem, it integrates seamlessly with spring  boot  and can extend to other
 services.
 
 ## Features
 - lightweight tracing with minimal overhead
 - Context-aware debugging (e.g., capture method parameters)
 - Spring Boot auto-instrumentation
 - Pluggable span output (HTTP, logs, etc..)
 -- Basic trace visualizer
 
 
 ## Getting started
 
 ## Prerequisites
 - Java 17+
 - maven 3.6+
 -Optional : Spring boot 3x for integration
 
 
 ## Installation
 1. clone the repo
 ''' bash
  git clone 
  cd tracefusion 
  
  
  2. Build the library
  mvn install
  
  
  Usage
  Add to your maven project
  
  <dependency>
      <groupId>com.tracefusion</groupId>
      <artifactId>tracefusion</artifactId>
      <version>0.0.1-SNAPSHOT</version>
    </dependency>
    java
    
    
  configure in springboot
  
  @Configuration
  public class MyConfig {

	@Bean
	public Tracer tracer() {
		return new DefaultTracer("sample-app", new HttpSpanSender("http://localhost:9000"));
	}


  Run the collector
  java -jar target/tracefusion-0.0.1-SNAPSHOT.jar
  
  
  4. Steps for others to Fork or clone
     1. get the repo
        
          git clone
          cd tracefusion
     2 build and run
        mvn install
        
         java -jar target/tracefusion-0.0.1-SNAPSHOT.jar
         
         
    Fork
       1. Fork on github
         go to  github repo
         clieck "Fork" (top-right) to create copy under your githubacount
         
         
  