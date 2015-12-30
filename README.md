#HOW TO WRITE AN ANIMATION GAME

This is done using the HSA GraphicsConsole so that you don't have to learn Java Swing Graphics first.

----

*Important*
I'm making "commits" in Git/GitHub for each major improvement. 
Please start at the first one, and go through them so that you understand what is happening.

##3. Adding a paddle, moving it, collisions

* Font: fixed up
* Ball bouncing off screen fixed. You need to figure out why this was happening and why the fix worked.
* Ball starting location: meh... I'm not going to bother doing that.

### Paddle

The simplest way to see if things collide:boom: is if they are both rectangles. Notice that the Ball still has its own class, but the paddle doesn't.
They are both rectangles, but the paddle doesn't have any special properties, whereas the ball does. Furthermore, we're never having more than one paddle.
If we were, it would be most convenient if we made the paddle in to a class.

Read the comments about the initialize() method in the code.
You can also use GitHub to look at the differences between the commits to see what has changed.

Paddle is set up to move by using the mouse or using the keyboard. Just uncomment whichever method you want to use.
Note that the keyboard moving still needs a bit of fixing up: you can move the paddle off of the right side of the screen!
