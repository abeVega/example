package source;

import java.util.ArrayList;
import java.util.List;

public class ControlOn
{
List<Appliance> apls = new ArrayList<Appliance>();
	
	public ControlOn()
	{
		for(Appliance element: apls)
		{
			element.turnOn();
		}
	}
	
	public String toString()
	{
		return " STATUS: EVERYTHING ON";
	}
}
