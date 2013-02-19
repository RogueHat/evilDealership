package network;

import java.util.Scanner;

public class Sender {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Network net = new Network();
		while(true)
			net.send(scan.nextLine());
			
	}

}
