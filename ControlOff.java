package source;

import java.util.ArrayList;
import java.util.List;

public class ControlOff
{
	List<Appliance> apls = new ArrayList<Appliance>();
	
	public ControlOff()
	{
		for(Appliance element: apls)
		{
			element.turnOff();
		}
	}
	
	public String toString()
	{
		return " STATUS: EVERYTHING OFF";
	}
	
}
