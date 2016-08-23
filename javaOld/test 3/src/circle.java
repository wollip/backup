import objectdraw.*;

public class circle extends WindowController{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double x, y , x1 , y1, centerX, centerY, centerR;
	private Line[] linesarray;
		

	public  circle( double centerx, double centery, double radius, DrawingCanvas canvas){
		centerX = centerx;
		centerY = centery;
		centerR = radius;
		x= centerx - radius;
		int lineamount = (int) (radius*4+100);
		linesarray = new Line[lineamount];
		
		while (x < centerx +radius){
			int a =0;
			double func = radius*radius - (x-centerx)*(x-centerx);
			y = Math.sqrt(func) + centery;
			x1 = x +1;
			double func1 = radius*radius - (x1-centerx)*(x1-centerx);
			y1 = Math.sqrt(func1) + centery;
			linesarray[a] = new Line(x,y,x1,y1,canvas);
			y = centery - Math.abs(centery-y);
			y1 = centery - Math.abs(centery - y1);
			linesarray[a+1] = new Line(x,y,x1,y1,canvas);
			x++;
			a = a+2;
		
		}		
	}
	public void move(int x, int y){
		int i = 0;
		for(i=0;i<linesarray.length;i++)
			linesarray[i].move(x, y);
		start(); 
	}


	public double getcenterX(){
		return centerX;
	}
	public double getcenterY(){
		return centerY;
	}
	public double getradius(){
		return centerR;
	}
	
	public boolean contain(Location point){
		double a = point.getX();
		double b = point.getY();
		double c = Math.sqrt(centerR*centerR-(a-centerX)*(a-centerX))+centerY;
		if(b< c){
			return true;
		}else{
			return false;
		}
	}
}
