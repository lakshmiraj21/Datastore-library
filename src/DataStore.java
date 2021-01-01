import fileOperations.CreateData;
import fileOperations.DeleteData;
import fileOperations.ReadData;
import fileOperations.fileStoreUtil;
import org.json.simple.JSONArray;

public class DataStore {
    static DataStore instance = new DataStore();

    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        System.out.println("To Init please Enter the DataStore file Path:");
//        String path = input.nextLine();
//
//        instance.init(path);
    }

    public void init(String path) {
        fileStoreUtil.instance.init(path);
    }

    public static JSONArray createData(String key, JSONArray jsonArray) {
        return CreateData.createData(key, jsonArray);
    }

    public static JSONArray readData(String key) {
        return ReadData.readData(key);
    }

    public static JSONArray deleteData(String key) {
        return DeleteData.deleteData(key);
    }
}
