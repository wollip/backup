package applets;

import java.util.ArrayList;

public class launcher {
	
	public static void main(String[]args){
		
		primenumber primefunction = new primenumber();
		
		ArrayList<Integer> primelist = primefunction.returnlist(50000);
		//System.out.println(primelist.size());
		/*int sum = 0;
		for(int a = 0; a<primelist.size();a++){
			System.out.println(primelist.get(a));
			sum = sum + (int) primelist.get(a);
		}
		System.out.println(sum);*/
		int prime = 0;
		int insideloop = 0;
		int outsideloop= 0;
		while (true){
			System.out.println("broken!!!!!!!!!!");
			while (prime<1000000){
				prime = prime + (int) primelist.get(insideloop);
				System.out.println(insideloop +"," + prime);
				insideloop++;
				//continue;
			}
			prime = prime - (int) primelist.get(insideloop-1);
			
			if (primefunction.isItPrime(prime)){
				System.out.println(prime);
				break;
			}else{
				outsideloop++;
				insideloop= outsideloop;
				
				prime = 0;
				continue;
			}
		}
		System.out.println(outsideloop);
	}
}
