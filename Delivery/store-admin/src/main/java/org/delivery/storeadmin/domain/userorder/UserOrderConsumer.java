package org.delivery.storeadmin.domain.userorder;

import org.pre.common.message.model.UserOrderMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class UserOrderConsumer {

	// Consumer 는 queue,exchange 가 만들어져 있기 때문에 연결만 해준다.
	@RabbitListener(queues = "delivery.queue") // 미리 설정해둔 Queue 로 받아온다고 설정
	public void userOrderConsumer(UserOrderMessage userOrderMessage) {
		log.info("Message Queue : UserMessage[{}]",userOrderMessage.getUserOrderId());
	}
}
