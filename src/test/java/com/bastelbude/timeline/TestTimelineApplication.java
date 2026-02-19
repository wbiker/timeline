package com.bastelbude.timeline;

import org.springframework.boot.SpringApplication;

public class TestTimelineApplication {

	public static void main(String[] args) {
		SpringApplication.from(TimelineApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
