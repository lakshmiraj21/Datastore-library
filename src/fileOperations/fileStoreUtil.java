package fileOperations;

import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class fileStoreUtil {
    public static fileStoreUtil instance = new fileStoreUtil();
    public String dataStoreFilePath;

    public void init(String path) {
        if (path.isEmpty()) {
            path = "DataStore\\";
        } else {
            if (path.charAt(path.length() - 1) != '\\')  {
                path = path + "\\";
            }

            path = path + "DataStore";
        }

        File dataStoreDirectoryPath = new File(path);

        if (!dataStoreDirectoryPath.exists()) {
            boolean bool = dataStoreDirectoryPath.mkdir();

            if(bool) {
                System.out.println("Directory created successfully");
            } else {
                System.out.println("Sorry couldn’t create specified directory");
            }
        }

        dataStoreFilePath = path;
        updateDataStoreInfo();
    }

    public long folderSize(File directory) {
        long length = 0;

        if (directory.listFiles() != null) {
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    System.out.println("Not inside folder size");

                    length += file.length();
                } else {
                    System.out.println("inside folder size" + file.getName());
                    length += folderSize(file);
                }
            }
        }

        return length;
    }

    public void updateDataStoreInfo() {
        try (FileWriter file = new FileWriter("src\\LocationInfo.json")) {
            JSONObject locationObject = new JSONObject();
            File dataStorePath = new File(dataStoreFilePath);
            locationObject.put("location", dataStoreFilePath);
            locationObject.put("size", folderSize(new File(dataStoreFilePath)));

            file.write(locationObject.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
