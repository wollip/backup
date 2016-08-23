import java.util.*;

public class prime {
	public static void main(String[] args){
		int factors = 0;
		long currentnumber = 1;
		long addThis = 1;
		while (factors <=500){
			addThis++;
			currentnumber = addThis + currentnumber;
			factors = numberOfFactors((int)currentnumber);
			System.out.println(currentnumber + "," + factors);
		}
	}
	
	public static boolean isItPrime(int a){
		if (a == 1){
			return false;
		}
		int maxtry = (int) Math.round( Math.sqrt(a)); 
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
	
	public static ArrayList<data> factorize(int a){
		
		if (prime.isItPrime(a)){  // if the entered number is a prime
			ArrayList<data> returnList = new ArrayList<>(); 
			data x = new data (a,1);
			returnList.add(x);
			return returnList;
		}
		/*if (a == 0){
			ArrayList<Integer> returnList = new ArrayList(); 
			returnList.add(a);
			return returnList;
		}*/
		ArrayList<data> returnList = new ArrayList<>(); 
		//int maxtry = (int) Math.round(a/2)+1;
		int b = a+1;
		int trythis = 2;
		int howManyTimes = 0;
		while (trythis <= /*maxtry*/ b){
			//System.out.println("loop started" + trythis);
			if (a%trythis ==0){
				//System.out.println("number is divisible by trythis, a =" + a/trythis);
				a = a/trythis;
				howManyTimes++;
				//System.out.println("howmany times" + howManyTimes);
				continue;
			}
			if (howManyTimes !=0){
				//System.out.println("hom many times" + howManyTimes);
				data data = new data(trythis, howManyTimes);
				returnList.add(data);
				//System.out.println("stored data" + data.toString());
				howManyTimes = 0;
			}
			trythis++;
			//System.out.println("try this now equals" +trythis);
			/*if (a==1){
				break;
			}*/
			
		}
		
		
		return returnList;
	}

	static class data{
		public int base, power;
		
		public data(int a, int b){
			base = a;
			power =b;
		}
		public int returnbase(){
			return base;
		}
		public int returnpower(){
			return power;
		}	
		
		public String toString(){
			return base + "^" + power;
		}
	}
	
	
	public static int lcm(int a, int b){
		ArrayList<data> data = prime.factorize(a); // 2^3,  3^3
		ArrayList<data> data1 = prime.factorize(b); //2^4 , 3^2
		//System.out.println(data.toString());
		//System.out.println(data1.toString());
		ArrayList<data> returnList = new ArrayList<>();
		int base;
		for (int z = 0; z<data.size(); z++){ //storing all the prime factors from first number
			base = data.get(z).returnbase();
			//System.out.println("outside loop 1 starts, z = " + z + ", data base = " +base);
			boolean failsafe = true;
			for (int x = 0; x<data1.size();x++){
				//System.out.println("inside loop 1 starts \n x = " +x +"data1 base = " + data1.get(x).returnbase() );
				if (base == data1.get(x).returnbase()){
					failsafe = false;
					//System.out.println("Bases are the same");
					if (data.get(z).returnpower() >= data1.get(x).returnpower()){
						data store = new data(data.get(z).returnbase(), data.get(z).returnpower());
						//System.out.println( " data is bigger" + store.toString());
						returnList.add(store);
					}else{
						data store = new data(data.get(z).returnbase(), data1.get(x).returnpower());
						//System.out.println( " data 1 is bigger" + store.toString());
						returnList.add(store);
					}
					break;
				}
			}
			if (failsafe){
				data store = new data(data.get(z).returnbase(), data.get(z).returnpower());
				//System.out.println("bases were not the same" + store.toString());
				returnList.add(store);
			}
			
		}
		for (int z = 0; z< data1.size();z++){
			base = data1.get(z).returnbase();
			System.out.println("outside loop 2 start z = " +z+"base = " + base);
			boolean failsafe = true;
			for(int x= 0; x<data.size(); x++){
				System.out.println("inside loop 2 start");
				if (base == data.get(x).returnbase()){
					failsafe = false;
					break;
				}
			}
			if (failsafe){
				System.out.println("new base" + base);
				data store = new data(base, data1.get(z).returnpower());
				returnList.add(store);
			}
		}
		System.out.println(returnList.toString());
		int sum = 1;
		for(int x = 0; x<returnList.size();x++){
			sum = (int) (sum * (Math.pow(returnList.get(x).returnbase(), returnList.get(x).returnpower())));
			//System.out.println("sum = " + sum);
		}
		
		return sum;
		
	}

	public static int numberOfFactors(int a){
		ArrayList<data> primefactors = factorize(a);
		int factors = 1;
		for(int i =0; i<primefactors.size();i++){
			factors = (primefactors.get(i).returnpower()+1)*factors;
		}
		return factors;
	}
}	

	

