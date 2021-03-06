package io.spring.cloud.sleuth.docs.service4;

import java.lang.invoke.MethodHandles;

import brave.Tracer;
import brave.propagation.ExtraFieldPropagation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

	public static void main(String... args) {
		new SpringApplication(Application.class).run(args);
	}
}

@RestController
class Service4Controller {
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	private final Tracer tracer;

	Service4Controller(Tracer tracer) {
		this.tracer = tracer;
	}

	@RequestMapping("/baz")
	public String service4MethodInController() throws InterruptedException {
		Thread.sleep(400);
		log.info("Hello from service4");
		log.info("Service4: Baggage for [key] is [" +ExtraFieldPropagation.get("key") + "]");
		return "Hello from service4";
	}
}