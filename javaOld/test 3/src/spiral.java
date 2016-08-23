import objectdraw.Line;
import objectdraw.*;

public class spiral extends WindowController{
	
	private Line[] linearray;
	
	public void begin(){
		linearray = new Line[5001];
		double t = 0;
		int a = 0;
		while (t<50){
			double x = Math.sin(t)*t;
			double y = Math.cos(t)*t;
			t= t+0.01;
			double x1 = Math.sin(t)*(t);
			double y1 = Math.cos(t)*(t);
			linearray[a] = new Line(x+200,y+200,x1+200,y1+200,canvas);
			a++;
		}
	}
	public void onMouseClick(Location point){
		int i=0;
		for (i=0;i<linearray.length; i++)
			linearray[i].move(-5,-5);
	}
}
