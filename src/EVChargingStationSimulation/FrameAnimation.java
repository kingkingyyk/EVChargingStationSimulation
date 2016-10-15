package EVChargingStationSimulation;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;

public class FrameAnimation extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblStation0;
	private JLabel lblStation1;
	private JLabel lblStation2;
	private JLabel lblStation3;
	private JLabel lblStation4;
	private JLabel lblStation5;
	private JLabel lblStation6;
	private JLabel lblStation7;
	private JLabel lblStation0X;
	private JLabel lblStation1X;
	private JLabel lblStation2X;
	private JLabel lblStation3X;
	private JLabel lblStation4X;
	private JLabel lblStation5X;
	private JLabel lblStation6X;
	private JLabel lblStation7X;
	private JLabel [] stationX=new JLabel[8];
	public JLabel [] station=new JLabel[8];
	public JLabel lblCountdown;

	public FrameAnimation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new FrameAnimationPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 644, 424);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblStation0 = new JLabel("");
		lblStation0.setBounds(10, 43, 20, 20);
		lblStation0.setIcon(Utility.getChargingStationIcon());
		panel.add(lblStation0);
		
		lblStation1 = new JLabel("");
		lblStation1.setBounds(87, 43, 20, 20);
		lblStation1.setIcon(Utility.getChargingStationIcon());
		panel.add(lblStation1);
		
		lblStation2 = new JLabel("");
		lblStation2.setBounds(160, 43, 20, 20);
		lblStation2.setIcon(Utility.getChargingStationIcon());
		panel.add(lblStation2);
		
		lblStation3 = new JLabel("");
		lblStation3.setBounds(249, 43, 20, 20);
		lblStation3.setIcon(Utility.getChargingStationIcon());
		panel.add(lblStation3);
		
		lblStation4 = new JLabel("");
		lblStation4.setBounds(333, 43, 20, 20);
		lblStation4.setIcon(Utility.getChargingStationIcon());
		panel.add(lblStation4);
		
		lblStation5 = new JLabel("");
		lblStation5.setBounds(408, 43, 20, 20);
		lblStation5.setIcon(Utility.getChargingStationIcon());
		panel.add(lblStation5);
		
		lblStation6 = new JLabel("");
		lblStation6.setBounds(488, 43, 20, 20);
		lblStation6.setIcon(Utility.getChargingStationIcon());
		panel.add(lblStation6);
		
		lblStation7 = new JLabel("");
		lblStation7.setBounds(564, 43, 20, 20);
		lblStation7.setIcon(Utility.getChargingStationIcon());
		panel.add(lblStation7);
		
		station[0]=lblStation0;
		station[1]=lblStation1;
		station[2]=lblStation2;
		station[3]=lblStation3;
		station[4]=lblStation4;
		station[5]=lblStation5;
		station[6]=lblStation6;
		station[7]=lblStation7;
		
		lblStation0X = new JLabel("");
		lblStation0X.setBounds(10, 21, 67, 14);
		panel.add(lblStation0X);
		
		lblStation1X = new JLabel("");
		lblStation1X.setBounds(87, 21, 63, 14);
		panel.add(lblStation1X);
		
		lblStation2X = new JLabel("");
		lblStation2X.setBounds(160, 21, 79, 14);
		panel.add(lblStation2X);
		
		lblStation3X = new JLabel("");
		lblStation3X.setBounds(249, 21, 74, 14);
		panel.add(lblStation3X);
		
		lblStation4X = new JLabel("");
		lblStation4X.setBounds(333, 21, 65, 14);
		panel.add(lblStation4X);
		
		lblStation5X = new JLabel("");
		lblStation5X.setBounds(408, 21, 70, 14);
		panel.add(lblStation5X);
		
		lblStation6X = new JLabel("");
		lblStation6X.setBounds(488, 21, 66, 14);
		panel.add(lblStation6X);
		
		lblStation7X = new JLabel("");
		lblStation7X.setBounds(564, 21, 70, 14);
		panel.add(lblStation7X);
		
		stationX[0]=lblStation0X;
		stationX[1]=lblStation1X;
		stationX[2]=lblStation2X;
		stationX[3]=lblStation3X;
		stationX[4]=lblStation4X;
		stationX[5]=lblStation5X;
		stationX[6]=lblStation6X;
		stationX[7]=lblStation7X;
		
		lblCountdown = new JLabel("Finish In : ");
		lblCountdown.setBounds(10, 440, 175, 14);
		contentPane.add(lblCountdown);
		
		for (int i=EVChargingStationSimulation.stations.size();i<stationX.length;i++) {
			stationX[i].setText("<html><font color=red>CLOSED</font></html>");
		}
	}
}
