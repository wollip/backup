package notepad;
import objectdraw.*;
public class notpad extends WindowController{
	//create multiple lines
	private static final long serialVersionUID = 03;
	
	private Location clickpoint;
	private Location releasepoint;
		
	public void onMousePress(Location firstpoint){
		clickpoint = firstpoint;
		clickpoint.translate(-5,-5);
		new FramedOval(clickpoint, 10,10,canvas);
		
			
	}
	public void onMouseRelease(Location lastpoint){
		clickpoint.translate(5, 5);
		new Line(clickpoint,lastpoint,canvas);
		releasepoint = lastpoint;
		releasepoint.translate(-5, -5);
		new FramedOval(lastpoint, 10,10,canvas);
	}
	public void onMouseExit(Location point){
		canvas.clear();
	}
		
		

}

