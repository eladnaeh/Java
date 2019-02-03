import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class paddle {

    boolean rightAccel, leftAccel;
    int x = 360;
    int y = 740;
    double xVel;
    //double Gravity = 0.3;

    public void draw(Graphics g){

        g.setColor(Color.white);
        g.fillRect(x, y, 80, 20);

    }

    public void move(){

        if(rightAccel){
            xVel += 2;
        }
        else if(leftAccel){
            xVel -= 2;
        }
        else if (!rightAccel && !leftAccel){
            xVel *= 0;
        }

        if(xVel >= 5){
            xVel = 5;
        }
        else if (xVel <= -5){
            xVel = -5;
        }

        if (x <= 0){
            x = 0;
        }
        else if (x >= 720){
            x = 720;
        }

        x+=xVel;

        // add bounderies

    }

    public void setRightAccel(boolean input){
        rightAccel = input;
    }

    public void setLeftAccel(boolean input){
        leftAccel = input;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
