package others_api.gson;

import com.google.gson.Gson;

public class GsonToJson {
	public static void main(String[] args) {
		Member vo = new Member("홍길동", "hong@naver.com", 25);
		Gson gson = new Gson();
		String json = gson.toJson(vo);
		System.out.println(vo.toString());
		System.out.println(json);
		System.out.println(gson.toString());
	}
}
