import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.util.Scanner;

import javax.swing.JPanel;



public class Panel extends JPanel implements Runnable {;
	Car car;
	Scanner listen;

	public Panel(Car newCar) {
		setBackground(Color.WHITE);
		setVisible(true);
		car=newCar;
		
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
		window.drawString(car.toString(), 40, 40);
	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(0);
				listen = new Scanner(new File("carRead.txt"));
				listen.useDelimiter("\\z");
				car.update(listen.next());
				repaint();
			}
		} catch (Exception e) {
		}
	}
}
