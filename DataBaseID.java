import java.util.ArrayList;

public class DataBaseID {
     private ArrayList<BlackList> bl;    
    
     public DataBaseID( ArrayList<BlackList> bl) {
 		this.bl = bl;
 	}       

	public ArrayList<BlackList> getBL(){
    	 return this.bl;
     }       

	    
     public void printDatabase(){  	
    	 System.out.println(" ");
    	 System.out.println("All BlackList IDs" + "\n" +
                             "\n" + this.bl + "\n" );	 
    	 
    	 
     }

     
  
     
     
}