import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PongWindow extends JPanel implements KeyListener, ActionListener {
	int frameHeight = 500;
	int frameWidth = 500;
	int paddleX = 250;
	int paddleY = 450;
	int width = 80;
	int Height = 10;
	int score = 0;
	boolean GameEnded = false;
	ballControl ball = new ballControl();
	Timer timer = new Timer(1000 / 60, this);

	JFrame frame = new JFrame();

	void run() {
		frame.add(this);
		frame.setVisible(true);
		frame.setSize(frameWidth, frameHeight);
		frame.addKeyListener(this);
		timer.start();
		ball.bally += ball.speedY;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public void reset(){
		 paddleX = 250;
		 paddleY = 450;
		ball.ballX = 50;
		ball.bally = 50;
		 ball.speedX = 5;
		ball.speedY = 5;
}
	public void paintComponent(Graphics g) {
		g.drawRect(0, 0, 500, 500);
		g.fillRect(0, 0, 500, 500);
		if (!GameEnded) {
			ball.draw(g);
			g.drawRect(paddleX, paddleY, width, Height);
			g.setColor(Color.BLUE);
			g.fillRect(paddleX, 450, 80, 10);

		} else {
			g.setFont(new Font("Arial", 3, 18));
			g.setColor(Color.RED);
			g.drawString("Your score is " + score, 150, 150);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 65) {
			paddleX -= 50;
			this.repaint();
			System.out.println(paddleX);
		}
		if (e.getKeyCode() == 68) {
			paddleX += 50;
			this.repaint();
			System.out.println(paddleX);
		}
		if(e.getKeyCode()==32 && GameEnded){
			this.reset();
		GameEnded=false;
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
		if (ball.ballX+12.5 > paddleX && ball.ballX+12.5 < paddleX + width && ball.bally+12.5 > paddleY
				&& ball.bally < paddleY + Height) {
			ball.switchSpeed();
			score++;
		}

		if (ball.ballX > 500 && ball.bally > 500) {
			JOptionPane.showMessageDialog(null, "GAME OVER!");
			JOptionPane.showMessageDialog(null, "Press space to restart");

			GameEnded = true;
		}

		if (ball.bally < 0) {
			ball.switchSpeedy();
		}
		if (ball.ballX > 500 || ball.ballX < 0) {
			ball.switchSpeedx();
		}

	}

}
