import java.awt.BorderLayout;

import javax.swing.*;

public class guiTest extends JFrame {
	private static final int WIDTH = 1600;
	private static final int HEIGHT = 200;

	public guiTest()
	{
		super("MAKE YOUR OWN SHAPE");

		setSize(WIDTH,HEIGHT);
		
		Car hoboKiller = new Car("57862347");
		Panel pnl = new Panel(hoboKiller);
		getContentPane().add(pnl);
		

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		guiTest run = new guiTest();
	}
}
