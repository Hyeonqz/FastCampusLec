package datatype;

import java.util.List;

import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.args.GeoUnit;
import redis.clients.jedis.resps.GeoRadiusResponse;

public class RedisGeospatial {
	public static void main(String[] args) {
		try (JedisPool jedisPool = new JedisPool("127.0.0.1", 6379)) {
			try(var jedis = jedisPool.getResource()) {
				// geo add
				jedis.geoadd("stores:2geo",127.01112324124,37.5161356324,"some1");
				jedis.geoadd("stores:2geo",127.01112324224,37.5161356424,"some2");

				// geo dist
				Double geodist = jedis.geodist("stores:2geo", "some1", "some2");
				System.out.println(geodist);

				// geo search
				List<GeoRadiusResponse> geosearch = jedis.geosearch(
					"stores:2geo", new GeoCoordinate(127.011, 37.516)
					, 100, GeoUnit.M);

				geosearch.forEach(response -> {
					System.out.println(response.getMemberByString());
				});

			}
		}
	}

}
