import java.awt.Color;
import java.awt.Graphics;

public class ballControl {
	int ballX = 100;
	int bally = 100;
	int speedX = 5;
	int speedY = 5;

	public void draw(Graphics g) {
		g.drawOval(ballX, bally, 50, 50);
		g.setColor(Color.RED);
		g.fillOval(ballX, bally, 50, 50);
	}

	public void switchSpeed() {
		// speedX *= -1;
		speedY *= -1;
	}

	public void switchSpeedx() {
		speedX *= -1;

	}

	public void switchSpeedy() {

		speedY *= -1;
	}

	public void update() {

		ballX += speedX;
		bally += speedY;

	}

}
