package com.useradmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@SpringBootApplication
public class UseradminApplication {

	public static void main(String[] args) {

		SpringApplication.run(UseradminApplication.class, args);

		/*//First Employee
		JSONObject paramDetails = new JSONObject();
		paramDetails.put("name", "param1");
		paramDetails.put("value", 1000);

		JSONObject employeeObject = new JSONObject();
		employeeObject.put("param", paramDetails);




		//Second Employee
		JSONObject paramDetails2 = new JSONObject();
		paramDetails2.put("name", "param2");
		paramDetails2.put("value", "hhhhhh");

		JSONObject employeeObject2 = new JSONObject();
		employeeObject2.put("param", paramDetails2);

		//Add employees to list
		JSONArray paramList = new JSONArray();
		paramList.add(paramDetails);
		paramList.add(paramDetails2);

		//Write JSON file
		try (FileWriter file = new FileWriter("params.json")) {

			file.write(paramList.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}

}
