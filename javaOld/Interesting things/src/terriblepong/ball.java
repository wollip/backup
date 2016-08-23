package terriblepong;

import objectdraw.*;

public class ball extends WindowController{
	
	private FilledOval ball;
	private static final int radius = 5;
	private int xorigin =100, yorigin=100;
	
	public ball(){
		ball = new FilledOval(xorigin-radius, yorigin-radius, radius*2, radius*2, canvas);
	}
}
