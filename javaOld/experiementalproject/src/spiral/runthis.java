package spiral;
import objectdraw.*;
// i am going to use this to run the other method i made. but since yvalue isn't working, i didn't bother finishing it
public class runthis extends WindowController{
	
	
	
	private static final long serialVersionUID = 1L;
	private xvalue funcx; 
	private yvalue funcy;
	private double t = 0;
	
	public void begin(){
		
		while (t<100){
		funcy = new yvalue(t);
		double output = funcy.functiony();
		System.out.println(t + ":" +output);
		new FilledOval(5*t, 5*output+100, 3,3,canvas);
		t++;
		}
		
		
	}

	

	

}
