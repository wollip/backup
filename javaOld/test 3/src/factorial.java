import java.math.BigInteger;

public class factorial {
	
	public static void main(String[] args){
		BigInteger hi = calculate(100L);
		System.out.println(hi);
	}
	public static BigInteger calculate(long a){
		if (a==1 || a==0){
			System.out.println("i don't like this number");
			return (BigInteger) null;
		}else if( a<0){
			System.out.println("erroe erroer erooer");
			return (BigInteger) null;
		}
		long loop = a;
		BigInteger returnvalue =  BigInteger.valueOf(a);
		while(loop>1){
			loop--;
			returnvalue = returnvalue.multiply(BigInteger.valueOf(loop));
			
		}
		return returnvalue;
	}
}
