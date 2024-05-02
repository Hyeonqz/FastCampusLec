package org.example.api.domain.store.controller.model;

import java.math.BigDecimal;

import org.example.db.store.enums.StoreCategory;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StoreRegisterRequest {

	@NotBlank
	private String name;
	@NotBlank // 문자열이면서 null, 빈문자, blank
	private String address;
	@NotNull // null 값이 들어오면 안된다
	private StoreCategory storeCategory;
	@NotBlank
	private String thumbnailUrl;
	@NotNull // 객체 타입은 Not NULL 로 알고 있으면 된다.
	private BigDecimal minimumAmount;
	@NotNull
	private BigDecimal minimumDeliveryAmount;
	@NotBlank
	private String phoneNumber;
}
