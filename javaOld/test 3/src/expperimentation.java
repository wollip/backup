import java.io.InputStream;
import java.util.Scanner;

import objectdraw.*;

public class expperimentation extends WindowController{
	private static String firstName;
	private static String lastName;
	private static int idnumber;
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		
		
		
		System.out.println("firstname?"  );
		firstName = input.nextLine();
		System.out.println("lastname? " );
		lastName = input.nextLine();
		System.out.println(" id number? ");
		idnumber = Integer.valueOf(input.nextLine());
		userdata[] a = new userdata[2];
		a[0] = new userdata(firstName, lastName, idnumber);
		a[1] = new userdata("bob", "smith" , 3333);
		
		String first = a[0].retrieveFirst();
		String second = a[1].retrieveAll();
		
		System.out.println(first);
		System.out.println(second);
		
	}
	
	
	
}   