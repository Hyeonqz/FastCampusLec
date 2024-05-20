package org.example.api.domain.userorder.producer;

import org.example.api.common.rabbitmq.Producer;
import org.example.db.userorder.UserOrderEntity;
import org.pre.common.message.model.UserOrderMessage;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserOrderProducer {
	private final Producer producer;

	// exchange 를 미리 설정해 둔다.
	private static final String EXCHANGE = "delivery.exchange";

	// route_key 또한 미리 설정을 해둔다.
	private static final String ROUTE_KEY = "delivery.key";

	// 주문을 보낸다
	public void sendOrder(UserOrderEntity userOrderEntity) {
		this.sendOrder(userOrderEntity.getId());
	}

	public void sendOrder(Long userOrderId) {
		var message = UserOrderMessage.builder()
			.userOrderId(userOrderId)
			.build();
		// 파라미터에 알맞는 값을 대입하여 메세지를 보낸다.
		producer.producer(EXCHANGE, ROUTE_KEY, message);
	}
}
