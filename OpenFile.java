import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class OpenFile {

    public static void main(String[] args) throws IOException {

    	  try
          {
              File dir = new File(System.getenv("APPDATA"), "data");
              if (!dir.exists()) dir.mkdirs();
              File file = new File("id.txt");
              if (!file.exists()) System.out.println("File doesn't exist");
              else Desktop.getDesktop().open(file);
          } catch (Exception e)
          {
              e.printStackTrace();
          }
    	  
    	  
    	  
           
         
    }
}