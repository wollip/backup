package spiral;
import objectdraw.*;
// this is for finding the x cordinate of the spiral
public class xvalue extends WindowController{
	
	private static final long serialVersionUID = 1L; // this is just somerandom thing eclipse told me to add
	private double tn = 20 // the amount of taylor series terms, 20 is fine for now, i haven't tried increasing or decreasing the value
			, taylorseries, // the value of the current term from the term series
			sumofterms = 0, // sum of all the terms of the taylor series
			x; //  the t-value that is associated with the x value. parametrics x = f(t)
	
	// setting the t-value for the x-value we want to find. 
	public xvalue(double a){
		x = a; 
	}
	// finding the x-value using t
	// general formula = x = ln(t) +t^(2tn)/((2tn-1)!)*(-1)^tn ; where tn  is the term number
	public double functionx(){
		double lnvalue = Math.log(x); //this is term 1 ln(t)
		while(tn>0){ // i am looping it so i don't have to type out the whole taylor series
			double numerator = Math.pow(x, tn); 
			/* finds t^(2tn); for some strange reason 2tn does work. but tn does work, however i figure it out by mistake, 
			 * so i don't have an explaination*/
			
			setfactorial factorialvalue = new setfactorial(2*tn -1); // using the factorial method i made; setting factorial
			double denominator = factorialvalue.getfactorial(); // finding out the factorial value
			double negapositive = Math.pow(-1, tn); // just figuring out if the term is positive or negative
			taylorseries = numerator/denominator*negapositive; // the value of 1 term of the taylor seires
			sumofterms = taylorseries +sumofterms; // adding up each term of the taylor series
			tn--; // after finding the value of 1 term, it moves on to the next one
		}
		double output = lnvalue + sumofterms; // adding up ln(t) which doesn't fit the general term
		return output; // just returning the value of x
		
	}
	
}
