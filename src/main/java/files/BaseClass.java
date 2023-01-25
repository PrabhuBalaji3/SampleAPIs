package files;

import java.util.Random;

import io.restassured.RestAssured;

public class BaseClass {

	public void baseUrl(String URL) {
		
		RestAssured.baseURI = URL;
	}
	
	public static String body() {
		String name = " abcdefghijklmnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder name1 = new StringBuilder(10);
		for (int i = 0; i < 10; i++) {
			name1.append(name.charAt(rnd.nextInt(name.length())));
		}
	      
		return"{\r\n"
				+ "   \"clientName\": \""+name1+"\",\r\n"
				+ "   \"clientEmail\": \""+name1+"@example.com\"\r\n"
				+ "}";
	}

	
	public static String payLoad() {
		
		return"{\r\n"
				+ "\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\r\n"
				+ "\"website\": \"rahulshettyacademy.com\"\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "\"courses\": [\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\r\n"
				+ "\"price\": 50,\r\n"
				+ "\r\n"
				+ "\"copies\": 6\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\r\n"
				+ "\"price\": 40,\r\n"
				+ "\r\n"
				+ "\"copies\": 4\r\n"
				+ "\r\n"
				+ "},\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\r\n"
				+ "\"price\": 45,\r\n"
				+ "\r\n"
				+ "\"copies\": 10\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "]\r\n"
				+ "\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "";
		
	}
}
