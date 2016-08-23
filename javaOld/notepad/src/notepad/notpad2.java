package notepad;
import objectdraw.*;

public class notpad2 extends WindowController{
	//create 1 long line
	private static final long serialVersionUID = 04;

	private Location firstpoint;
	
	public void onMouseRelease(Location point1){
		firstpoint = point1;
	}
	
	public void onMousePress(Location point2){
		new Line(firstpoint, point2, canvas);
	}
	public void onMouseExit(Location point){
		canvas.clear();
	}
}
