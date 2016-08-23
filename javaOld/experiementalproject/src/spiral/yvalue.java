package spiral;
import objectdraw.*;

public class yvalue extends WindowController{

	private static final long serialVersionUID = 1L;
	private double t, term= 1, output =0, currentterm;
	
	
	public yvalue(double a){
		t=a;
	}
	public double functiony(){
		while (term<30){
			double numerator = Math.pow(t, term);
			setfactorial factorialvalue = new setfactorial(2*term-1);
			double denominator = factorialvalue.getfactorial()* (2*term-1);
			double negapositive = Math.pow(-1, term);
			currentterm = numerator/denominator*negapositive;
			output = output + currentterm;
			term++;
			
		}
		return output;
	}
	
}
