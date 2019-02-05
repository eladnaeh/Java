import java.awt.*;
import java.util.Random;

public class Ball {
    double x,y,xVel,yVel;
    Random rand = new Random();
    public Ball(){
        x=350;y=250;
        xVel=(rand.nextInt(4))-2;
        yVel=(rand.nextInt(4))-2;
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval((int)x-10,(int)y-10,20,20);
    }

    public void checkPaddleCollision(paddle p1, paddle p2){
        if(x<=50){
            if(y >= p1.getY() && y <= p1.getY() +80){
                xVel = -xVel;
            }
        }
        else if(x>=650){
            if(y >= p2.getY() && y <= p2.getY() +80){
                xVel = -xVel;
            }
        }
    }

    public void move(){


        x+=xVel;
        y+=yVel;

        if(y<10){
            yVel = -yVel;
        }
        else if(y>490){
            yVel = -yVel;
        }

    }
    public int getX(){
        return (int) x;
    }
    public int getY(){
        return (int) y;
    }
}
