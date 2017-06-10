import java.awt.Graphics;

public class ballControl {
int  ballX=150;
int bally=150;
int speedX=5;
int speedY=5;

public void draw(Graphics g){
	g.drawOval(ballX, bally, 25, 25);
	g.fillOval(ballX, bally, 25, 25);
}
public void switchSpeed(){
	speedX+=-speedX;
	speedY+=-speedY;
}
public void update(){
	
	ballX+=speedX;
	bally+=speedY;
	
}

}
