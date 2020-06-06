package com.useradmin.controller;

import com.useradmin.models.Parameters;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/parameters")
public class ParametersController {

    @GetMapping
    public Object getParameters() {
        System.out.println("-------------------------- getParameters -----------------");
        JSONParser jsonParser = new JSONParser();
        JSONArray parameterList = null;

        try (FileReader reader = new FileReader("parameters.json")) {
            Object obj = jsonParser.parse(reader);
            parameterList = (JSONArray) obj;
            //employeeList.forEach(emp -> parseEmployeeObject((JSONObject) emp));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parameterList;
    }


    /*private static void parseEmployeeObject(JSONObject employee) {
        JSONObject employeeObject = (JSONObject) employee.get("param");
        String firstName = (String) employeeObject.get("name");
        String lastName = (String) employeeObject.get("value");
    }*/
}
