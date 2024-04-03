package datatype;

import java.util.HashMap;
import java.util.List;

import redis.clients.jedis.JedisPool;

public class RedisSortedSet {
	public static void main(String[] args) {
		try (JedisPool jedisPool = new JedisPool("127.0.0.1", 6379)) {
			try(var jedis = jedisPool.getResource()) {
				// sorted set
				HashMap<String, Double> scores = new HashMap<>();
				scores.put("user1",100.0);
				scores.put("user2",200.0);
				scores.put("user3",300.0);
				scores.put("user4",400.0);
				scores.put("user5",500.0);

				jedis.zadd("game2:scores",scores);

				List<String> list = jedis.zrange("game2:score",0,Long.MAX_VALUE);
				list.forEach(System.out::println);

				System.out.println("hi");

			}
		}
	}

}
