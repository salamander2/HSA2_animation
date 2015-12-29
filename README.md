#HOW TO WRITE AN ANIMATION GAME

This is done using the HSA GraphicsConsole so that you don't have to learn Java Swing Graphics first.

----

*Important*
I'm making "commits" in Git/GitHub for each major improvement. 
Please start at the first one, and go through them so that you understand what is happening.

##2. Making a ball move. Making it bounce off the edges of the screen

* The ball is a separate object (with a separate class Ball.java). This is because the ball has properties that it should maintain
and that we want to change. We can also create multiple balls this way.
* Notice some new global variables: lives, isPlaying (this will be used to end the game)
* Notice some constants. These make it easy to change numbers in the code without having to do search and replace.
* A **game loop** has been added. This is a standard way of doing things. 
* The sleep() function is ESSENTIAL. This allows the computer to do other things. It also varies the speed of the game
  * ball.xspeed and ball.yspeed are how many pixels the ball moves each time. If this number is larger, the ball moves faster. 
  However, it also becomes more jerky because it actually jumps this number of pixels.
  * So, keep the xspeed small, and vary the game speed by changing SLEEPTIME. It is in milliseconds
* Interesting, both a capital or lowercase Q will end the game.

  ---
 
 Okay, I've also made it so that when the ball hits the bottom of the screen, you lose a life and the ball changes colour.
 
 ##Next time:
 
 :one: I'm going to make a nicer font in the next release so that the text looks better.
 :two: Notice how the ball actually goes off the screen on the right and bottom. This needs fixing.
 :three: Let's draw a rectangle to make sure that the ball actually starts in the place that we want it to.
 