package org.example.flux;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Operator3 {
	// 집계 연산
	// count
	public Mono<Long> fluxCount() {
		return Flux.range(1,10).count().log();
	}

	// distinct
	public Flux<String> fluxDistinct() {
		return Flux.fromIterable(List.of("a","b","c","d","a","b"))
			.distinct()
			.log();
	}

	// reduce
	public Mono<Integer> findReduce() {
		return Flux.range(1,10)
			.reduce( (i,j) -> i+j)
			.log();
	}

	// groupby
	public Flux<Integer> fluxGroupBy() {
		return Flux.range(1,10)
			.groupBy( i -> (i%2==0) ? "even":"odd")
			.flatMap(group -> group.reduce( (i,j) -> i+j))
			.log();
	}

}
