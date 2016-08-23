package applets;

import java.awt.Color;
import objectdraw.*;

public class Colourpalette1 extends WindowController{
	
	private static final long serialVersionUID = 148;
	
	private int ig,ib,ix2r,iy2,ix2,iy2r,ir,trueib;
	private FilledRect color;
			
	public void begin(){
		new FramedRect(0,0,180,180,canvas);
		color = new FilledRect(80,80,20,20,canvas);
	}
	public void onMouseDrag(Location position){
		double dy = position.getY();
		int iy = (int)dy;
		double dx = position.getX();
		int ix = (int)dx;
		ix2 = ix*ix;
		iy2 = iy*iy;
		ix2r = (180-ix)*(180-ix);
		iy2r = (180-iy)*(180-iy);
		ir = ix2 + iy2r ;
		ig = ix2r +iy2;
		ib = ix2+iy2;
		int r = (int) Math.sqrt(ir);
		int g = (int) Math.sqrt(ig);
		int b = (int) Math.sqrt(ib);
		trueib = 255 - b;
		color.setColor( new Color(r,g,trueib));
		color.moveTo(position);
	}
}
