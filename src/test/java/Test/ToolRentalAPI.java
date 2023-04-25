package Test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

//import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.response.ValidatableResponse;
import files.BaseClass;

public class ToolRentalAPI extends BaseClass {

	@Test
	public void getStatus() {

        baseUrl("https://simple-tool-rental-api.glitch.me");
		given().log().all().when().get("Status").then().log().all().assertThat().statusCode(200);

		
	}

	@Test
	public void getTools() {

        baseUrl("https://simple-tool-rental-api.glitch.me");

		given().log().all().when().get("tools").then().log().all().assertThat().statusCode(200);

	}

	@Test
	public void getResult() {

        baseUrl("https://simple-tool-rental-api.glitch.me");

		given().log().all().queryParam("results", "sdssd").queryParam("category", "plumbing")
				.header("Connection", "keep-alive").when().get("tools").then().log().all().assertThat().statusCode(200);

	}

	
	@Test(enabled = false)
	public void getResultsWithPathVariable() {

        baseUrl("https://simple-tool-rental-api.glitch.me");

		given().log().all().pathParam("toolId", "2177")
				.header("Connection", "keep-alive").when().get("tools/:toolId?user-manual=true").then().log().all().assertThat().statusCode(200);

	}
	
	@Test(enabled = false)
	public void registerNewUser() {
		
        baseUrl("https://simple-tool-rental-api.glitch.me");
       
		 String response = given().log().all().headers("Content-Type","application/json").body(BaseClass.body()).
		 when().post("api-clients")
		 .then().log().all().assertThat().statusCode(201).extract().response().asString();
		 
		 System.out.println(response);
		 
		 JsonPath js=new JsonPath(response);
		 String string = js.getString("accessToken");
		 System.out.println(string);
		 
		
		
	}

	
	@Test
	public void complexParse() {
		
		JsonPath js=new JsonPath(BaseClass.payLoad());
		int courses = js.getInt("courses.size()");
		System.out.println("Courses...."+courses);
		
	    int purchase = js.getInt("dashboard.purchaseAmount");
	    System.out.println("Purchase Amount " +purchase);
	    
	    String website = js.get("dashboard.website");
	    System.out.println("Website Name  "+website);
	    
	   for (int i = 0; i < courses; i++) {
		   
		   String AllTitleCourses = js.get("courses["+i+"].title");
		   int AllPriceCourses = js.get("courses["+i+"].price");
		   int AllCoipesCourses = js.get("courses["+i+"].copies");
		   int j = 1 + i;
		   System.out.println("Title "+ j +" ..." +AllTitleCourses+"\n"+"Price..." +AllPriceCourses+"\n"+"Copies...." +AllCoipesCourses );
		   
	}
	    
	}
	
	@Test(enabled = false)
	public void updateOrder() {
		
		baseUrl("https://simple-tool-rental-api.glitch.me");
		
		String Res = given().header("Content-Type", "application/json").headers("Authorization", "982331da4d0a39a4409c79a34bc29156450d44b6eed3a4f3f964138a08e5a6af")
		.body("{\r\n"
				+ "    \r\n"
				+ "   \r\n"
				+ "    \"customerName\": \"Ossie\",\r\n"
				+ "    \"comment\": \"r created\"\r\n"
				+ "    \r\n"
				+ "   \r\n"
				+ "}")
		.when().patch("/orders/irzE8Yj1-g_ySS01KvYK_")
		.then().log().all().statusCode(204).extract().response().asString();
		System.out.println(Res);
		
	}
	
}
