import java.util.ArrayList;

public class question33 {
	
	public static void main(String args[]){
		double a,b;
		boolean hi;
		ArrayList <String> fractions = new ArrayList();
		for ( int denum = 10; denum <100; denum ++){
			for( int numer = 10; numer<denum; numer++){
				
				//System.out.println(numer + "/" + denum);
				
				if (denum/10 == numer%10){
					a = ((double)numer)/denum;
					if (denum%10 != 0){
						b = ((double)(numer/10))/(denum%10);
						System.out.println(numer + "/" + denum + ",a=" + a + ",b=" +b);
						hi = compare(a,b);
						if (hi){
							System.out.println("i found something");
							String temp = numer+ "/" +denum;
							fractions.add(temp);
						}
					}else{
						continue;
					}
					
				}
				
				
			}
		}
		for (int i = 0; i < fractions.size();i++ ){
			System.out.println(fractions.get(i));
		}
	}
	
	private static boolean compare(double a, double b){
		if (a==b){
			return true;
		}else return false;
		
	}
}
