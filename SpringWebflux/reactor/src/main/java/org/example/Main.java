package org.example;

import org.example.flux.Publisher;

public class Main {

	public static void main (String[] args) {

	var publisher = new Publisher();
		publisher.startFlux()
				.subscribe(System.out::println);

		System.out.println("[mono]");
		publisher.startMono().subscribe();

		System.out.println("[empty]");
		publisher.startMono2().subscribe();


		System.out.println("Hello Webflux");
	}

}