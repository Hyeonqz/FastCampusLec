package others_api.crawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupEx {
	public static void main(String[] args) {
		String url = "https://sum.su.or.kr:8888/bible/today?base_de=2024-04-02";

		try {
			Document document = Jsoup.connect(url).get();
			Element bibleText = document.getElementById("bible_text");
			Element bibleInfoBox = document.getElementById("bibleinfo_box");

			System.out.println("bibleInfoBox = " + bibleInfoBox.text());
			System.out.println("bibleText = " + bibleText.text());

			Elements num = document.select(".num");
			Elements info = document.select(".info");

			for (int i = 0; i < num.size(); i++) {
				System.out.println(num.get(i).text() + " : " + info.get(i).text());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}
