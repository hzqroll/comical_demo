package com.roll.comical.console.business.splider;


import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author zongqiang.hao
 */
public class TestJsoup {
	public static void main(String args[]) throws IOException {
		Document doc ;
		doc = Jsoup.connect("http://www.cnblogs.com/zyw-205520/archive/2012/12/20/2826402.html").get();
		Elements ListDiv = doc.getElementsByAttributeValue("class","postBody");
		for (Element element :ListDiv) {
			System.out.println(element.html());
		}
	}
}
