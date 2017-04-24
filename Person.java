

public   class Person{
	protected String firstName, lastName;
	protected Integer id;



	public Person(){}
	
	public Person(int id,String firstName, String lastName){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
		public String getFirstName()
		{
			return firstName;
		}
	     public int getID()
		{
			return id;
		}

		public String getLastName()
		{
			return lastName;
		}
		
		
		public void setFirstName(String firstName)
		{
			this.firstName =firstName;
		}
	
		public void setID(Integer id)
		{
			this.id =id;
		}
		
		public void setLastName(String lastName)
		{
			this.lastName = lastName;
		}
		
		public String toString(int a){
			String output= "" ;
		       output +=  "Black ID : " + " " + this.id  ;   
				return output;
		}
		
		 public String toString(){
	    	  String output= "" ;
		       output +=  "ID : " + " " + this.id + "\n" + "First Name : " + this.firstName + "\n" +
		    		   "Last Name : "+" " + this.lastName + "\n"  ;   
				return output;
	    	
	    }
	
}