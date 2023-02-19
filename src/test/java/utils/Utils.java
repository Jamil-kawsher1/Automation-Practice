package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;

public class Utils {
    public static void doScroll(WebDriver driver){
                JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }
    public static JSONObject loadJSONFile(String fileLocation) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileLocation));
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject;

    }
}
