import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class tennis extends Applet implements Runnable, KeyListener {
    Thread thread;
    HumanPaddle p1;
    AiPaddle p2;
    Ball b1;
    final int WIDTH = 700, HEIGHT = 500;
    boolean GameStarted;
    Graphics gfx;
    Image img;

    public void init(){

        resize(WIDTH,HEIGHT);
        this.addKeyListener(this);
        p1 = new HumanPaddle(1);
        b1 = new Ball();
        p2 = new AiPaddle(2, b1);
        GameStarted = false;
        img = createImage(WIDTH, HEIGHT);
        gfx = img.getGraphics();
        thread = new Thread(this);
        thread.start();

    }

    public void paint(Graphics g){

        gfx.setColor(Color.black);
        gfx.fillRect(0,0,WIDTH,HEIGHT);
        if(b1.getX()<-10 || b1.getX()>710){
            gfx.setColor(Color.red);
            gfx.drawString("GAME OVER!", 350, 250);
        }
        else{
            p1.draw(gfx);
            b1.draw(gfx);
            p2.draw(gfx);
        }

        if(!GameStarted){
            gfx.setColor(Color.white);
            gfx.drawString("tennis", 340, 100);
            gfx.drawString("press enter to begin", 310, 130);
        }

        g.drawImage(img, 0,0, this);

    }

    public void update(Graphics g){
        paint(g);
    }


    public void run() {

        for(;;){
            if(GameStarted) {
                p1.move(HEIGHT);
                b1.move();
                p2.move(HEIGHT);
                b1.checkPaddleCollision(p1, p2);
            }

            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_UP){
            p1.setUpAccel(true);
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            p1.setDownAccel(true);
        }
        else if(e.getKeyCode() == KeyEvent.VK_ENTER){
            GameStarted = true;
        }

    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            p1.setUpAccel(false);
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            p1.setDownAccel(false);
        }
    }

    public void keyTyped(KeyEvent e) {

    }
}
