import java.util.ArrayList;

public class ReverseNumber {
	
	private double input;
	private int[] digits;
	
	public static void main(String[] args){
		ReverseNumber function = new ReverseNumber();
		int product1 = 100;
		int product2 = 100;
		int store = 0;
		System.out.println("product 1 and 2" + product1 + "," + product2);
		while(product1 < 1000){
			System.out.println("outsideloop start" + product1);
			while( product2 <1000){
				System.out.println("inside loop start" + product2);
				int test = product1 * product2;
				function.input(test);
				int output = (int) function.output();
				if(test == output){
					System.out.println(test);
					if (test > store){
						store = test;
					}
				}
				product2++;
			}
			product2 = 100;
			product1++;
		}
		System.out.println(store);
		
	}
	
	public ReverseNumber(){}
	
	public void input(double a){
		input = a;
	}
	public double output(){
		
		if (input == 0){
			return input;
		}
		
		int length = (int) Math.log10(input);
		//System.out.println("input" + input);
		length = (int) Math.round(length-0.5);
		//System.out.println("length" + length);
		digits = new int[ length +1];
		
		for (int a = 0; a<=length; a++){
			double forPart1 =  Math.pow(10, a);
			double partOfInput =  Math.round((input/forPart1)-0.5);
			digits[a] = (int) (partOfInput%10);
		}
		
		double returnValue =0;
		for (int a = 0; a<digits.length; a++){
			//System.out.println("digits" + a + "," + digits[a]);
			int placement = (int) Math.pow(10, length-a);
			//System.out.println("placement" + placement);
			returnValue = returnValue + digits[a]*placement;
			//System.out.println("return value" + returnValue);
		}
		
		return returnValue;
	}
}	
