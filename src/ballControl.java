import java.awt.Color;
import java.awt.Graphics;

public class ballControl {
	int ballX = 50;
	int bally = 50;
	int speedX = 5;
	int speedY = 5;

	public void draw(Graphics g) {
		g.drawOval(ballX, bally, 25, 25);
		g.setColor(Color.RED);
		g.fillOval(ballX, bally, 25, 25);
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
