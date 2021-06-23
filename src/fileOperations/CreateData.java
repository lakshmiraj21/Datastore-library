package fileOperations;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateData {
    public static JSONArray createData(String key, JSONArray json) {
        File dataStoreFile = new File(fileStoreUtil.instance.dataStoreFilePath);
        JSONArray resultArray = new JSONArray();
        JSONObject result = new JSONObject();

        float dataStoreSize = fileStoreUtil.instance.folderSize(dataStoreFile);
        dataStoreSize = (dataStoreSize / 1024) + 16;
        dataStoreSize = ((dataStoreSize/1024) / 1024);

        if (dataStoreSize > 2) {
            result.put("description", "Datastore size exceeded 2GB");
            result.put("error-code", "F401");
            result.put("result", "Failed");
        } else if (!dataStoreFile.exists()) {
            result.put("description", "DataStore not found");
            result.put("error-code", "F402");
            result.put("result", "Failed");
        } else {
            try (FileWriter file = new FileWriter(fileStoreUtil.instance.dataStoreFilePath + "\\" + key + ".txt")) {
                float jsonLength = (json.toJSONString().length());

                if ((jsonLength/1024) < 16) {
                    result.put("Result", "Success");
                    file.write(json.toJSONString());
                } else {
                    result.put("description", "JSON size exceeded 16kb");
                    result.put("error-code", "F101");
                    result.put("result", "Failed");
                }

                file.flush();

                resultArray.add(result);
            } catch (IOException e) {
                result.put("description", "Something went wrong!");
                result.put("result", "Failed");
            }
        }

        fileStoreUtil.instance.updateDataStoreInfo();

        return resultArray;
    }
}
