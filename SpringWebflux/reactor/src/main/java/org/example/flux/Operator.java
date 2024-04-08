package org.example.flux;

import reactor.core.publisher.Flux;

public class Operator {
	//map
	public Flux<Integer> fluxMap() {
		return Flux.range(1,10) // 1,2,3,4,5,6,7,8,9,10
			.map(i-> i*2) // 2,4,6,8,10,12,14,16,18,20
			.log();
	}

	// filter
	public Flux<Integer> fluxFilter() {
		return Flux.range(1,10)
			.filter(i -> i>5)
			.log();
	}

	// take
	public Flux<Integer> fluxTake() {
		return Flux.range(1,5)
			.take(3)
			.log();
	}

	// flatMap
	public Flux<Integer> fluxFlatMap() {
		return Flux.range(1,9)
			.flatMap(i -> Flux.range(i*10,10))
			.log();
	}

	public Flux<Integer> fluxFlatMap2() {
		return Flux.range(1,9)
			.flatMap(i -> Flux.range(1, 9)
				.map(j -> {
					System.out.printf("%d * %d = %d\n" , i, j, i*j);
					return i*j;
				})
			)
			.log();
	}


}
