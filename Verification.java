import java.util.ArrayList;
import java.util.Scanner;

public class Verification {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Person admin = new Person(1, "Admin", "Admin");
		ArrayList<Person> ArrPerson = new ArrayList<Person>();
while(true){
		System.out.println("Press 1 to create an account, 2 to open a list of accounts , 3 to change user's information , 4 to exit");
		int choice = scanner.nextInt();
		
		if(choice == 1){
		
		System.out.println("\n");
		System.out.println("Adding to database");
		System.out.println("How many guests to add into the database : ");
		Integer count = scanner.nextInt();
		System.out.println("\n");

		int guestC = 0;

		int id = admin.id + 1;
		String f, l;


		while (true) {

			System.out.println("Enter First Name " + guestC + " : ");
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
		if(choice ==3){
			System.out.println("Enter an ID number to change user account's information ");
				Integer idNumb = scanner.nextInt();
				
				System.out.println(ArrPerson.get(idNumb));
		}
		
		if(choice == 2){
		DataBase data1 = new DataBase(ArrPerson);
		data1.printDatabase();
		}
		if(choice ==4){
			System.out.println("Exit");
			break;
		}
}
	}
}
