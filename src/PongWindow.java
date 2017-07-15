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
	int frameHeight = 1024;
	int frameWidth = 1024;
	int paddleX = 500;
	int paddleY = 900;
	int width = 160;
	int Height = 20;
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

	public void reset() {
		paddleX = 500;
		paddleY = 900;
		ball.ballX = 100;
		ball.bally = 100;
		ball.speedX = 5;
		ball.speedY = 5;
	}

	public void paintComponent(Graphics g) {
		g.drawRect(0, 0, 1024, 1024);
		g.fillRect(0, 0, 1024, 1024);
		if (!GameEnded) {
			ball.draw(g);
			g.drawRect(paddleX, paddleY, width, Height);
			g.setColor(Color.BLUE);
			g.fillRect(paddleX, 900, 160, 20);

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
		if (e.getKeyCode() == 32 && GameEnded) {
			this.reset();
			GameEnded = false;
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
		if (ball.ballX > paddleX && ball.ballX < paddleX + width && ball.bally > paddleY
				&& ball.bally < paddleY + Height) {
			ball.switchSpeed();
			score++;
		}

		if (ball.ballX > 1024 && ball.bally > 1024) {
			JOptionPane.showMessageDialog(null, "GAME OVER!");
			JOptionPane.showMessageDialog(null, "Press space to restart");

			GameEnded = true;
		}

		if (ball.bally < 0) {
			ball.switchSpeedy();
		}
		if (ball.ballX > 1024 || ball.ballX < 0) {
			ball.switchSpeedx();
		}

	}

}
