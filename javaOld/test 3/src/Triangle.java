import objectdraw.*;

public class Triangle extends WindowController{
	
	
	private Line l1, l2, l3;
	

	
	private static final long serialVersionUID = 111;

	public Triangle(double x, double y, DrawingCanvas canvas){
			
		l1 =new Line(x, y, x+5, y+10,canvas);
		l2 =new Line(x, y,x-5,y +10,canvas);
		l3 =new Line(x -5,y +10,x +5,y+10,canvas);
		
		
	}
	
	public void move(double dx, double dy){
		l1.move(dx, dy);
		l2.move(dx, dy);
		l3.move(dx, dy);
	}
	

	
}
