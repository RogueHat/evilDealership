package network;

public class Reciever {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Network net = new Network();
		while(true)
			System.out.println(net.recieve(true));
	}

}
