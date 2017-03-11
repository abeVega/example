import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ReadID {

	public static void main(String[] args) throws IOException {

		 List<String> list = new ArrayList<String>(); 
		    List<String> id = new ArrayList<String>();
		    File file = new File("id.txt");
		    if(file.exists()){
		        try { 
		            list = Files.readAllLines(file.toPath(),Charset.defaultCharset());
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
		     
		    }
		    for(String line : list){
		        String [] res = line.split(",");
		        id.add(res[1]);
		        
		    }
		    
		    List<Integer> listID = new ArrayList<Integer>();
		    for(String s : id){
		    	listID.add(Integer.valueOf(s));
		    }

		    
		    
		    int[] numb = {34844, 28745, 44127};
		    List<Integer> intCheckList = new ArrayList<Integer>();
		    for (int i = 0; i < numb.length; i++){
		    	intCheckList.add(numb[i]);
		    }
		    
		   
		    
		    // check id 
//		    int count = 1;
//		    for(int i =0; i < id.size();i++){
//		   
//		    
//		    System.out.print("ID " + count + " : ");
//		    
//		    System.out.print( id.get(i));
//		    System.out.println( "");
//		    count++;
//		    }
		    
		    List<Integer> acceptID = new ArrayList<Integer>();
		    for(int i =0; i < listID.size();i++){
		    	if( listID.get(i).equals(intCheckList.get(i))){
		    		System.out.println("This id is acceptable " +  listID.get(i));
		    		acceptID.add(numb[i]);
		    	}
		    	
		    	else{
		    		System.out.println("Error ! " + " This id is not acceptable " + id.get(i));
		    	}		    	
		    }
		    for(int i =0; i < acceptID.size();i++){
		    	System.out.println("List of IDs that acceptable " + id.get(i));
		    }
		    
				   
	}

}
