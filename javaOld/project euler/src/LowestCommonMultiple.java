import java.util.*;

public class LowestCommonMultiple {
	
	
	public static void main(String[] args){
		int result = lcmlist(2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
		System.out.println(result);
	}
	
	public static int lcmlist(int...number){
		int result = number[0];
		System.out.println(number[0]);
		for(int n : number){
			System.out.print("lcm(" + result + ", " + n + ") is \n");
			result = prime.lcm(result,n);
			System.out.print(result + "\n");
		}	
		return result;
	}
	
}
