package EVChargingStationSimulation;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class Utility {

	public static Random r=new Random();
	public static double MinBatteryCap=20;
	public static double MaxBatteryCap;
	public static double ArrivalRate;
	public static double ChargingRate;
	public static int Duration;
	public static double BatteryLevelMean;
	public static double BatteryLevelSD;
	
    public static ImageIcon resizeImageIcon (ImageIcon ic, int width, int height) {
    	return new ImageIcon(ic.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }
    
    public static ImageIcon getChargingStationIcon () {
		return Utility.resizeImageIcon(new ImageIcon(Utility.class.getResource("/station.png")),20,20);
    }
    
    public static Image getCarImage () {
		return Utility.resizeImageIcon(new ImageIcon(Utility.class.getResource("/car.png")),20,20).getImage();
    }
    
	public static int getNextArrivalDelay() {
		//Poisson distribution
	    double L = Math.exp(-ArrivalRate);
	    int k = 0;
	    double p = 1.0;
	    do {
	        p = p * r.nextDouble();
	        k++;
	    } while (p > L);
	    return k - 1;
	}
	
	public static double getBatteryCapRandom () {
		return Math.abs(r.nextGaussian())*(MaxBatteryCap-MinBatteryCap)+MinBatteryCap;
	}
	
	public static double getBatteryLevelRandom () {
		//Normal distribution
		return r.nextGaussian()*BatteryLevelSD+BatteryLevelMean;
	}
}
