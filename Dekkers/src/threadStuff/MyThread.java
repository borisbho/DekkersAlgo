package threadStuff;

import java.util.Random;

public class MyThread extends Thread {
	
	public static boolean RequestSection[] = {false, false};
	public static int sharedResource = 0;
	private static Random gen = new Random(0);
	public static int TaskID =0;
	private int OtherID;
	private int ThisID;

	public MyThread(int thisID, int otherID ) {
		ThisID = thisID;
		OtherID = otherID;
	}
	
	public void run() {
	
	TaskID = ThisID;
  	RequestSection[TaskID] = true;
	while(RequestSection[OtherID]) {
		if(TaskID != ThisID) {
			RequestSection[ThisID] = false;
			while(TaskID != ThisID) {
 
			}
			RequestSection[ThisID] = true;
		}	
	}
	criticalSection();
	TaskID = OtherID;
	RequestSection[ThisID] = false;
		
	}
	public void criticalSection() {
		int x = sharedResource;
		try {
			Thread.sleep(gen.nextInt(10));
		} 
		catch (InterruptedException ex) {}
		x++;
		sharedResource = x;
	}
	
}
