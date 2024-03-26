package generic;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import collection.Movie;

public class GenericTest {
	public static void main(String[] args) {
		ObjectArray<String> array = new ObjectArray<>(5);
		array.set(0, "hello");
		array.set(1, " world");

		ObjectArray<Movie> movie = new ObjectArray<Movie>(5);

		Map<String, Integer> maps = new HashMap<>();
		maps.put("korea", 100);
		maps.put("english", 99);
		maps.put("chinese", 10);
		maps.put("japanese", 87);

		System.out.println(maps.get("korea"));

		Map<String, Integer> table = new Hashtable<>();
		table.put("korea", 100);
		System.out.println(table.get("korea"));

	}
}
