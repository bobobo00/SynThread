package SyThread;
/**
 * 线程安全：在并发时保证数据的正确性，效率尽可能高
 * synchronized:
 * 1,
 * @author dell
 *
 */

public class SynThread {
	public static void main(String[] args) {
		Web12306 w=new Web12306();
		Thread t1=new Thread(w);
		Thread t2=new Thread(w);
		Thread t3=new Thread(w);
		t1.start();
		t2.start();
		t3.start();
	}

}
class Web12306 implements Runnable {
	private int ticketNums=100;
	private boolean flag=true;
	@Override
	public void run() {
		while(flag) {
			set();
		}
	}
	private synchronized void set() {
		if(ticketNums<=0) {
			flag=false;
			return;
		}else {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			System.out.println(Thread.currentThread().getName()+"——》"+ticketNums--);
		}
	}
}
