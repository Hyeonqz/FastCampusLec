package others_api.open_api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherExample {
	public static void main(String[] args) {
		String apiKey = "bc8bfa54438f80fc6ad4d70b7f62de42";
		String city = "Seoul";
		String urlString =
			"https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";

		try {
			URL url = new URL(urlString);
			HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty("Accept", "application/json");
			int responseCode = httpURLConnection.getResponseCode();

			if (responseCode == 200) {
				BufferedReader bf = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
				String inputLine = "";
				StringBuffer content = new StringBuffer();

				while ((inputLine = bf.readLine()) != null) {
					content.append(inputLine);
				}

				bf.close();
				System.out.println(content.toString());

				JsonObject weatherData = JsonParser.parseString(content.toString()).getAsJsonObject();
				JsonObject mainData = weatherData.getAsJsonObject("main");

				double temp = mainData.get("temp").getAsDouble();

				System.out.println("서울의 온도 : " + temp);
				httpURLConnection.disconnect();
			} else {
				System.out.println("API 요청이 실패했습니다. 응답 코드: " + responseCode);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
