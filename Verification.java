import java.util.ArrayList;
import java.util.Scanner;

public class Verification {
	
//	public  void  Veri (){
	public static void main(String[] args){

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		ArrayList<Person> ArrPerson = new ArrayList<Person>();
		Person admin = new Person(1, "Admin", "Admin");
		ArrPerson.add(admin);
		DataBase data1 = new DataBase(ArrPerson);
		
		ArrayList<BlackList> ArrBlackList = new ArrayList<BlackList>();
		BlackList bl1 = new BlackList(28745);
		ArrBlackList.add(bl1);
		
		System.out.println("House Panel");
		System.out.println("Press 1 for admin page, 2 for guest page");
		int Hchoice = scanner.nextInt();
	 while( Hchoice != 1 && Hchoice != 2){
		  System.out.println("Press 1 for admin page, 2 for guest page");
		  Hchoice = scanner.nextInt();
		  if(Hchoice == 1 && Hchoice ==2){
				  break;
		  }
	  }
	 String pass ="csulaCS";
	 String Pinput;
	 Boolean access = false;
	 int countA =0;
	 while(Hchoice ==1){
		 System.out.println("Enter password for admin page");
		 Pinput = scanner.next();
		 if(Pinput.equals(pass)){
			access = true; 
			System.out.println("access");
			break;
		 }
		 else{
			 System.out.println("access denied");
			 countA++;
		 }
		 if( countA ==3){
			 System.out.println("Exit");
			 break;
		 }
	 }
	 
		while (access == true) {
			System.out.println(
					"Press 1 to create an account, 2 to open a list of accounts , 3 to change user's information , 4 to check blacklist IDs, 5 to go to user panel , 6 to exit");
			int choice = scanner.nextInt();

			if (choice == 1) {

				System.out.println("\n");
				System.out.println("Adding to database");
				System.out.println("How many guests to add into the database : ");
				Integer count = scanner.nextInt();
				System.out.println("\n");

				int guestC = 0;

				int id = admin.id + 1;
				String f, l;

				while (count >0) {

					System.out.println("Enter First Name " + guestC + " : ");
				    scanner.nextLine();
				    f = scanner.nextLine();
					System.out.println("Enter Last Name " + guestC + " : ");
					l = scanner.nextLine();

					Person test = new Person(id, f, l);
					ArrPerson.add(test);

					id++;
					guestC++;

					if (count == guestC) {
						break;
					}
				}
			}
			if (choice == 3) {
				String changeF,changeL;
				System.out.println("Enter an ID number to change user account information ");
				Integer idNumb = scanner.nextInt();

				data1.displayByID(idNumb);
				System.out.println("Enter First Name "  + " : ");
			    scanner.nextLine();
			    changeF = scanner.nextLine();
				System.out.println("Enter Last Name "  + " : ");
				changeL = scanner.nextLine();
				
				data1.changeFN(changeF, idNumb);
				data1.changeLN(changeL, idNumb);
			}

			if (choice == 2) {
				
				data1.printDatabase();
			}
			if(choice ==4){
				DataBaseID dataBL = new DataBaseID(ArrBlackList);
				dataBL.printDatabase();
			}
			if(choice ==5){
				System.out.println("Guest Panel");
				break;
			}
			if (choice == 6) {
				System.out.println("Exit");
				break;
			}
		}
		while(Hchoice ==2 ){
			System.out.println("Guest Panel");
			break;
		}
	}
}
