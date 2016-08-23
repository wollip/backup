package applets;

import java.util.Scanner;

public class CanadianChangeReturn {
	
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Change Amount?");
		double changeAmount = input.nextDouble();
		changeAmount = CanadianChangeReturn.round(changeAmount);
		System.out.println("you entered" + changeAmount);
		new CanadianChangeReturn(changeAmount);
	}
	public CanadianChangeReturn(double money){ //tells you how much you need for each thing. Remember to round first.
		double[] moneyamount = {100,50,20,10,5,2,1,0.25,0.1,0.05};
		int[] change = new int[10];
		// finds amount
		for (int i= 0; i < moneyamount.length; i++){
			change[i] = (int) Math.round(money/moneyamount[i]-0.5);
			money =  (money%moneyamount[i]);
		}
		// prints amount
		for (int a = 0 ; a<change.length; a++){
			System.out.println(moneyamount[a] + ":" + change[a]);
		}
	}
	public static double round(double a){ // rounds the cents to nickels
		double round =  (a%0.1);
		if (round>=0.03 && round<0.08){
			round = 0.05;
		}else if (round>=0 &&round<0.03){
			round = 0;
		}else{
			round = 0.1;
		}
		a = a-(a%0.1)+round;
		return a;
	}
}
