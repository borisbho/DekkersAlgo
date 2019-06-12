package threadStuff;

public class ThreadDriver {
 
	public static void main(String[] args) {
		 MyThread t1 = new MyThread(0,1);
		 MyThread t2 = new MyThread(1,0);
		 
		 System.out.println(MyThread.sharedResource);
		 t1.start();
		 t2.start();
		 try {
			 Thread.sleep(200);
		 }
		 catch(InterruptedException ex) {}
		 System.out.println(MyThread.sharedResource);
	}
}
