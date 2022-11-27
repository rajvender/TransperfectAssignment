package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;

import bsh.Parser;

public class Datareader {

	
	public  List<HashMap<String, String>> getJsondatamap() throws IOException, ParseException{
		/*JSONParser parser=new JSONParser();
		FileReader reader=new FileReader("user.dir"+"\\src\\main\\java\\resources\\billingdata.json");
		Object obj=parser.parse(reader);
		JSONObject jsonobj=(JSONObject)obj;
		JSONArray arr=(JSONArray)jsonobj.get("Billinginfo");
		for (int i=0;i<arr.size();i++) {
			JSONObject billinfo=(JSONObject)arr.get(i);
			String Email=(String) billinfo.get("Email");
			String Name=(String) billinfo.get("Name");
			String Address=(String) billinfo.get("Address");
			String Phone=(String) billinfo.get("Phone");
			String CreditCard=(String) billinfo.get("CreditCard");
			String Exp=(String) billinfo.get("Exp");
			String Cvv=(String) billinfo.get("Cvv");*/
		String jsoncontent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\billingdata.json"));
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>() {
	      });
		return data;
	}
	
		
	@DataProvider
	public Object[][] getdata() throws IOException, ParseException{
		List<HashMap<String, String>> lis=getJsondatamap();
		return new Object[][] {{lis.get(0)}};
		
	}
	
}
