package animation;

//Always check to make sure that Eclipse hasn't added in some weird import. It tends to do that when you cut and paste code.
import hsa2.GraphicsConsole;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

public class AnimationMain {

	public static void main(String[] args) {
		new AnimationMain();
	}

	/***** Constants *****/
	static final int SLEEPTIME = 10;
	static final int GRWIDTH = 800;
	static final int GRHEIGHT = 600;
	static final Color PADDLECOLOUR = Color.YELLOW;	//so it's really easy to find and change when needed 

	/***** Global (instance) Variables ******/
	GraphicsConsole gc = new GraphicsConsole (GRWIDTH, GRHEIGHT);
	Ball ball = new Ball(GRWIDTH, 100);
	Rectangle paddle = new Rectangle(0,0,100,16);	//set width and height here
	int lives;
	boolean isPlaying = true;

	/****** Constructor ********/
	AnimationMain() {
		initialize();

		//main game loop
		while (gc.getKeyCode()  != 'Q' && isPlaying) {		//press q to quit

			//movePaddle_mouse();
			movePaddle_keys();
			
			moveBall();
			
			drawGraphics();

			gc.sleep(SLEEPTIME);

			if (lives <= 0) isPlaying = false;
		}
		gc.drawString("GAME OVER", 30, 30);
	}

	/****** Methods for game *******/
	/* These are things that are only done once. 
	 * They should not be done over and over in a loop as they will either slow the program down or screw it up.
	 * Putting all of the initialization in a separate method is useful because then it is really easy to restart the game.
	 */
	void initialize() {
		//set up gc
		gc.setFont(new Font("Georgia", Font.PLAIN, 25));
		gc.setAntiAlias(true);
		gc.setBackgroundColor(Color.BLACK);
		gc.enableMouseMotion(); //only needed for mouse (obviously)
		gc.clear();
		
		//set up variables
		lives = 4;
		isPlaying = true;
		
		//set up objects		
		paddle.x = GRWIDTH/2;
		paddle.y = GRHEIGHT - 100;
		ball.resetXY(); // This is totally unnecessary unless you restart and need to reset the ball position and speed.
		
		gc.sleep(500); // allow a bit of time for the user to move the mouse to the correct position in the game screen
	}

	/**
	 * This method moves the ball and handles all collisions where the ball hits something.
	 * Don't make a separate method to see if the paddle hits the ball.
	 */
	void moveBall() {
		ball.x += ball.xspeed;
		ball.y += ball.yspeed;
		
		//bounce off bottom of screen		
		if ((ball.y + ball.diameter) > gc.getDrawHeight()) {
			ball.yspeed *=-1;
			lives--;
			ball.colour = new Color(Color.HSBtoRGB((float)Math.random(), 1.0f, 1.0f));
		}
		
		//right side of screen
		if ((ball.x + ball.diameter) > gc.getDrawWidth()) {
			ball.xspeed *=-1;
		}
		//top of screen
		if (ball.y < 0) {
			ball.yspeed *=-1;
			ball.yspeed++;
			
		}
		//left side of screen
		if (ball.x < 0) {
			ball.xspeed *=-1;
		}
		
		//check if ball hits paddle
		if (ball.intersects(paddle)) {
			if (ball.yspeed > 0 ) {			//the ball must be moving downwards, not upwards
					ball.yspeed *=-1;
			}
		}		
	}	

	void movePaddle_mouse(){
		paddle.x = gc.getMouseX() - paddle.width/2;
	}
	
	void movePaddle_keys(){
		int moveAmount = 7;
		//37 and 39 are the keyboard codes for the left and right arrow keys.
		if (gc.getKeyCode() == 37) paddle.x -= moveAmount;
		if (gc.getKeyCode() == 39) paddle.x += moveAmount;
		
		//check to prevent moving the paddle off the screen
		if (paddle.x < 0) paddle.x = 0;
		//now you need to figure out how to to the same for the right side of the screen (I did the easy one!)
		//...
	}
	
	void drawGraphics() {
		//clear screen and redraw everything
		synchronized(gc) {
			gc.clear();	
			
			gc.setColor(Color.WHITE);
			gc.drawString("LIVES = " + lives, 30, 70);
			gc.setColor(ball.colour);
			gc.fillOval(ball.x, ball.y, ball.width, ball.height);
			//DEBUG
			gc.setColor(Color.WHITE);
			gc.drawRect(ball.x, ball.y, ball.width, ball.height);
			//END DEBUG
			gc.setColor(PADDLECOLOUR);
			gc.fillRoundRect(paddle.x, paddle.y, paddle.width, paddle.height, 10,10);
		}
	}
}
