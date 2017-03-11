package testingSoftware;
import java.util.TimerTask;
import java.util.Calendar;
//import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
/**
 *
 * @author Dhinakaran P.
 */
// Create a class extends with TimerTask
public class schedulingTEST {
	 
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter the task: ");
		String task = reader.next();
			
		System.out.println("Hour: ");
		int hour = reader.nextInt()%12;
		
		System.out.println("Minute: ");
		int minute = reader.nextInt(); // Scans the next token of the input as an int.
		
		Timer timer = new Timer();
		TimerTask tt = new TimerTask(){			
			public void run(){
				Calendar cal = Calendar.getInstance(); //this is the method you should use, not the Date(), because it is de-sperated.
				int schedHour = cal.get(Calendar.HOUR_OF_DAY)%12;//get the hour number of the day, from 0 to 23
				int schedMinute = cal.get(Calendar.MINUTE);
				
				//System.out.println(hour%12 + ":" + minute);
				
				if(hour == schedHour && minute == schedMinute){
					//System.out.println("doing the scheduled task");
					if(minute == 0){ 
						System.out.println(task);
						System.out.println(hour + ":" + minute + "0");
					}
					
					else if(minute < 10) {
						System.out.println(task);
						System.out.println(hour + ":" + "0" + minute);	
					}
					
					else {
						System.out.println(task);
						System.out.println(hour + ":" + minute);
					}
				}
			}
		};
		timer.schedule(tt, 1000, 1000*5);//	delay the task 1 second, and then run task every five seconds
	}
}