package datatype;

import java.util.Set;

import redis.clients.jedis.JedisPool;

public class RedisSet {
	public static void main(String[] args) {

		try (JedisPool jedisPool = new JedisPool("127.0.0.1", 6379)) {
			try(var jedis = jedisPool.getResource()) {
				jedis.sadd("users:500:follow", "100","200","300");
				jedis.srem("users:500:follow","100");

				Set<String> smembers = jedis.smembers("users:500:follow");
				smembers.forEach(System.out::println);

				System.out.println(jedis.sismember("users:500:follow","200"));
				System.out.println(jedis.sismember("users:500:follow","120"));

				// s inter
				System.out.println(jedis.scard("users:500:follow"));
				Set<String> sinter = jedis.sinter("users:100:follow");
				System.out.println(sinter.toString());
			}
		}

	}

}
