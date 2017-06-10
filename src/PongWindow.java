import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PongWindow extends JPanel implements KeyListener, ActionListener  {
	int frameHeight=500;
	int frameWidth=500;
	int paddleX=250;
	int paddleY= 450;
	int paddleLegnth=80;
	int paddleheight=10;
	ballControl ball= new ballControl();
	Timer timer= new Timer(1000/60, this);
	
JFrame frame= new JFrame();
void run(){
	frame.add(this);
	frame.setVisible(true);
	frame.setSize(frameWidth, frameHeight);
	frame.addKeyListener(this);
	timer.start();
	ball.bally+=ball.speedY;
}



public void paintComponent(Graphics g){
	ball.draw(g);
	g.drawRect(paddleX, paddleY, paddleLegnth, paddleheight);
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
	if(e.getKeyCode()==68){
		paddleX+=50;
		this.repaint();
		System.out.println(paddleX);
	}
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}



@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	ball.update();
	repaint();
	if(ball.ballX<paddleX&& ball.ballX>paddleX+paddleLegnth&&ball.bally<paddleY&&ball.bally>paddleY+paddleheight){
		ball.switchSpeed();
		
		
	}
	
}


}
