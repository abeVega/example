package source;

public abstract class Person
{
	protected String firstName, lastName;
	
	public Person(){}
	
	public Person(String firstNameIn, String lastNameIn)
	{
		firstName = firstNameIn;
		lastName = lastNameIn;
	}
	
	//==============GETTERS===========
	
		public String getFirstName()
		{
			return firstName;
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
		
		public void setLastName(String lastName)
		{
			this.lastName = lastName;
		}
		
	//=================================
		
		
		public abstract String toString();
	
}
