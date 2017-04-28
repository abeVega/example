
public class BlackList {
	protected Integer id;
	
public BlackList(){}
	
	public BlackList(int id)
	{
		this.id = id;

	}
	
	public Integer getId()
	{
		return id;
	}
	
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String toString(){
  	  String output= "" ;
	       output +=  "ID : " + " " + this.id + "\n" ;   
			return output;
  	
  }
	
}
