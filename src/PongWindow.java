import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PongWindow extends JPanel implements KeyListener  {
	int frameHeight=500;
	int frameWidth=500;
	int paddleX=250;
JFrame frame= new JFrame();
void run(){
	frame.add(this);
	frame.setVisible(true);
	frame.setSize(frameWidth, frameHeight);
	frame.addKeyListener(this);
	
}

public void paintComponent(Graphics g){
	g.drawOval(250, 425, 25, 25);
	g.fillOval(250, 425, 25, 25);
	g.drawRect(paddleX, 450, 80, 10);
	g.setColor(Color.BLUE);
	g.fillRect(paddleX, 450, 80, 10);
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
	System.out.println(e.getKeyCode());
	if(e.getKeyCode()==65){
		paddleX-=50;
		this.repaint();
		System.out.println(paddleX);
	}
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}


}
