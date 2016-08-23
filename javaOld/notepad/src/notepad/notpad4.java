
import objectdraw.*;

public class notpad4 extends WindowController{
//real notepad
	private static final long serialVersionUID = 1L;

	Location previous;
	
	public void onMousePress(Location startpoint){
		previous = startpoint;
	}
	
	public void onMouseDrag(Location currentpoint){
		new Line(currentpoint, previous, canvas);
		previous=currentpoint;
	}
	
	public void onMouseExit(Location point){
		canvas.clear();
	}
	
}
