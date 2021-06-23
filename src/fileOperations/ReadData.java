package fileOperations;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadData {
    public static JSONArray readData(String key) {
        String filePath = fileStoreUtil.instance.dataStoreFilePath + "\\" + key + ".txt";
        File keyPath = new File(filePath);

        if (keyPath.exists()) {
            try (FileReader reader = new FileReader(filePath))
            {
                JSONParser jsonParser = new JSONParser();
                Object obj = jsonParser.parse(reader);
                JSONArray data = (JSONArray) obj;

                return data;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            JSONObject result = new JSONObject();
            result.put("error-code", "F201");
            result.put("description", "key not found");
            result.put("result", "Failed");

            JSONArray resultArray = new JSONArray();
            resultArray.add(result);

            return resultArray;
        }

        return null;
    }
}
