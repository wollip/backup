package notepad;
import objectdraw.*;

public class notpad3 extends WindowController {
	
	private static final long serialVersionUID = 05;
	//actual drawing pad type 1
	Location startposition;
	
	
	
	public void onMouseDrag(Location currentpoint){
		startposition=currentpoint;
		new FilledOval(startposition, 2,2, canvas);
	}
	
}
