import java.util.ArrayList;

public class DataBase {
     private ArrayList<Person> person;    
    
     public DataBase( ArrayList<Person> ArrPerson) {
 		this.person = ArrPerson;
 	}       

	public ArrayList<Person> getPerson(){
    	 return this.person;
     } 

	    
     public void printDatabase(){  	
    	 System.out.println(" ");
    	 System.out.println("All people information" + "\n" +
                             "\n" + this.person );	 
    	 
    	 
     }

     
  
     
     
}