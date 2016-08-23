package applets;

import java.awt.Color;
import objectdraw.*;

public class spaceshipanimation extends WindowController{
	
	private static final long serialVersionUID = 1894;
	
	private FramedOval hole;
	private FilledOval space1;
	private FilledRect space2;
	private Line topfinback;
	private Line topfinfront;
	private Line botfinback;
	private Line botfinfront;
	private Text instruct1;
	private Text instruct2;
	private Text instruct3;
	private Location topline;
	private Location midline;
	private Location botline;
	
	
	
	public void begin(){
		instruct1 = new Text("come and click",50,0,canvas);
		instruct3 = new Text("you have entered the black hole",0,12,canvas);
		instruct3.hide();		
	}
	
	public void onMouseEnter(Location point){
		hole = new FramedOval(170,100,10,30,canvas);
		space1 = new FilledOval(45,100,25,25, canvas);
		space2 = new FilledRect(0,100,55,25,canvas);
		instruct3.hide();
		hole.hide();
		space1.hide();
		space2.hide();
		topline = new Location(0,100);
		midline = new Location(0,112);
		botline = new Location(0,123);
		topfinback = new Line(0,85,0,100,canvas);
		topfinfront = new Line(0,85,10,100,canvas);
		botfinback = new Line(0,140,0,125,canvas);
		botfinfront = new Line(0,140,10,125,canvas);
		topfinback.hide();
		topfinfront.hide();
		botfinback.hide();
		botfinfront.hide();
		space1.setColor(Color.BLUE);
		space2.setColor(Color.BLUE);
		hole.show();
		space1.show();
		space2.show();
		topfinback.show();
		topfinfront.show();
		botfinback.show();
		botfinfront.show();
		instruct1.hide();
		instruct3.hide();
		instruct2 = new Text("move out of window when done",0,0,canvas);
	}
	
	public void onMouseClick(Location point){
		instruct2.hide();
		space1.move(7,0);
		space2.move(7,0);
		topfinback.move(7, 0);
		topfinfront.move(7, 0);
		botfinback.move(7, 0);
		botfinfront.move(7, 0);
		topline.translate(7,0);
		midline.translate(7,0);
		botline.translate(7,0);
		new FilledRect(topline,7,2,canvas);
		new FilledRect(midline, 7, 2,canvas);
		new FilledRect(botline,7,2,canvas);
	}
	
	public void onMouseExit(Location point){
		space1.moveTo(50, 100);
		space2.moveTo(0, 100);
		topfinback.moveTo(0,85);
		topfinfront.moveTo(0,85);
		botfinback.moveTo(0,140);
		botfinfront.moveTo(0,140);
		space1.hide();
		space2.hide();
		hole.hide();
		instruct1.show();
		instruct2.hide();
		instruct3.show();
		topfinback.hide();
		topfinfront.hide();
		botfinback.hide();
		botfinfront.hide();
		canvas.clear();
		instruct1 = new Text("come and click again",50,12,canvas);
		instruct3 = new Text("you have entered the black hole",0,0,canvas);
	}

}
