package org.pre.common.message.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class UserOrderMessage {
	// API 서버와 가맹점 서버가 공유할 같은 객체
	// API 서버도 이 객체 참조하고, 가맹점 서버도 이 객체를 참조한다.
	// 객체 공유를 하지않는다면, 메시지 표준을 정해야 한다.
	private Long userOrderId;
}
