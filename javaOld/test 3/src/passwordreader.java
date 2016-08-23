import java.util.Scanner;

public class passwordreader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("please enter password");
		passwordreader();
		

	}

	private static void passwordreader() {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		String password = scanner.nextLine();
		if(password.equals("hi")){
			System.out.println("correct password");
			System.out.println("welcome");
		}else {
			System.out.println("retry");
			passwordreader();
			
		}
	}
	

}
