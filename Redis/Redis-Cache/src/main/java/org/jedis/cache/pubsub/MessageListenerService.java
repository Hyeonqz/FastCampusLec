package org.jedis.cache.pubsub;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MessageListenerService implements MessageListener {

	@Override
	public void onMessage(Message message, byte[] pattern) {
		log.info("Received : {} channel : {}", message.getBody(), message.getChannel());
	}

}
