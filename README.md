#HOW TO WRITE AN ANIMATION GAME

This is done using the HSA GraphicsConsole so that you don't have to learn Java Swing Graphics first.

----

*Important*
I'm making "commits" in Git/GitHub for each major improvement. 
Please start at the first one, and go through them so that you understand what is happening.

##4. Paddle collision

Well, that was easy! Just use the Rectangle.intersects() method.

Note that this does not really do collisions properly. 
* The ball is treated as a rectangle, so the corners of the rectangle are quite far from the circle denoting the ball. I've drawn a square around the ball so you can see how this works.
* There is no complex bouncing coded. For example, if you hit the ball at the ends of the paddle it should bounce differently from if you hit it 
with the middle of the paddle. I may try and code this just for fun. 