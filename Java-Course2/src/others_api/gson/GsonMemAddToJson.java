package others_api.gson;

import com.google.gson.Gson;

public class GsonMemAddToJson {
	public static void main(String[] args) {
		Address address = new Address("서울", "대한민국");
		Person person = new Person("홍길동", 30, "hong@google.com", address);

		Gson gson = new Gson();
		String json = gson.toJson(person);
		System.out.println(json.toString());
		System.out.println();

		String fromJson = "{\"name\":\"홍길동\",\"age\":30,\"email\":\"hong@google.com\",\"address\":{\"city\":\"서울\",\"country\":\"대한민국\"}}";

		Member member = gson.fromJson(fromJson, Member.class);
		Person person1 = gson.fromJson(fromJson, Person.class);
		System.out.println(person1.toString());
		System.out.println(member.toString());
	}
}
