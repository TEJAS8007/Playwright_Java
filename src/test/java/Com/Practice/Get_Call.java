package Com.Practice;


import java.io.IOException;
import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.HttpHeader;


public class Get_Call {


	Playwright playwright;
	APIRequest request;
	APIRequestContext context;
	
	@BeforeSuite
	public void setup() {
		playwright=Playwright.create();
		request= playwright.request();
		context=request.newContext();
	}
	
	@Test
	public void popupTest() {
		APIResponse res= context.get("https://reqres.in/api/users?page=2");
		
		System.out.println(res.status());
		System.out.println(res.body());
		
		try {
			ObjectMapper obj=new ObjectMapper();
			JsonNode jsonData= obj.readTree(res.body());
			String JsonBody= obj.writerWithDefaultPrettyPrinter().writeValueAsString(jsonData);
			System.out.println(JsonBody);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<HttpHeader> HeaderList= res.headersArray();
		
		for(HttpHeader header :HeaderList) {
			System.out.println(header.name + " : " +header.value);
		}
	}
	
	@AfterTest
	public void tearDown() {
		playwright.close();
	}

}
