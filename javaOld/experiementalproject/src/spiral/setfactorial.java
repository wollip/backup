package spiral;
// this is just to find factorials
import objectdraw.Location;
import objectdraw.WindowController;

public class setfactorial extends WindowController{
	
	private static final long serialVersionUID = 1L;
	private double value =1,x;
	
	public setfactorial(double a){ // set the x value
		x = a;
	}
	
	public double getfactorial(){ // find x!
		while (x>0){
			value = value * x;
			x--;
		}
		return value;
		
	}
}
