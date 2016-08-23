package applets;
import objectdraw.*;

public class rndnumgen2 extends WindowController{
	
	private static final long serialVersionUID = 189L;
	private int seednumber = (int) 69.696969, mod100, count =1;
	
	public void begin(){
		new Text("click here to begin generating",0,0,canvas);
	}
	public void onMouseClick(Location point){
		count= count +1;
		seednumber = (int) ((int) point.getX()* seednumber *  point.getY()
								 +point.getY() +point.getX()*count);
		mod100 = seednumber % 100;
		seednumber = (seednumber - mod100)/100;
		seednumber = seednumber % 100;
		System.out.print(seednumber + ",");
	}
}
