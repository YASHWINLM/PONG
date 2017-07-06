import javax.swing.JOptionPane;

public class PongMain {
public static void main(String[] args) {
	PongMain pong= new PongMain();
	pong.run();
}
void run(){
	PongWindow window= new PongWindow();
	JOptionPane.showMessageDialog(null, "Use 'a to move right, and 'd' to move left");
	window.run();
	 
	ballControl ball= new ballControl();
	
	
	
	
	
}
}
