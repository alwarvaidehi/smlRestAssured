package restassuredPetScripts;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

public class Script001PostMethod {
	@Test
	public void postmethod()
	{
	//HashMap<String, String> map=new HashMap<String, String>();
	//map.put("id", "233");
	JSONObject body=new JSONObject();
	body.put("id", "233");
	RestAssured.given()
	.baseUri("https://petstore.swagger.io/v2/pet")
	//.basePath("/v2/pet")
	.contentType("application/json")
	.body(body.toString())
	.when()
	.post()
	.then().log().all()
	.statusLine("HTTP/1.1 200 OK");
	}
	@Test
	public void get_call()
	{
		String petid="/v2/pet/106";
		RestAssured
		.given()
		.baseUri("https://petstore.swagger.io")
	    .basePath(petid)
		.when().get()
		.then()
		.statusCode(200) 
		//.body("Category", hasKey("id"))
		.body("tags[0]", hasKey("name"))
		.body("status",Matchers.equalTo("available"))
		
		// this method validate if the response status code is 200 or not
		.log().all();
		//https://petstore.swagger.io/v2/pet/2003
	}
}