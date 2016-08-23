import java.math.BigInteger;

public class converter{
	
	public static void main(String[] args){
		long bignumber = 123456789123456789L;
		BigInteger sobig = BigInteger.valueOf( bignumber);
		int[] list = bigintegertointarray(sobig); 
		System.out.println(list.toString());
	}
	
	public static int[] bigintegertointarray (BigInteger number){
		
		String stringnumber = number.toString();
		System.out.println("string version" + stringnumber);
		int length = stringnumber.length();
		System.out.println("length = " + length);
		int[] returnList = new int[length];
		
		
		for(int a=0; a<length;a++){
			long placement = 10;
			BigInteger places = BigInteger.valueOf(placement);
			places = places.pow(a);
			int digit =  (number.divide(places)).intValue();
			digit = (int) Math.round(digit-0.5);
			digit = digit%10;
			System.out.println("current digit" +digit + ", current place" + a);
			returnList[a] = digit; 
		}
		
		return returnList;
	}

}
