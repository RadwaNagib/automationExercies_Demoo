package org.automationexerciestest.Utilities;


import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


import java.io.FileReader;

public class DataUtility {


    public final static String Test_Data="src/main/resources/test-data/";

    //TODO: Read data from json file
    public static String getJsonData(String jsonFilename, String field) {
        try {
            // Define object of file Reader
            FileReader reader = new FileReader(Test_Data + jsonFilename + ".json");
            // Parse the JSON directly into a JsonElement
            JsonElement jsonElement = JsonParser.parseReader(reader);
            return jsonElement.getAsJsonObject().get(field).getAsString();
        } catch (Exception e) {
            System.out.println("error on getting data from test-data file");;
        }
        return "";
    }


}
