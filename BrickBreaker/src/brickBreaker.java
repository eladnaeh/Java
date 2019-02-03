import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class brickBreaker extends Applet implements Runnable, KeyListener {

    Graphics g;
    int width = 800;
    int height = 800;
    paddle p1;
    Ball b1;
    Bricks bricks;
    Thread thread;
    Image img;
    Graphics gfx;
    //String scoreString;
    //public int score = 0;

    public void init(){
        this.resize(width, height);
        this.addKeyListener(this);
        p1 = new paddle();
        b1 = new Ball();
        img = createImage(width, height);
        gfx = img.getGraphics();
        bricks = new Bricks(3,7);
        thread = new Thread(this);
        thread.start();
    }

    public void paint(Graphics g){

        gfx.setColor(Color.black);
        gfx.fillRect(0,0, width, height);
        gfx.setColor(Color.red);
        //scoreString = "score:" + score;
        //gfx.draw(scoreString);
        p1.draw(gfx);
        b1.draw(gfx);
        bricks.draw((Graphics2D) gfx);

        g.drawImage(img, 0, 0, this);

    }

    public void update(Graphics g){
        paint(g);
    }

    public void run(){

        for(;;) {

            p1.move();
            b1.move();
            b1.checkCollision(p1);

            // if (
            b1.checkBrickCollision(bricks);
            // ) {score += 1}

            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            p1.setLeftAccel(true);
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            p1.setRightAccel(true);
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            p1.setLeftAccel(false);
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            p1.setRightAccel(false);
        }
    }


}
