import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.sql.Time;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

    private boolean gameStarted = false;
    private int score = 0;
    private int totalBricks = 21;
    private Timer time;
    private int delay = 8;
    private int BallposX = 120;
    private int BallposY = 350;
    private int PlayerX = 310;
    private int BallXdir = -1;
    private int BallYdir = -2;


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
