package EVChargingStationSimulation;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class FrameStart extends JFrame {
	private static final long serialVersionUID = 1L;
	public JTextField textFieldRangeMax;
	public JTextField textFieldArrivalRate;
	public JComboBox<String> comboBoxStationCount;
	public JComboBox<String> comboBoxChargingRate;
	public JComboBox<String> comboBoxDuration;
	public JButton btnStart;
	public JTextField textFieldMeanCharged;
	public JTextField textFieldSDCharged;

	public FrameStart() {
		setBounds(100, 100, 395, 349);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		comboBoxStationCount = new JComboBox<>();
		comboBoxStationCount.setModel(new DefaultComboBoxModel<>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
		comboBoxStationCount.setBounds(138, 48, 175, 20);
		getContentPane().add(comboBoxStationCount);
		
		JLabel lblStationCount = new JLabel("Station Count :");
		lblStationCount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStationCount.setBounds(10, 51, 123, 14);
		getContentPane().add(lblStationCount);
		
		JLabel lblChargingRate = new JLabel("Charging Rate :");
		lblChargingRate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChargingRate.setBounds(10, 82, 123, 14);
		getContentPane().add(lblChargingRate);
		
		comboBoxChargingRate = new JComboBox<>();
		comboBoxChargingRate.setModel(new DefaultComboBoxModel<>(new String[] {"3 [Slow Chargers]", "7 [Fast Chargers - 1 Phase]", "22 [Fast Chargers - 3 Phases]", "43 [Rapid AC Chargers]", "50 [Rapid DC Chargers]"}));
		comboBoxChargingRate.setBounds(138, 79, 141, 20);
		getContentPane().add(comboBoxChargingRate);
		
		btnStart = new JButton("Start");
		btnStart.setBounds(138, 267, 89, 23);
		getContentPane().add(btnStart);
		
		JLabel lblArrivalRate = new JLabel("Arrival Rate :");
		lblArrivalRate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblArrivalRate.setBounds(10, 113, 123, 14);
		getContentPane().add(lblArrivalRate);
		
		textFieldRangeMax = new JTextField();
		textFieldRangeMax.setColumns(10);
		textFieldRangeMax.setBounds(138, 141, 141, 20);
		getContentPane().add(textFieldRangeMax);
		
		JLabel lblMaxCapacity = new JLabel("EV Max Capacity :");
		lblMaxCapacity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaxCapacity.setBounds(10, 144, 123, 14);
		getContentPane().add(lblMaxCapacity);
		
		textFieldArrivalRate = new JTextField();
		textFieldArrivalRate.setColumns(10);
		textFieldArrivalRate.setBounds(138, 110, 141, 20);
		getContentPane().add(textFieldArrivalRate);
		
		JLabel lblNewLabel = new JLabel("EV Charging Station Simulation");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 217, 26);
		getContentPane().add(lblNewLabel);
		
		JLabel lblKwh = new JLabel("kWh");
		lblKwh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKwh.setBounds(282, 82, 21, 14);
		getContentPane().add(lblKwh);
		
		JLabel label_1 = new JLabel("kWh");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(282, 144, 21, 14);
		getContentPane().add(label_1);
		
		comboBoxDuration = new JComboBox<>();
		comboBoxDuration.setModel(new DefaultComboBoxModel<>(new String[] {"3", "6", "24", "168 (1 week)", "5040 (1 month)"}));
		comboBoxDuration.setBounds(138, 236, 141, 20);
		getContentPane().add(comboBoxDuration);
		
		JLabel lblDuration = new JLabel("Duration :");
		lblDuration.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDuration.setBounds(15, 239, 118, 14);
		getContentPane().add(lblDuration);
		
		JLabel lblNewLabel_1 = new JLabel("hours");
		lblNewLabel_1.setBounds(282, 239, 36, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setHorizontalAlignment(SwingConstants.LEFT);
		lblMin.setBounds(282, 113, 21, 14);
		getContentPane().add(lblMin);
		
		textFieldMeanCharged = new JTextField();
		textFieldMeanCharged.setColumns(10);
		textFieldMeanCharged.setBounds(138, 172, 141, 20);
		getContentPane().add(textFieldMeanCharged);
		
		JLabel label_2 = new JLabel("%");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setBounds(282, 175, 21, 14);
		getContentPane().add(label_2);
		
		textFieldSDCharged = new JTextField();
		textFieldSDCharged.setColumns(10);
		textFieldSDCharged.setBounds(138, 203, 141, 20);
		getContentPane().add(textFieldSDCharged);
		
		JLabel label_3 = new JLabel("%");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setBounds(282, 206, 21, 14);
		getContentPane().add(label_3);
		
		JLabel lblEvMeanCharged = new JLabel("EV Mean Charged :");
		lblEvMeanCharged.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEvMeanCharged.setBounds(10, 175, 123, 14);
		getContentPane().add(lblEvMeanCharged);
		
		JLabel lblEvSdCharged = new JLabel("EV SD Charged :");
		lblEvSdCharged.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEvSdCharged.setBounds(10, 206, 123, 14);
		getContentPane().add(lblEvSdCharged);

	}
}
