package EVChargingStationSimulation;

import java.util.Date;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Station {
	public static int longestQueue=0;
	public Queue<Car> queue=new ConcurrentLinkedQueue<>();
	public Timer t;
	public int remainingTime;
	public long totalFreeTime;
	public long lastFreeTime;
	
	public Station () {
		lastFreeTime=System.currentTimeMillis();
		Thread t=new Thread() {
			public void run () {
				while (true) {
					if (remainingTime>0) remainingTime--;
					try { Thread.sleep(1000); } catch (InterruptedException e) {}
				}
			}
		};
		t.start();
	}
	private static class Task extends TimerTask {
		Station s;
		@Override
		public void run() {
			s.queue.poll();
			if (s.queue.peek()!=null) {
				s.update();
			} else {
				s.remainingTime=0;
				s.lastFreeTime=System.currentTimeMillis();
			}
		}
		
	}
	
	public void addCar (Car c) {
		queue.add(c);
		longestQueue=Math.max(longestQueue,queue.size());
		
		if (queue.size()==1) {
			totalFreeTime+=(System.currentTimeMillis()-lastFreeTime);
			update();
		}
	}
	
	private void update () {
		if (t!=null) t.purge();
		else t=new Timer();

		Task ts=new Task();
		ts.s=this;
		Car c=queue.peek();
		
		int temp=(int)(((c.batteryMax-c.currBattery)/Utility.ChargingRate)*60000);
		remainingTime=temp/1000;
		t.schedule(ts,new Date(System.currentTimeMillis()+temp));
	}
	
	public int getFreeTime() {
		if (queue.size()==0) {
			return (int)((totalFreeTime+(System.currentTimeMillis()-lastFreeTime))/1000);
		} else {
			return (int)(totalFreeTime/1000);
		}
	}
}
