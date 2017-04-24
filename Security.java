import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.Calendar;


public class Security {
	public static int SECONDS_IN_A_DAY = 24 * 60 * 60;

	public static void main(String[] args) throws InterruptedException {
		ArrayList<BlackList> ArrBlackList = new ArrayList<BlackList>();
		List<String> list = new ArrayList<String>();
		List<String> id = new ArrayList<String>();
		File file = new File("id.txt");
		if (file.exists()) {
			try {
				list = Files.readAllLines(file.toPath(), Charset.defaultCharset());
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}
		for (String line : list) {
			String[] res = line.split(",");
			id.add(res[1]);

		}

		List<Integer> listID = new ArrayList<Integer>();
		for (String s : id) {
			listID.add(Integer.valueOf(s));
		}

		int[] numb = { 34844, 28745, 44127, 34543 };
		List<Integer> intCheckList = new ArrayList<Integer>();
		for (int i = 0; i < numb.length; i++) {
			intCheckList.add(numb[i]);
		}

		// check id
		int count = 1;
		for (int i = 0; i < id.size(); i++) {

			System.out.print("ID " + count + " : ");

			System.out.print(id.get(i));
			System.out.println("");
			count++;
		}

		boolean door = false;
		boolean alarm = false;

		int invalid = 0;
		for (Integer igr : listID) {
			if (intCheckList.contains(igr)) {
				System.out.println("Success!!");
				door = true;
			} else {
				
				System.out.println("Invalid!!! ");
				door = false;
				alarm = true;
				invalid++;
				
			}
//			if (invalid == 3) {
//				alarm = true;
//
//				int timet = 18000 * 60;
//				long delay = timet * 1000;
//
//				do {
//					int minutes = timet / 60;
//					int seconds = timet % 60;
//					System.out.println(minutes + " minute(s), " + seconds + " second(s)");
//					Thread.sleep(1000);
//					timet = timet - 1;
//					delay = delay - 1000;
//
//				} while (delay != 0);
//				System.out.println("Time's Up!");
//
//			}
		}
		
		
		for (Integer igr2 : listID) {
			if (!intCheckList.contains(igr2)) {
				BlackList test = new BlackList(igr2);
				ArrBlackList.add(test);
			}
		}
		
		
		
		
		DataBaseID data1 = new DataBaseID(ArrBlackList);
		data1.printDatabase();

		System.out.println("\n");
	}

}
