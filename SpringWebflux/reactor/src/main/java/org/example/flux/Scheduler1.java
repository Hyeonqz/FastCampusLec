package org.example.flux;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class Scheduler1 {

	public Flux<Integer> fluxMapWithSubscribenOn() {
		return Flux.range(1,10)
			.map(i -> i*2)
			.subscribeOn(Schedulers.boundedElastic())
			.log();
	}

	public Flux<Integer> fluxMapWithPublishOn() {
		return Flux.range(1,10)
			.map(i -> i*2)
			.log()
			.publishOn(Schedulers.boundedElastic())
			.log()
			.map( i -> i*2);
	}
}
