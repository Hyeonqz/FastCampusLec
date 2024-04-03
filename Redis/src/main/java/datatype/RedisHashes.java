package datatype;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.JedisPool;

public class RedisHashes {

	public static void main(String[] args) {
		try (JedisPool jedisPool = new JedisPool("127.0.0.1", 6379)) {
			try(var jedis = jedisPool.getResource()) {
				// Hash
				long hset = jedis.hset("users:2:info","name","kkyu");

				HashMap<String, String> usersInfo = new HashMap<>();
				usersInfo.put("email","kyu@naver.com");
				usersInfo.put("phone","010-1234-5678");

				jedis.hset("users:2:info", usersInfo);

				// hdel
				jedis.hdel("users:2:info","phone");

				// get. getall
				System.out.println(jedis.hget("users:2:info","email"));

				Map<String, String> hgetAll = jedis.hgetAll("users:2:info");
				System.out.println(hgetAll);
				hgetAll.forEach( (k,v) -> System.out.printf("%s %s%n",k,v));

				//increment
				jedis.hincrBy("users:2:info","visits",1);
			}
		}
	}

}
