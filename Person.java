package source;

public abstract class Person
{
	protected String firstName, lastName;
	protected int id;
	
	public Person(){}
	
	public Person(int idIn,String firstNameIn, String lastNameIn)
	{
		id = idIn;
		firstName = firstNameIn;
		lastName = lastNameIn;
	}
	
	//==============GETTERS===========
	
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
		
	//============SETTERS============
		
		public void setFirstName(String firstName)
		{
			this.firstName =firstName;
		}
	
		public void setID(String firstName)
		{
			this.firstName =firstName;
		}
		
		public void setLastName(String lastName)
		{
			this.lastName = lastName;
		}
		
	//=================================
		
		
		public abstract String toString();
	
}
