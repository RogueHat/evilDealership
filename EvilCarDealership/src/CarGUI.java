import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

public class CarGUI extends JFrame implements Runnable {
	private JLabel labels/*, output*/;
	private JTextArea list,output;
	private JScrollPane listPane;
	//private ArrayList<JLabel> list = new ArrayList<JLabel>();
	private JMenuItem pause, showList;
	private JMenuBar bar;
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

		output = new JTextArea(10,15);
		output.setLineWrap(true);
		output.setWrapStyleWord( true );
		output.setFont(new Font("Serif", Font.BOLD, 20));
		add(output);

		bar = new JMenuBar();
		
		pause = new JMenuItem("Start");
		bar.add(pause);

		showList = new JMenuItem("Show Offense List");
		bar.add(showList);
		
		setJMenuBar(bar);

		list = new JTextArea(17,31);
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
					pause.setText("Start");
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
				//Thread.currentThread().sleep(time/2);
				Thread.currentThread().sleep(1000);
				
				if(!isPaused){
					hoboKiller.move(new File("carRead.txt"));
					charge.payUp(time);
					output.setText("time =\t"+time+"\n"+hoboKiller+"\n"+charge+"\n");
					
					time++;
				}
				this.pack();
			}
		}catch(Exception er){
			System.err.println(er);
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
