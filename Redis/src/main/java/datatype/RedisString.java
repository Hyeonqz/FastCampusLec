package datatype;

import java.util.List;
import java.util.Objects;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

public class RedisString {
	public static void main(String[] args) {

		try (JedisPool jedisPool = new JedisPool("127.0.0.1", 6379)) {
			try(var jedis = jedisPool.getResource()) {
				jedis.set("users:300:email","jin@naver.com");
				jedis.set("users:300:name","jin1234");
				jedis.set("users:300:age","25");

				String email = jedis.get("users:300:email");
				System.out.println(email);

				List<String> list =  jedis.mget(
					 "users:300:email",
							"users:300:name",
							"users:300:age");
				list.forEach(System.out::println);

				long counter = jedis.incr("counter");
				System.out.println("counter : " + counter);

				long counter1 = jedis.incrBy("counter", 10L);
				System.out.println("counter1 : " + counter1);

				long counter2 = jedis.decr("counter");
				System.out.println("counter2 = " + counter2);

				long counter3 = jedis.decrBy("counter", 20L);
				System.out.println("counter3 = " + counter3);

				// 파이프 라인을 사용하여 다수의 명령을 한번에 실행
				Pipeline pipeline = jedis.pipelined();
				pipeline.set("users:400:email","jin@naver.com");
				pipeline.set("users:400:name","jin");
				pipeline.set("users:400:age","25");
				List<Object> objects1 = pipeline.syncAndReturnAll();// 하나의 Redis 로 요청을 하게 됨.
				objects1.forEach( i -> System.out.println(i.toString()));
			}
		}
	}

}
