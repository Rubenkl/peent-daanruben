import javax.swing.SwingUtilities;


public class Main {
	// testing
	public static void main(String... args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Window();
			
			}
		});
	}
	
}
