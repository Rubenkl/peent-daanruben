import javax.swing.SwingUtilities;

//dit is een git testwt
public class Main {

	public static void main(String... args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Window();
			
			}
		});
	}
	
}
