package applets;
import java.awt.Color;

import objectdraw.*;

public class battleship extends WindowController{
	//click on squares and see if you choose the right squares)
	//expand applet window for full size
	
	
	/* things that need to be fix
	 * different boat sizes
	 * making sure the boats don't over lap; do this by using nesting loops and if statements
	 * */
	private static final long serialVersionUID = 18943;
	
	private static int i=1 //for making the grid
			,gridx = 300 //board size
			,gridy = 300;
	private int
			x1,y1 //location of ship 1
			,x2,y2
			,x3,y3
			,x4,y4
			,x5,y5
			,points = 0
			,hpoints = 0
			,lpoints = 0
			,resetvalue
			;
	private FramedRect resetbox;
	private Text score,highscore, lowscore;					;
	private RandomIntGenerator ten = new RandomIntGenerator(0,10);
	private FilledRect ship1,ship2,ship3,ship4,ship5;
	private FilledOval miss;
				
	public void begin(){
		//drawing a 10x10 grid
		for(i=1;i<11;i++){
			new Line(gridx/10*i,0,gridx/10*i,gridy,canvas);
			new Line(0,gridy/10*i,gridx,gridy/10*i,canvas);
		}
		//instructions
		new Text("Red dots = miss (-10 points)",0,300,canvas);
		new Text("ship1 = Orange  (points 500)",0,312,canvas);
		new Text("ship2 = Yellow (points 400 )",0,324,canvas);
		new Text("ship3 = Green (points 300)",0,336,canvas);
		new Text("ship4 = Blue (points 200)",0,348,canvas);
		new Text("ship5 = Purple (points 100)",0,360,canvas);
		//ship1
		x1 = (ten.nextValue()) *30;
		y1 = (ten.nextValue()) *30;
		ship1 = new FilledRect(x1,y1,30,30,canvas);
		ship1.setColor(Color.ORANGE);
		ship1.hide();
		//ship2
		x2 = (ten.nextValue()) *30;
		y2 = (ten.nextValue()) *30;
		ship2 = new FilledRect(x2,y2,30,30,canvas);
		ship2.setColor(Color.YELLOW);
		ship2.hide();
		//ship3
		x3 = (ten.nextValue()) *30;
		y3 = (ten.nextValue()) *30;
		ship3 = new FilledRect(x3,y3,30,30,canvas);
		ship3.setColor(Color.GREEN);
		ship3.hide();
		//ship4
		x4 = (ten.nextValue()) *30;
		y4 = (ten.nextValue()) *30;
		ship4 = new FilledRect(x4,y4,30,30,canvas);
		ship4.setColor(Color.BLUE);
		ship4.hide();
		//ship5
		x5 = (ten.nextValue()) *30;
		y5 = (ten.nextValue()) *30;
		ship5 = new FilledRect(x5,y5,30,30,canvas);
		ship5.setColor(Color.MAGENTA);
		ship5.hide();
		//score
		score = new Text("SCORE:" + points, 200,300,canvas);
		//reset
		resetbox = new FramedRect(200,350,40,20,canvas);
		new Text("Reset",203,352,canvas);
		//highscore
		highscore = new Text("HIGHSCORE:" + hpoints, 200,312,canvas);
		//lowscore
		lowscore = new Text("LOWSCORE:" + lpoints, 200, 324,canvas);
		
	}
	public void onMouseClick(Location point){
		if (ship1.contains(point) && ship1.isHidden()){
			ship1.show();
			points= points +500;
		}
		else if(ship2.contains(point)&& ship2.isHidden()){
			ship2.show();
			points = points +400;
		}
		else if(ship3.contains(point)&& ship3.isHidden()){
			ship3.show();
			points = points +300;
		}
		else if(ship4.contains(point)&& ship4.isHidden()){
			ship4.show();
			points = points +200;
		}
		else if(ship5.contains(point)&& ship5.isHidden()){
			ship5.show();
			points = points +100;
		}
		else{
			miss = new FilledOval(point,3,3,canvas);
			miss.setColor(Color.RED);
			points = points -10;
		}
		//displaying points
		if(hpoints<points){
			hpoints= points;
		}
		if(lpoints>points){
			lpoints = points;
		}
		highscore.setText("HIGHSCORE:" + hpoints);
		lowscore.setText("Lowscore:" + lpoints);
		score.setText("SCORE:" + points);
		
		if(resetbox.contains(point)){
			canvas.clear();
			new Text("reenter the applet",0,0,canvas);
			resetvalue=1;
			
		}
	}
	public void onMouseEnter(Location point){
		if(resetvalue==1){
			canvas.clear();
			resetvalue=0;
			points = 0;
			hpoints =0;
			lpoints = 0;
			//drawing a 10x10 grid
			for(i=1;i<11;i++){
				new Line(gridx/10*i,0,gridx/10*i,gridy,canvas);
				new Line(0,gridy/10*i,gridx,gridy/10*i,canvas);
			}
			//instructions
			new Text("Red dots = miss (-10 points)",0,300,canvas);
			new Text("ship1 = Oragne  (points 500)",0,312,canvas);
			new Text("ship2 = Yellow (points 400 )",0,324,canvas);
			new Text("ship3 = Green (points 300)",0,336,canvas);
			new Text("ship4 = Blue (points 200)",0,348,canvas);
			new Text("ship5 = Purple (points 100)",0,360,canvas);
			//ship1
			x1 = (ten.nextValue()) *30;
			y1 = (ten.nextValue()) *30;
			ship1 = new FilledRect(x1,y1,30,30,canvas);
			ship1.setColor(Color.ORANGE);
			ship1.hide();
			//ship2
			x2 = (ten.nextValue()) *30;
			y2 = (ten.nextValue()) *30;
			ship2 = new FilledRect(x2,y2,30,30,canvas);
			ship2.setColor(Color.YELLOW);
			ship2.hide();
			//ship3
			x3 = (ten.nextValue()) *30;
			y3 = (ten.nextValue()) *30;
			ship3 = new FilledRect(x3,y3,30,30,canvas);
			ship3.setColor(Color.GREEN);
			ship3.hide();
			//ship4
			x4 = (ten.nextValue()) *30;
			y4 = (ten.nextValue()) *30;
			ship4 = new FilledRect(x4,y4,30,30,canvas);
			ship4.setColor(Color.BLUE);
			ship4.hide();
			//ship5
			x5 = (ten.nextValue()) *30;
			y5 = (ten.nextValue()) *30;
			ship5 = new FilledRect(x5,y5,30,30,canvas);
			ship5.setColor(Color.MAGENTA);
			ship5.hide();
			//score
			score = new Text("SCORE:" + points, 200,300,canvas);
			//reset
			resetbox = new FramedRect(200,350,40,20,canvas);
			new Text("Reset",203,352,canvas);
			//highscore
			highscore = new Text("HIGHSCORE:" + hpoints, 200,312,canvas);
			//lowscore
			lowscore = new Text("LOWSCORE:" + lpoints, 200, 324,canvas);
		}
	}

}
