Priyanka Atreya
CS281 - Computer Networks
Assignment0 - HelloWorld

Inserting the logs into the lifecycle methods helped track which stages the Hello World app was in at different points in the app execution.  

I noticed that each time the screen was rotated, the following block of methods occured:

	onPause
	onStart
	onDestroy
	onCreate
	onStart
	onResume

I am guessing this pattern occurs because:

the pre-rotating app is waiting for something to happen [paused], 
then it [starts] and [destroys] itself to allow itself to [create] the new version (rotated).  
Then the new version is [started] and [resumed].




