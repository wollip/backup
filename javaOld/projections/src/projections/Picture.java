package projections;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Picture extends JPanel implements ActionListener{
	
	private final static int W_DIMEN = 700;
	
	private final static double[][] cube = new double[8][3];
	
	
	private final static double cameraDist = 1;
	
	private static double[][] newMap;
	private static double[] pinHole = new double[] {0,0,0};
	private static double[] normal = new double[] {0,0,1};
	private static double[][] flatMap;
	
	private static boolean UP = false;
	private static boolean DOWN = false;
	private static boolean LEFT = false;
	private static boolean RIGHT = false;
	private static boolean SHIFT = false;
	
	
	public Picture(JFrame window){
		window.addKeyListener(new ArrowAdapter());
		window.setSize(W_DIMEN,W_DIMEN);  
	}
	
	private class ArrowAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT){
                LEFT = true;
                RIGHT = false;
                DOWN = false;
                UP = false;
            }

            
        }
    }
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.black);
		g.setColor(Color.white);
		g.drawLine(10, 10, 100, 100);
		
		for(int i = 0; i< flatMap.length; i++){
			g.drawOval(100+(int)flatMap[i][0]-5, 100+(int)flatMap[i][1]-5, 10, 10);
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private static void init(){
		cube[0] = new double[] {100,100,2};
		cube[1] = new double[] {100,-100,2};
		cube[2] = new double[] {-100,100,2};
		cube[3] = new double[] {-100,-100,2};
		cube[4] = new double[] {100,100,4};
		cube[5] = new double[] {100,-100,4};
		cube[6] = new double[] {-100,100,4};
		cube[7] = new double[] {-100,-100,4};
		
		
		
	}
	
	private static void convert(double[][] map){
		newMap = new double[map.length][map[0].length];
		for(int point = 0; point < map.length; point++){
			for(int i = 0; i < 3; i++){
				newMap[point][i] = map[point][i] - pinHole[i];
			}	
		}	
	}
	
	private static double[] unitIt(double[] number){
		double mag =  Math.sqrt(Math.pow(number[0],2) + Math.pow(number[1],2) + Math.pow(number[2],2));
		double[] ret = new double[3];
		for(int i = 0; i <3; i++){
			ret[i] = number[i] / mag;
		}
		return ret;
	}
	
	private static double[] proj(double[] a, double[] b){
		b = unitIt(b);
		double sum = 0;
		for(int i = 0; i<3; i++){
			sum += a[i] * b[i];
		}
		double[] ret = new double[3];
		for(int i = 0; i< 3; i++){
			ret[i] = b[i] * sum;
		}
		return ret;
	
	}
	
	private static double comp(double[] a, double[] b){
		b = unitIt(b);
		double sum = 0;
		for(int i = 0; i<3; i++){
			sum += a[i] * b[i];
		}
		return sum;
	}
	
	private static double mag(double[] a){
		double sum = 0;
		for(int i = 0; i<3; i++){
			sum += Math.pow(a[i], 2);
		}
		return  Math.sqrt(sum);
	}
	
	private static double[][] rescale(){
		normal = unitIt(normal);
		double dist;
		double[][] distance = new double[newMap.length][3];
		double[][] distance2 = new double[newMap.length][3];
		for(int i = 0; i < newMap.length; i++){
			distance[i] = proj(newMap[i], normal);
			dist = comp(newMap[i], normal);
			for(int i2 = 0; i2 < 3; i2++){
				distance2[i][i2] = newMap[i][i2] - distance[i][i2];
				distance2[i][i2] = distance2[i][i2] / dist;
			}
			
		}
		return distance2;
	}
	
	public static void main(String[] args){
		init();
		convert(cube);
		double[][] ret = rescale();
		for(int i = 0; i < ret.length; i++){
			for(int i2 = 0; i2 < 3; i2++){
				System.out.print(ret[i][i2] + ",");
			}
			System.out.println();
		}
		flatMap = ret;
		
		JFrame window = new JFrame();
		window.setTitle("Projection");
		window.setSize(W_DIMEN, W_DIMEN);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		Picture pic = new Picture(window);
		window.add(pic);
	}
	
}
