package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Time;
import java.util.Arrays;
import java.util.Random;

public class Tetris implements KeyListener, ActionListener{

    JFrame jFrame;
    public Dimension dimension;
    public static Tetris tetris;
    public RenderPanel renderPanel;
    public Timer timer;
    public Random random;
    public Shape shape;
    public int blockWidth = 25, blockHeight = 25;
    public int ticks;


    public static void main(String[] args) {
        tetris = new Tetris();
    }

    public Tetris(){

        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame = new JFrame("Tetris");
        jFrame.setVisible(true);
        jFrame.setSize(800, 700);
        jFrame.setResizable(false);
        jFrame.setLocation(dimension.width / 2 - jFrame.getWidth() / 2, dimension.height / 2  - jFrame.getHeight() / 2);
        jFrame.add(renderPanel = new RenderPanel()); //remember to initialize the RenderPanel class!
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.addKeyListener(this);

        timer = new Timer(20, this);
        timer.start();
        ticks = 0;

        random = new Random();

    }

    public void moveShape(){
        Shape lShape = new Shape("lShape");
        int rand = random.nextInt(jFrame.getWidth() - 200);
        if(lShape.shapeTypeArray == )

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int i = e.getKeyCode();
        if(i == KeyEvent.VK_P){
            //System.out.println("pressed");
            moveShape();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jFrame.repaint();
    }
}
