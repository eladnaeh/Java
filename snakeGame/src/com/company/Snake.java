package com.company;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;

public class Snake implements ActionListener, KeyListener {

    public JFrame jframe;
    public Toolkit toolkit;
    public RenderPanel renderPanel;
    public static Snake snake;
    public Timer timer = new Timer(20, this);

    public ArrayList<Point> snakeParts = new ArrayList<>();
    public int ticks = 0;
    public int score;
    public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, SCALE = 10;
    public int direction = DOWN;
    public int tailLength = 10;
    public int time;
    public Point head, cherry;

    public Random random;
    public Dimension dimension;
    public boolean over = false;
    public boolean paused;


    public Snake() {
        //toolkit = Toolkit.getDefaultToolkit();
        dimension = Toolkit.getDefaultToolkit().getScreenSize();

        jframe = new JFrame("Snake");
        jframe.setVisible(true);
        jframe.setSize(805, 700);
        jframe.setResizable(false);
        jframe.setLocation(dimension.width / 2 - jframe.getWidth() / 2, dimension.height / 2 - jframe.getHeight() / 2);
        jframe.add(renderPanel = new RenderPanel());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.addKeyListener(this);
        startGame();
    }

    public void startGame(){
        over = false;
        paused = false;
        score = 0;
        tailLength = 10;
        ticks = 0;
        time = 0;
        direction = DOWN;
        head = new Point(0, -1);
        random = new Random();
        snakeParts.clear();
        cherry = new Point(random.nextInt(79), random.nextInt(66));
        timer.start();
    }

    public static void main(String[] args) {
        snake = new Snake();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        renderPanel.repaint();
        ticks++;
        if (ticks % 2 == 0 && head != null && over != true && paused != true){
            time++;
            snakeParts.add(new Point(head.x, head.y));
            if(direction == UP){
                if(head.y - 1 >= 0 && noTailAt(head.x, head.y - 1)){
                    head = new Point(head.x, head.y - 1);
                }
                else{
                    over = true;
                }
            }
            if(direction == DOWN){
                if(head.y + 1 < 67 && noTailAt(head.x, head.y + 1)){
                    head = new Point(head.x, head.y + 1);
                }
                else{
                    over = true;
                }
            }
            if(direction == LEFT){
                if(head.x - 1 >= 0 && noTailAt(head.x - 1, head.y)){
                    head = new Point(head.x -1, head.y );
                }
                else{
                    over = true;
                }
            }
            if(direction == RIGHT){
                if(head.x + 1 < 80 && noTailAt(head.x + 1, head.y)){
                    head = new Point(head.x + 1, head.y);
                }
                else {
                    over = true;
                }
            }
            if (snakeParts.size() > tailLength){
                snakeParts.remove(0);
            }
            if(cherry != null){
                if(head.equals(cherry)){
                    score += 10;
                    tailLength++;
                    cherry.setLocation(random.nextInt(79), random.nextInt(66));
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int i = e.getKeyCode();
        if(i == KeyEvent.VK_UP){
            direction = UP;
        }
        if(i == KeyEvent.VK_DOWN){
            direction = DOWN;
        }
        if(i == KeyEvent.VK_RIGHT){
            direction = RIGHT;
        }
        if(i == KeyEvent.VK_LEFT){
            direction = LEFT;
        }
        if(i == KeyEvent.VK_SPACE){
            if(over){
                startGame();
            }
            else {
                paused = !paused;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public boolean noTailAt(int x, int y){
        for(Point point : snakeParts){
            if(point.equals(new Point(x,y))){
                return false;
            }
        }
        return true;
    }
}
