package applets;

import java.util.ArrayList;

public class primenumber {
	
	
	public static void main(String[] args){
		int prime = 1;
		for (int a = 0; a<10001;a++){
			prime =  next(prime);
			if (!isItPrime(prime)){
				System.out.println("something went wrong" + prime);
			}
			System.out.println(prime);
		}
	}
	
	public static int next(int a){ // finds next prime number // got to fix this
		a++;
		//int halfOfA = (int) Math.round(Math.sqrt(a));
		
		int loop = 2;
		while (loop < a){
			if (a%loop == 0){
				a++;
				loop=2;
				continue;
			}else {
				loop++;
			}	
		}
		loop = 2;
		
		return a;
	}
	
	
	public ArrayList<Integer> returnlist(int a){ //give list of primes up to a number
		int findingPrimes = 2;
		primenumber prime = new primenumber();
		
		ArrayList<Integer> primelist = new ArrayList<Integer>();
		
		while (findingPrimes <= a){
			boolean isItPrime = prime.isItPrime(findingPrimes);
			if (isItPrime){
				primelist.add(findingPrimes);
				
			}
			findingPrimes++;
		}
		return primelist;
	}
	
	public int arraylength(int a){ // amount of primes up to a number
		int findingPrimes = 2;
		int arraylength=0;
		primenumber prime = new primenumber();
		while (findingPrimes <= a){
			boolean isItPrime = prime.isItPrime(findingPrimes);
			if (isItPrime){
				arraylength++; 
			}
			findingPrimes++;
		}
		return arraylength;
	}
	
	public static boolean isItPrime(int a){ // check whether it is a prime
		if (a == 1){
			return false;
		}
		int maxtry = Math.round( a/2); 
		int trythis = 2;
		while (trythis <= maxtry){
			if (a%trythis == 0 ){
				return false;
			}else { 
				trythis++;
			}
		}
		return true;
	}
	
	/*public int[] factorize(int a){
		int halfOfA = (int) (a/2);
		primenumber prime = new primenumber();
		int[] primeRoots = prime.returnlist(halfOfA);
		int stringlength = prime.numberOfPrimeRoots(a);
		int[] returnValues = new int[2*stringlength];
		int howManyTimes = 0;
		int loop = 0;
		int arraynumber = 0;
		while (loop < primeRoots.length){
			if (a%primeRoots[loop]==0){
				howManyTimes++;
				a= a/(primeRoots[loop]);
				continue;
			}else if (howManyTimes != 0){
				returnValues[arraynumber] = primeRoots[loop];
				arraynumber++;
				returnValues [arraynumber] = howManyTimes;
				arraynumber++;
				howManyTimes = 0;
			}
			if (howManyTimes == 0){
				loop++;
			}else{
				System.out.print(howManyTimes + "," + primeRoots[loop] + "error");
			}
		}
		return returnValues;
	}*/
	
	/*public int numberOfPrimeRoots(int a){ // finds how many different type of primes a number contain
		int halfOfA = (int) a/2;
		primenumber prime = new primenumber();
		int[] listOfPrimes = prime.returnlist(halfOfA);
		int returnValue = 0;
		for(int i = 0; i < listOfPrimes.length; i++){
			if (a%listOfPrimes[i] == 0){
				returnValue++;
			}
		}
		return returnValue;
	}*/

	/*public void printFactorization(int a){
		primenumber prime = new primenumber();
		int[] factorization = prime.factorize(a);
		for (int i =0; i < factorization.length; i+=2)
			System.out.print(factorization[i]+"^"+factorization[i+1]+",");
	}*/
}
