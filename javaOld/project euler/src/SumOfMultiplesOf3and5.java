import java.util.ArrayList;

public class SumOfMultiplesOf3and5 {

	private static ArrayList<Integer> listOfValues = new ArrayList<Integer>();
	
	public static void main(String[] args){
		int value = 3;
		while (value <=1000){
			if(value%3 == 0 || value%5==0){
				listOfValues.add(value);
			}	
			value++;
		}
		int listLength = listOfValues.size();
		System.out.println(listLength);
		int sum = 0;
		for (int i = 0; i <listLength;i++){
			sum = sum + listOfValues.get(i);
			System.out.println( "i value:" + i + ", current sum:" + sum);
		}
		System.out.print(sum);
	}
}
