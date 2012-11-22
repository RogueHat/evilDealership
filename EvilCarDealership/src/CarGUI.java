import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

public class CarGUI extends JFrame implements Runnable {
	private JLabel labels, output;
	private JTextArea list;
	private JScrollPane listPane;
	//private ArrayList<JLabel> list = new ArrayList<JLabel>();
	private JButton pause, showList;
	private boolean isPaused=true;
	private Car hoboKiller;
	private int time = 1;
	public Charges charge;

	public CarGUI(Car newCar) {
		
		hoboKiller = newCar;
		charge = new Charges(hoboKiller);

		setLayout(new GridBagLayout());
		// labels= new JLabel("");
		// add(labels);

		output = new JLabel();
		output.setFont(new Font("Serif", Font.BOLD, 20));
		add(output);

		pause = new JButton("Start");
		add(pause);

		showList = new JButton("Show Offense List");
		add(showList);

		list = new JTextArea(20,40);
		list.setLineWrap(true);
		list.setWrapStyleWord( true );
		listPane = new JScrollPane(list);
		add(listPane);

		event e = new event();
		pause.addActionListener(e);
		showList.addActionListener(e);
		
		new Thread(this).start();
	}

	public class event implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == pause) {
				if (isPaused) {
					isPaused = false;
					pause.setText("Pause");
				} else {
					isPaused = true;
					pause.setText("Starte");
				}
			}
			if (e.getSource() == showList) {
				list.setText(charge.getList());
			}
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(true){
				Thread.currentThread().sleep(time/2);
				
				if(!isPaused){
					hoboKiller.update(new File("carRead.txt"));
					charge.payUp(time);
					output.setText(hoboKiller.toString()+"\t "+charge.toString()+"\n");
					
					time++;
				}
				this.pack();
			}
		}catch(Exception er){
			
		}
	}
	
	public static void main (String[]args){
		CarGUI gui =  new CarGUI(new Car());
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//gui.setSize(1600,800);
		gui.pack();
		gui.setVisible(true);
	}

}
