package others_api.gson;

import com.google.gson.Gson;

public class GsonFromJson {
	public static void main(String[] args) {
		String json = "{\"name\":\"홍길동\",\"email\":\"hong@naver.com\",\"age\":25}";

		// json -> Object 로
		Gson gson = new Gson();
		Member fromJson = gson.fromJson(json, Member.class);
		System.out.println(fromJson);
	}
}
