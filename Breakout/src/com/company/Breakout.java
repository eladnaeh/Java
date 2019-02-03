package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Breakout implements KeyListener, ActionListener{

    public JFrame jFrame;
    public Dimension dimension;
    public RenderPanel renderPanel;
    public static Breakout breakout;
    public Timer timer;
    public Random random;

    public int playerPosX, playerPosY;
    public int playerLength, playerWidth;

    public int time, ticks, hits, score;

    public int direction;
    public final int STOP = 0, LEFT = 1, RIGHT = 2, SELF = 10;
    public int stepSize = 7;

    public int ballPosX, ballPosY, ballWidth, ballHeight;
    public int ballStepSize, ballVelocityX, ballVelocityY;

    public boolean over;

    public int[][] blocks = new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public int blockWidth, blockHeight;

    //public Map<Integer, Integer> blockPositions = new HashMap<>();
    public ArrayList<Map> positions = new ArrayList<>();

    public int Hgap = 3;
    public int Vgap = 3;
    public int numOfBlocksPerRow = 10;
    public int sizeBlocks;
    //public int sizeBlocks = Vgap * (numOfBlocksPerRow - 1) + (numOfBlocksPerRow * blockWidth);

    public static void main(String[] args) {
        breakout = new Breakout();
    }
    public Breakout(){
        //System.out.println(sizeBlocks);
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame = new JFrame("Breakout");
        jFrame.setVisible(true);
        jFrame.setSize(800, 700);
        jFrame.setResizable(false);
        jFrame.setLocation(dimension.width / 2 - jFrame.getWidth() / 2, dimension.height / 2 - jFrame.getHeight() / 2);
        jFrame.add(renderPanel = new RenderPanel());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.addKeyListener(this);


        random = new Random();
        timer = new Timer(20, this);
        timer.start();


        startGame();
    }

    public void startGame(){
        playerLength = 80;
        playerWidth = 20;
        playerPosX = jFrame.getWidth() / 2 - playerLength / 2;
        playerPosY = 600 - playerWidth;

        ballWidth = 20;
        ballHeight = 20;
        ballPosX = jFrame.getWidth() / 2 - ballWidth / 2;
        ballPosY = jFrame.getHeight() / 2 - ballHeight / 2;

        //ballStepSize = ballVelocityY = ballVelocityX = random.nextInt(5);
        ballStepSize = ballVelocityX = -3;
        ballVelocityY = -3;

        blockWidth = 30;
        blockHeight = 30;

        sizeBlocks = Vgap * (numOfBlocksPerRow - 1) + (numOfBlocksPerRow * blockWidth);

        for (int i=0; i<5; i++){
            Map<Integer, Integer> blocks = new HashMap<>();
            for (int j=0; j<10; j++){
                //System.out.println("in for loop");
                //System.out.println(jFrame.getWidth() + ":" + sizeBlocks + ":" + blockWidth + ":" + Vgap + "1");
                blocks.put(jFrame.getWidth() / 2 + sizeBlocks / 2 - (((blockWidth + Vgap) * j) + blockWidth), 20 + (blockHeight + Hgap)*i + blockHeight);
            }
            positions.add(blocks);
            //System.out.println(blocks);
        }
        //System.out.println(positions);


        time = 0;
        ticks = 0;
        hits = 0;
        score = 0;
        over = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jFrame.repaint();
        ticks++;
        if(ticks % 0.25 == 0 && !over){

            ballPosX += ballVelocityX;
            ballPosY += ballVelocityY;

            if(playerPosX > (jFrame.getWidth() - playerLength)){
                playerPosX = jFrame.getWidth() - playerLength;
            }
            if (playerPosX < 0){
                playerPosX = 0;
            }
            if(direction == 0){
                playerPosX += 0;
            }
            if(direction == 1){
                playerPosX -= stepSize;
            }
            if(direction == 2){
                playerPosX += stepSize;
            }
            if(direction == 10){
                playerPosX = ballPosX;
            }
            if(ballPosX > jFrame.getWidth() - (ballWidth + 10)){
                ballPosX = jFrame.getWidth() - (ballWidth + 10);
                ballVelocityX = -ballVelocityX;
            }
            if(ballPosX < 0){
                ballPosX = 0;
                ballVelocityX = -ballVelocityX;
            }
            if(ballPosY < 0){
                ballVelocityY = -ballVelocityY;
            }
            if(ballPosY > jFrame.getHeight() - ballHeight){
                over = true;
            }
            if (ballPosX > playerPosX - (ballWidth-1) && ballPosX < playerPosX + 60 && ballPosY >= playerPosY - 20 && ballPosY <= playerPosY + 20){
                ballVelocityY = -ballVelocityY;
            }

            for (int i=0; i<positions.size(); i++){
                Map<Integer,Integer> blockPositions = positions.get(i);
                //System.out.println(blockPositions);
                for (int key : blockPositions.keySet()){
                    if(blockPositions.size() > 0){

                        //down side hit
                        if(ballPosX + 19> key && ballPosX < key + 30 && ballPosY > blockPositions.get(key) && ballPosY < blockPositions.get(key) + 30 ){

                            System.out.println("down hit");
                            blockPositions.replace(key, -1);
                            ballVelocityY = -ballVelocityY;
                            hits++;
                            score += 1;
                            ballVelocityX *= 1.1;
                            ballVelocityY *= 1.1;
                            continue;

                        }
                        //up side hit
                        if(ballPosX + 19> key && ballPosX < key + 30 && ballPosY + 20 > blockPositions.get(key) && ballPosY + 20 < blockPositions.get(key) + 30){
                            System.out.println("up hit");
                            blockPositions.replace(key, -1);
                            ballVelocityY = -ballVelocityY;
                            hits++;
                            score += 1;
                            ballVelocityX *= 1.1;
                            ballVelocityY *= 1.1;
                            continue;
                        }
                        //left side hit
                        if(ballPosX + 20 > key && ballPosX + 20 < key + 30 && ballPosY + 19 > blockPositions.get(key) && ballPosY < blockPositions.get(key) + 30){
                            System.out.println("left hit");
                            blockPositions.replace(key, -1);
                            ballVelocityX = -ballVelocityX;
                            hits++;
                            score += 1;
                            ballVelocityX *= 1.1;
                            ballVelocityY *= 1.1;
                            continue;
                        }
                        //right side hit
                        if(ballPosX < key + 30 && ballPosX > key && ballPosY + 19 > blockPositions.get(key) && ballPosY < blockPositions.get(key) + 30){
                            System.out.println("right hit");
                            blockPositions.replace(key, -1);
                            ballVelocityX = -ballVelocityX;
                            hits++;
                            ballVelocityX *= 1.1;
                            ballVelocityY *= 1.1;
                            continue;
                        }
                        // add hit detection
//                        else if(ballPosX == key && ballPosY >= blockPositions.get(key) && ballPosY <= blockPositions.get(key) + 20){
//
//                            blockPositions.replace(key, -1);
//                            ballVelocityX = -ballVelocityX;
//                            hits++;
//                            score += 1;
//                            continue;
//
//                        }
//
//                        else if(ballPosX == key-20 && ballPosY >= blockPositions.get(key) && ballPosY <= blockPositions.get(key) + 20){
//
//                            blockPositions.replace(key, -1);
//                            ballVelocityX = -ballVelocityX;
//                            hits++;
//                            score += 1;
//                            continue;
//
//                        }
//
//                        else if(ballPosX > key && ballPosX < key + 30 && ballPosY <= blockPositions.get(key) && ballPosY >= blockPositions.get(key) - 20){
//
//                            blockPositions.replace(key, -1);
//                            ballVelocityY = - ballVelocityY;
//                            hits++;
//                            score += 1;
//                            continue;
//
//
                    }
                    else{
                        over = true;
                    }
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
        if(i == KeyEvent.VK_LEFT){
            direction = LEFT;
        }
        if(i == KeyEvent.VK_RIGHT){
            direction = RIGHT;
        }
        if(i == KeyEvent.VK_A){
            direction = SELF;
        }
        if(i == KeyEvent.VK_SPACE && over){
            breakout = new Breakout();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int i = e.getKeyCode();
        if(i == KeyEvent.VK_LEFT || i == KeyEvent.VK_RIGHT){
            direction = STOP;
        }
    }
}
