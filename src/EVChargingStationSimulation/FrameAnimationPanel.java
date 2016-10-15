package EVChargingStationSimulation;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class FrameAnimationPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int i=0;i<EVChargingStationSimulation.stations.size();i++) {
			Station s=EVChargingStationSimulation.stations.get(i);
			int size=s.queue.size();
			for (int i2=0;i2<Math.min(12,size);i2++) {
				g.drawImage(Utility.getCarImage(),EVChargingStationSimulation.fa.station[i].getX()+20,i2*30+50,Color.WHITE,null);
			}
			if (size>12) {
				g.drawString("+"+(size-12),EVChargingStationSimulation.fa.station[i].getX()+20,12*30+50);
			}
			if (size>0) {
				g.drawString(s.remainingTime+" m",EVChargingStationSimulation.fa.station[i].getX()+20,50);
			}
		}
	}
}
