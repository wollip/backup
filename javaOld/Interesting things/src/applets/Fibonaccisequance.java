package applets;

import java.util.ArrayList;
import java.util.Arrays;

public class Fibonaccisequance {
	
	private static final long serialVersionUID = 1896521;
	private static int term1=1;
	private static int term2= 2;
	private static ArrayList intarray = new ArrayList();
	
	public static void main(String[] args){
		while (term1 <= 4000000){
			if ( term1%2 == 0){
				intarray.add(term1);
			}
			int currentterm = term1;
			term1 = term2;
			term2 = currentterm + term2;	
			if (term1 == 4000000){
				System.out.println("holy crap");
			}
		}
		int sum = 0;
		for ( int i = 0; i<intarray.size(); i ++){
			sum = sum + (int) intarray.get(i);
		}
		System.out.println(sum);
		
	}
}
