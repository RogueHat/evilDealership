import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.util.Scanner;

import javax.swing.JPanel;



public class Panel extends JPanel implements Runnable {;
	Car car;
	Scanner listen;
	int minutes;

	public Panel(Car newCar) {
		setBackground(Color.WHITE);
		setVisible(true);
		car=newCar;
		minutes=0;
		
		new Thread(this).start();
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		window.setColor(Color.black);
		window.fillRect(0, 0, getWidth(), getHeight());
		window.setColor(Color.gray);
		window.setFont(new Font("TAHOMA",Font.BOLD,30));
		window.drawString(car.toString()+" time = "+minutes, 40, 40);
		minutes++;
	}

	public void run() {
		try {
			while (true) {
				
				Thread.currentThread().sleep(100);
				listen = new Scanner(new File("carRead.txt"));
				listen.useDelimiter("\\z");
				car.update(listen.next());
				repaint();
			}
		} catch (Exception e) {
		}
	}
}
