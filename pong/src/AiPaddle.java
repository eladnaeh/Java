import java.awt.*;

public class AiPaddle implements paddle {

    int player, x;
    double y, yVel;
    final double Gravity = 0.94;
    int height;
    boolean upAccel, downAccel;
    Ball b1;

    public AiPaddle (int player, Ball b){

        y = 210; yVel = 0; upAccel = false; downAccel = false; b1=b;
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

        y = b1.getY() - 40;

        if (y < 0){
            y = 0;
        }

        else if (y > height - 80){
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
