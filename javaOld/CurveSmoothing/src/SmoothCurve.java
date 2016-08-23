import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SmoothCurve extends JPanel{
	
	private static final int W_DIMEN = 1000;
	private static Point[] dots = new Point[20];
	private static Point[] codeDots = new Point[dots.length];
	private static final Point center = new Point(500,500);
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.black);
		
		g.setColor(Color.white);
		for(int i = 0; i < dots.length; i++){
			g.fillOval((int)codeDots[i].getX()-2, (int)codeDots[i].getY()-2, 4, 4);
		}
	}
	
	public SmoothCurve(JFrame window){
		window.setSize(W_DIMEN, W_DIMEN);
	}
	
	public static void arrayCartToCode( Point center, Point[] dots, Point[] codeDots){
		for(int i = 0; i < dots.length; i++){
			codeDots[i] = cartToCode(center, dots[i]);
		}
	}
	
	public static Point cartToCode(Point center, Point dot){
		Point ret = new Point((int)(dot.getX()+center.getX()), (int)(center.getY()-dot.getY()));
		return ret;
	}
	// assume first and last point as fixed
	public void shiftCurve(Point[] dots){
		Point[] tempDots = new Point[dots.length];
		tempDots[0] = dots[0];
		tempDots[dots.length-1] = dots[dots.length-1];
		
		double dx, dy, dx1, dy1;
		double dotproduct,  projx, projy;
		for(int i = 1; i < (dots.length-1); i++){
			
			dy = - (dots[i+1].getX()- dots[i-1].getX());
			dx =  (dots[i+1].getY()- dots[i-1].getY());
			//System.out.println(dx + " " + dy);
			
			dx1 =  (dots[i].getX() - dots[i-1].getX());
			dy1 =  (dots[i].getY() - dots[i-1].getY());
			//System.out.println(dx1 + " " + dy1);
			
			dotproduct = - (dx * dx1 + dy * dy1) / (dx * dx + dy * dy);
			//System.out.println(dotproduct);
			
			projx = dotproduct * dx;
			projy = dotproduct * dy;
			//System.out.println(projx + " " + projy);
			tempDots[i] = new Point((int)(dots[i].getX() + projx), (int)(dots[i].getY()+ projy));
			
			//System.out.println(tempDots[i].getX() + " " + tempDots[i].getY() + '\n');
			
		}
		this.dots = null;
		this.dots = tempDots.clone();
		for(int i = 0; i < dots.length; i++){
			//System.out.println(i);
			System.out.println(this.dots[i].getX() + " " + this.dots[i].getY());
		}
	}
	
	public static int function(int x){
		double ret = Math.pow(x,2)+Math.sin(x* Math.PI/3)*10;
		return (int) (ret*10);
	}
	public static void main(String[] args){
		JFrame window = new JFrame();
		window.setTitle("SmoothCurve"); 
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		for(int x = 0; x < 20; x++){
			dots[x] = new Point((x-10)*100, function(x-10));
			System.out.println(dots[x].getX() + " " + dots[x].getY());
		}
		
		arrayCartToCode(center, dots, codeDots);
		SmoothCurve curve = new SmoothCurve(window);
		window.add(curve);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int t = 0; t < 5; t++){
			curve.shiftCurve(dots);
			arrayCartToCode(center, dots, codeDots);
			curve.repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}
	
}
