import java.util.Scanner;

public class userdata {
	public int c;
	public String a;
	public String b;
	
	public userdata (String a, String b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
		
	}
	public String retrieveFirst(){
		return a;
	}
	public String retrieveLast(){
		return b;
	}
	public int retrieveID(){
		return c;
	}
	public String retrieveAll(){
		String all = a+","+b +" "+String.valueOf(c) ;
		return all;
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("firstname?"  );
		String firstName = input.nextLine();
		System.out.println("lastname? " );
		String lastName = input.nextLine();
		System.out.println(" id number? ");
		int idnumber = Integer.valueOf(input.nextLine());
		userdata[] a = new userdata[2];
		a[0] = new userdata(firstName, lastName, idnumber);
		a[1] = new userdata("bob", "smith" , 3333);
		

		
	}
}
