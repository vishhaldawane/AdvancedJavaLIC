import java.util.Iterator;

public class PingPongTest {
	public static void main(String[] args) {
		Message m1 = new Message("Car",1,20);
		Message m2 = new Message("\tBike",1,10);
		Message m3 = new Message("\t\tBus",1,5);
		
		m1.start(); //-->talks to thread scheduler of the JVM
		m2.start();
		m3.start();
	}
}

class Message extends Thread //1
{
	String msg;
	int start;
	int end;
	public Message(String m, int s, int e) {
		msg = m;
		start =s ;
		end = e;
	}
	public void run() { //2
		for (int i = start; i <=end; i++) {
			System.out.println(msg);
			/*
			 * try { Thread.sleep(1000); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
		}
	}
}
