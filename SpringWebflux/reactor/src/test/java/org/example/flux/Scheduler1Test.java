package org.example.flux;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import reactor.test.StepVerifier;

class Scheduler1Test {
	private final Scheduler1 scheduler1 = new Scheduler1();

	@Test
	void fluxMapWithSubscribenOn () {
		StepVerifier.create(scheduler1.fluxMapWithSubscribenOn())
			.expectNextCount(10)
			.verifyComplete();
	}

	@Test
	void fluxMapWithPublishOn () {
		StepVerifier.create(scheduler1.fluxMapWithPublishOn())
			.expectNextCount(10)
			.verifyComplete();
	}

}