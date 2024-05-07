package org.example.api.domain.userorder.controller.model;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserOrderRequest {

	// 주문
	// 특정 사용자가, 특정 메뉴를 주문
	// 특정 사용자 = 로그인된 세션에 들어있는 사용자
	// 여러 메뉴 id

	@NotNull
	private List<Long> storeMenuIdList;

}
