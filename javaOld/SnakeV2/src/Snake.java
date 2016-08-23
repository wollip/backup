import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Snake extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public static void main(String args[]){
		JFrame snake = new Snake();
		snake.setVisible(true);
	}
	
	public Snake() {
		add(new Board());
	       
		setResizable(false);
	    pack();
	        
	    setTitle("Snake");
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class Board extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	//private final int SCALE = 1;
	private final int B_D = 600;
    private final int W_HEIGHT = 700;
    private final int DOT_SIZE = 20;
    private final int ALL_DOTS = 900;
    private final int RAND_POS = B_D / DOT_SIZE -1;
    private final int DELAY = 100;
    
    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private int dots = 3;
    private int apple_x;
    private int apple_y;
    private Integer points = 0;
    private String spoints;
    
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean gameCont = true;

    private Timer timer;

    public Board() {
    	System.out.println("Board is called");
        addKeyListener(new KeyListener());
        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(new Dimension(B_D, W_HEIGHT));
     
        initGame();
    }
    
    private void initGame() {
    	System.out.println("Game is starting");
       
        for (int z = 0; z < dots; z++) {
            x[z] = 2*DOT_SIZE - z * DOT_SIZE; 
            y[z] = 5*DOT_SIZE;
        }

        spawnApple();

        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    private void spawnApple() {
    	System.out.println("Generateing Apple location");
        int r = (int) (Math.random() * RAND_POS);
        apple_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        apple_y = ((r * DOT_SIZE));
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        if (gameCont) {
        	
        	g.setColor(Color.RED);
            g.fillRect(apple_x, apple_y, DOT_SIZE, DOT_SIZE);
            
            Font small = new Font("Helvetica", Font.BOLD, 50);
            g.setColor(Color.white);
            g.setFont(small);            
            spoints = points.toString();
            spoints = "Points: " + spoints; 
            g.drawString(spoints, 10 ,B_D + 50);
            
            g.drawLine(0, B_D, B_D, B_D);
            
            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                	g.setColor(Color.GREEN);
                    g.fillRect(x[z], y[z], DOT_SIZE,DOT_SIZE);
                } else {
                	g.setColor(Color.GRAY);
                    g.fillRect( x[z], y[z], DOT_SIZE,DOT_SIZE);
                }
            }

           

        } else {
       	             
            String msg = "Game Over";
            Font small = new Font("Helvetica", Font.BOLD, 50);
            FontMetrics metr = getFontMetrics(small);

            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(msg, (B_D - metr.stringWidth(msg)) / 2, W_HEIGHT / 2);
            g.drawString(spoints,(B_D - metr.stringWidth(spoints)) / 2 , W_HEIGHT / 2 +50);
           
        }        
    }
    
    private void collideApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {

            dots++;
            points++;
            spawnApple();
        }
    }
    
    private void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
    }
   
    private void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                gameCont = false;
            }
        }

        if (y[0] >= B_D) {
            gameCont = false;
        }

        if (y[0] < 0) {
            gameCont = false;
        }

        if (x[0] >= B_D) {
            gameCont = false;
        }

        if (x[0] < 0) {
            gameCont = false;
        }
        
        if(!gameCont) {
            timer.stop();
        }
    }
    
    public void actionPerformed(ActionEvent e) {

        if (gameCont) {

            collideApple();
            checkCollision();
            move();
        }

        repaint();
    }
    
    private class KeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }
}