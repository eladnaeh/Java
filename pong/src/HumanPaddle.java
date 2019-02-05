import java.awt.*;

public class HumanPaddle implements paddle {

    int player, x;
    double y, yVel;
    final double Gravity = 0.94;
    int height;
    boolean upAccel, downAccel;

    public HumanPaddle (int player){

        y = 210; yVel = 0; upAccel = false; downAccel = false;
        if(player == 1){
            x = 20;
        }
        else{
            x = 660;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x,(int)y, 20, 80);
    }

    public void move(int height) {
        if(upAccel){
            yVel -= 2;
        }
        else if(downAccel){
            yVel += 2;
        }
        else if(!upAccel && !downAccel){
            yVel *= Gravity;
        }

        if(yVel >= 5){
            yVel = 5;
        }

        else if(yVel<=-5){
            yVel = -5;
        }
        y+=yVel;

        if (y < 0){
            y = 0;
        }

        else if(y > height - 80){
            y = height - 80;
        }
    }

    public void setUpAccel(boolean input){
        upAccel = input;
    }

    public void setDownAccel(boolean input){
        downAccel = input;
    }

    public int getY() {
        return (int)y;
    }
}
