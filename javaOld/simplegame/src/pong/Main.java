package pong;

import javax.swing.JComponent;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;

class Grid extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g){
		System.out.println("Drawing grids");
		for (int i = 0; i <= 600; i +=10){
			g.drawLine(i, 0, i, 600);
			g.drawLine(0, i, 600, i);
		}
	}
}
class Apple extends JComponent{
	
	
	public void paint(Graphics a){
		System.out.println("Drawing apple");
		a.setColor(Color.RED);
		a.fillRect(10,10,10, 10);
	}
}

class Window extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame window;
	public Window(){
		System.out.println("initializing window");
		window = new JFrame("pong");
		window.setSize(600, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);	
	}

	public void drawGrid() {
		// TODO Auto-generated method stub
		System.out.println("calling grid");
		window.getContentPane().add(new Grid());
	}
	
	public void drawApple(){
		System.out.println("Calling apple");
		Apple apple = new Apple();
		window.getContentPane().add(apple);
		
	}
		
}
public class Main extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args){
		Window window = new Window();
		window.drawGrid();
		window.drawApple( );
	}
	
	

}
