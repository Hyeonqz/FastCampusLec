package org.example.webflux.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
@EnableR2dbcAuditing
@EnableR2dbcRepositories
public class R2dbcConfig implements ApplicationListener<ApplicationReadyEvent> {
	// ApplicationReady 가 될 때 핸들러를 달 것이다.
	private final DatabaseClient databaseClient;

	@Override
	public void onApplicationEvent (ApplicationReadyEvent event) {

		// reactor: publisher, subscriber
		databaseClient.sql("SELECT 1").fetch().one()
			.subscribe(
				success -> {
					log.info("Initialize r2dbc database connection.");
				}
			,
			error -> {
				log.error("Failed to initialize r2dbc database connection");
				SpringApplication.exit(event.getApplicationContext(), () -> -110); // 비밀번호가 틀리면 서버가 종료되게 한다.
			}
			);
	}

	@Override
	public boolean supportsAsyncExecution () {
		return ApplicationListener.super.supportsAsyncExecution();
	}

}
