package chat;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

import network.Network;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class NetworkDraw extends JPanel implements Runnable{
	
	private Network net = new Network();
	private Scanner scan;
	
	public NetworkDraw() {
		setBackground(Color.WHITE);		
		setVisible(true);
		new Thread(this).start();
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		window.setColor(Color.WHITE);
		window.fillRect(0, 0, getWidth(), getHeight());
		window.setColor(Color.black);
		scan = new Scanner(net.recieve(false));
		int x = scan.nextInt();
		int y = scan.nextInt();
		System.out.println(x+" "+y);
		window.fillRect(x,y,x+50,y+50);
	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread();
				Thread.sleep(10);
				repaint();
			}
		} catch (Exception e) {
		}
	}

}
