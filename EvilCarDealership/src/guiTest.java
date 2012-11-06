import javax.swing.*;

public class guiTest extends JFrame {
	JFrame frame;
	JPanel panel;
	JTextField field;

	public guiTest() {
		super("GUI test");
		frame = this;
		panel = new JPanel();
		field = new JTextField("Hello Biotches", 10);
		frame.add(panel);
		panel.add(field);
	}

	public static void main(String[] args) {
		guiTest window = new guiTest();
		window.pack();
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
