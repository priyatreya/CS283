README.txt - Assignment1
Priyanka Atreya
CS283 - Networks
2/17/14


1.  Design of the benchmark client

My benchmark client created 5 threads and started each of them.  The threads each ran for 1000 milliseconds.  During that time, they ran a while-loop in which they connected to the socket, printed "hello world" to the PrintStream, waited to get it back from the server, and then printed out a '1' to the console.  Additionally, I had each thread sleep for 10 milliseconds before printing the 1 to better show the gains of the multithreaded server.

2.  Outputs

After the benchmark ran, there would be a list on 1's on the console.  I put it into a Word document to count the 1's - this number signified the amount of work the client could do in 1000 milliseconds for each server.  For both the simple server and the multithreaded server, I ran the benchmark client 5 times to get an average.  Here are the results:

Simple Server - 		
91
94
92
92
94
---> AVERAGE: 92.6 

Multithreaded Server - 
438
414
424
433
437
---> AVERAGE: 429.2	

3.  Reasoning for why multithreaded performs better
	
The multithreaded server performs better because multiple threads are spawned to handle the work.  Thus, other threads can do work while the delay from sending the information from the server to client occurs.  In the simple server, however, the server must wait until the information is sent to send anything else, causing a delay.