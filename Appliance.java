package source;

public abstract class Appliance
{
	/*protected String applianceName;
	
	public Appliance(){}
	
	public Appliance(String applianceNameIn)
	{
		applianceName = applianceNameIn;
	}
	
	public String getApplianceName()
	{
		return applianceName;
	}
	
	public void setApplianceName(String applianceName)
	{
		this.applianceName = applianceName;
	}*/
	
	abstract void turnOff();
	abstract void turnOn();
}
