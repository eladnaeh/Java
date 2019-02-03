import java.awt.*;
import java.awt.event.KeyListener;
import java.util.Random;

public class Ball{

    private int BallposX = 390;
    private int BallposY = 390;
    private int xVel = 3;
    private int yVel = -2;

    public void move(){

        BallposX += xVel;
        BallposY += yVel;

        if(BallposY < 0){
            yVel = -yVel;
        }
        if(BallposX < 0){
            xVel = -xVel;
        }
        else if(BallposX > 780){
            xVel = -xVel;
        }

    }

    public void draw(Graphics g){

        g.setColor(Color.white);
        g.fillOval(BallposX, BallposY, 20, 20);

    }

    public void checkCollision(paddle p1){
        if (BallposY >= 720){
            if(BallposX >= p1.getX() && BallposX <= p1.getX() + 80){
                yVel = -yVel;
            }
        }
    }

    public void checkBrickCollision(Bricks bricks){
        //bricks.map

    }
}
