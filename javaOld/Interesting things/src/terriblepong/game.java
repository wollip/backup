package terriblepong;
import objectdraw.*;

public class game extends WindowController{
	
	private FilledOval ball;
	private int xorigin = 100, yorigin = 100;
	private static final int radius = 5;
	
	private static FilledRect rect;
	private int xmid = 100;
	private static final int ymid = 190, rectlength = 30, rectheight = 5;
	
	private Line north, south, east, west;
	
	private static final int velocity = 8;
	
	public void begin(){
		rect = new FilledRect(xmid-rectlength,ymid,rectlength*2,rectheight,canvas);
		ball = new FilledOval(xorigin-radius, yorigin-radius, radius*2, radius*2, canvas);
		north = new Line(0,0,canvas.getWidth(),0,canvas);
		south = new Line(0,canvas.getHeight(),canvas.getWidth(),canvas.getHeight(),canvas);
		east = new Line(canvas.getWidth(),0, canvas.getWidth(),canvas.getHeight(),canvas);
		west = new Line(0,0,0,canvas.getHeight(),canvas);
		while (true){
			ball.move(velocity, velocity);
			
			
		}
		
	}
	
	
}
