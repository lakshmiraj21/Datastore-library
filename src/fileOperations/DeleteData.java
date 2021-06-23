package fileOperations;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;

public class DeleteData {
    public static JSONArray deleteData(String key) {
        String filePath = fileStoreUtil.instance.dataStoreFilePath + "\\" + key + ".txt";
        File keyPath = new File(filePath);
        JSONObject result = new JSONObject();

        if (keyPath.exists()) {
            keyPath.delete();
            fileStoreUtil.instance.updateDataStoreInfo();

            result.put("result", "success");
        } else {
            result.put("description", "key not found");
            result.put("error-code", "F301");
            result.put("result", "Failed");
        }

        JSONArray resultArray = new JSONArray();
        resultArray.add(result);

        return resultArray;
    }
}
