package EVChargingStationSimulation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class EVChargingStationSimulation {
	
	public static ArrayList<Station> stations=new ArrayList<>();
	public static FrameAnimation fa;
	public static boolean simulationStop=false;
	
	public static void main (String [] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {}
		
		FrameStart f=new FrameStart();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
		f.btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Utility.ChargingRate=Double.parseDouble(new StringTokenizer((String)f.comboBoxChargingRate.getSelectedItem()).nextToken());
				Utility.Duration=Integer.parseInt(new StringTokenizer((String)f.comboBoxDuration.getSelectedItem()).nextToken());
				Utility.MaxBatteryCap=Double.parseDouble(f.textFieldRangeMax.getText());
				Utility.BatteryLevelMean=Double.parseDouble(f.textFieldMeanCharged.getText())/100;
				Utility.BatteryLevelSD=Double.parseDouble(f.textFieldSDCharged.getText())/100;
				Utility.ArrivalRate=Double.parseDouble(f.textFieldArrivalRate.getText());
				f.dispose();
			}
		});
		
		while (f.isVisible()) {try {Thread.sleep(100); } catch(InterruptedException e){}}
		
		int count=Integer.parseInt((String)f.comboBoxStationCount.getSelectedItem());
		for (int i=0;i<count;i++) {
			stations.add(new Station());
		}
		
		fa=new FrameAnimation();
		fa.setLocationRelativeTo(null);
		fa.setVisible(true);
		
		Thread t=new Thread() {
			public void run () {
				while (!simulationStop) {
					Car c=new Car();
					c.batteryMax=Utility.getBatteryCapRandom();
					c.currBattery=Utility.getBatteryLevelRandom()*c.batteryMax;
					int min=Integer.MAX_VALUE;
					for (Station s : stations) {
						if (s.queue.size()<min) {
							min=s.queue.size();
						}
					}
					
					ArrayList<Station> feasibleStations=new ArrayList<>();
					for (Station s : stations) if (s.queue.size()<=min) feasibleStations.add(s);
					
					feasibleStations.get(Utility.r.nextInt(feasibleStations.size())).addCar(c);
					feasibleStations.clear();
					try { Thread.sleep(Utility.getNextArrivalDelay()*1000); } catch (InterruptedException e) {}
				}
			}
		};
		t.start();
		
		t=new Thread() {
			public void run () {
				while (!simulationStop) {
					fa.repaint();
					try { Thread.sleep(33); } catch (InterruptedException e) {}
				}
			}
		};
		t.start();
		
		t=new Thread() {
			public void run () {
				int countdown=Utility.Duration*60;
				while (countdown>0) {
					countdown--;
					fa.lblCountdown.setText("Finish in "+countdown+" s");
					try { Thread.sleep(1000); } catch (InterruptedException e) {}
				}
				simulationStop=true;
				
				double busyTime=0;
				for (Station s : stations) {
					busyTime+=Utility.Duration*60-s.getFreeTime();
				}
				busyTime/=(Utility.Duration*60*stations.size());
				busyTime*=100;
				JOptionPane.showMessageDialog(null,"Longest Queue : "+Station.longestQueue+"\nAverage BusyTime : "+String.format("%.2f",busyTime)+"%","Result",JOptionPane.INFORMATION_MESSAGE);
			}
		};
		t.start();
	}

}
