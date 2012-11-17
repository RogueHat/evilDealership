import javax.swing.*;

public class guiTest extends JFrame {
	private static final int WIDTH = 1600;
	private static final int HEIGHT = 100;

	public guiTest()
	{
		super("MAKE YOUR OWN SHAPE");

		setSize(WIDTH,HEIGHT);
		
		Car hoboKiller = new Car("57862347");
		getContentPane().add(new Panel(hoboKiller));

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main( String args[] )
	{
		guiTest run = new guiTest();
	}
}
