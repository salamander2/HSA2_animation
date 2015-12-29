package animation;

//Always check to make sure that Eclipse hasn't added in some weird import. It tends to do that when you cut and paste code.
import hsa2.GraphicsConsole;
import java.awt.Color;

public class AnimationMain {

	public static void main(String[] args) {
		new AnimationMain();
	}
	
	/***** Global (instance) Variables ******/
	GraphicsConsole gc = new GraphicsConsole (800,600);
	int ballx, bally;
	int ballSize = 30;
	
	/****** Constructor ********/
	AnimationMain() {
		initialize();	//ie. setup.
		drawGraphics();
	}
	
	/****** Methods for game *******/	
	void initialize() {
		ballx = gc.getDrawWidth()/2;
		bally = 100;
		gc.setAntiAlias(true);
		gc.setBackgroundColor(Color.BLACK);
		gc.clear();	//this must be done for the background colour to take effect
	}
	
	void drawGraphics() {
		gc.setColor(Color.RED);
		gc.fillOval(ballx, bally, ballSize, ballSize);
	}
}
