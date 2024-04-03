package datatype;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisList {
	public static void main(String[] args) {
		System.out.println("Hello Redis - List");

		try(JedisPool jedisPool = new JedisPool("127.0.0.1", 6379)) {
			try(Jedis jedis = jedisPool.getResource()) {

				// stack
				jedis.rpush("stack1","aaaa");
				jedis.rpush("stack1","bbbb");
				jedis.rpush("stack1","ccc");

				List<String> stack1 = jedis.lrange("stack1", 0, -1);
				stack1.forEach(System.out::println);

				System.out.println(jedis.rpop("stack1"));
				System.out.println(jedis.rpop("stack1"));
				System.out.println(jedis.rpop("stack1"));

				System.out.println();

				// queue
				jedis.rpush("queue2","zzzz");
				jedis.rpush("queue2","aaaa");
				jedis.rpush("queue2","bbbb");

				System.out.println(jedis.lpop("queue2"));
				System.out.println(jedis.lpop("queue2"));
				System.out.println(jedis.lpop("queue2"));
				System.out.println();

				// block -brpop , blpop
				while (true) {
					List<String> blpop = jedis.blpop(5, "queue:blocking");
					if (blpop != null) {
						blpop.forEach(System.out::println);
					}
				}

			}
		}
	}

}
