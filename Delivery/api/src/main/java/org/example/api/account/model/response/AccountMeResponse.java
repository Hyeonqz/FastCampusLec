package org.example.api.account.model.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountMeResponse {

	private String email;
	private String name;
	private LocalDateTime registeredAt;
}
