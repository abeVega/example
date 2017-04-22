package source;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Toaster extends Appliance
{
	protected boolean power = false;
	//List<String> heat = new ArrayList<String>();
	String[] heat = {"Mildly Hot", "Hot", "Super Hot"};
	Scanner sc = new Scanner(System.in);
	

	@Override
	void turnOff()
	{
		power = false;	
	}

	@Override
	void turnOn()
	{
		power = true;	
	}
	
	public void mild()
	{
		System.out.println(heat[0] + ": heated mild");
	}
	
	public void hot()
	{
		System.out.println(heat[1] + ": heated hot");
	}
	
	public void superHot()
	{
		System.out.println(heat[2] + ": heated super hot");
	}
	
	public void menu()
	{
		{
			int choice = 0;
			int quit = 0;
			
			do
			{
				quit = 1;
				
				System.out.println("===>NOW AT THE MAIN MENU<===");
				System.out.println("Press 1 to heat the bread mildly. \nPress 2 to heat the bread "
						+ "Hot. \nPress 3 to make the bread Super Hot.");
				System.out.println("Pressing any other number will prompt you to quit.");
				choice = sc.nextInt();
				
				switch(choice)
				{
					case 1: System.out.println(heat[0] + ": Decided to heat the bread mildly hot.");
						break;
						
					case 2: System.out.println(heat[1] + ": Decided to heat the bread to hot.");
						break;
						
					case 3: System.out.println(heat[2] + ": Decided to heat the bread to super hot.");
						break;
				
				}
				
				System.out.println("Press 0 to quit or any other number to go back to the main menu.");
				quit = sc.nextInt();
				
			}while(quit != 0);
	}
	
	
	
}
}
