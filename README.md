# Datastore library _Lakshmiraj

Sample Test project to Run this DataStore library: **https://github.com/lakshmiraj21/FW_Lakshmiraj.git**

DataStore project was created as an Library file(jar file). Which can be used in a main projects to store Json datas in local file systems.

The jar file is located in the **Library folder** of the project. Also link of a sample project with these jar file has been mentioned above.

To access the Datastore library import the jar file of these project **FreshWork_Lakshmiraj.jar** to urs from the library folder.

DataStore project consists of 4 types of functionalities.

    - Initializing the DataStore
    - Create option to store data
    - Read option to Read the stored data
    - Delete option to delete the stored data 
    
# 1. Initializing

  Init the data store to access the library with path as parameter for the Local storage folder. If you init it without the param or empty string it will have the default location in your main project folder with the directory name of **DataStore**
  
  **Method:**
    DataStore.instance.init(path);
    
  **Return type:**
    Void
    
  **Param:**
    Path : String eg("" or "c:\Users\Desktop\")
    
# 2. Create Data

  Used to store a **Json array** with key and value. with key as a **string** and value as **Json Array**
  
  **Method:**
    DataStore.createData("key" ,value);
    
  **Return type:**
    Json Array
    
  **Param:**
    key : String
    value : Json Object
    
  **Failure Case:**
    Error Json will be returned with the Description and the error code.
   
   **Error Codes:**
   
   **F101** : **Json size exceeded 16kb**
      Passing Json Array size should not exceed 16kb size.
     
   **F401** : **Datastore size exceeded 2GB**
      Data Store local directory should not exceed 2GB of size.
      
   **F402** : **Datastore directory not found**
      If dataStore directory accidently deleted in between the usage, You will get this error code.
      
 # 3. Read Data
 
   Used to Read the stored **Json array** from the Data store
   
   **Method:** 
    DataStore.readData(key);
    
   **Return type:**
    Json Array
    
   **Param:**
    Key : String
    
   **Failure Case:**
    Error Json will be returned with the Description and the error code.
    
   **Error Codes:**
   
   **F201** : **key not found**
     Passed key is not found on the store Json datas.
     
  # 4. Delete Data
    
   Used to Delete the stored **Json array** from the Data store.
   
   **Method:** 
    DataStore.deleteData(key);
    
   **Return type:**
    Json Array
    
   **Param:**
    Key : String
    
   **Failure Case:**
    Error Json will be returned with the Description and the error code.
    
   **Error Codes:**
   
   **F301** : **key not found**
     Passed key is not found on the store Json datas.
     
     
  # Note:
  
  **Don't use the Create, Read and Delete methods without initialzing the DataStore library using init method mentioned above.**
  **Or else datas won't be stored due to the lack of DataStore**

   

