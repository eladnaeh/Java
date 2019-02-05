package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;

public class Main extends JPanel{

    public static JFrame jFrame;

    public static int blockSizeGraph = 26;
    public static int numblocksPerRow = 12;
    public static int numOfRows = 23;


    public final Point[][][] shapes = {
            //I Shape
            {
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
                    { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) },
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1) },
                    { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3) }
            },

            // J-Piece
            {
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 0) },
                    { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 2) },
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 2) },
                    { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 0) }
            },

            // L-Piece
            {
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(2, 2) },
                    { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(0, 2) },
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(0, 0) },
                    { new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0) }
            },

            // O-Piece
            {
                    { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
                    { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
                    { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) },
                    { new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(1, 1) }
            },

            // S-Piece
            {
                    { new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
                    { new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
                    { new Point(1, 0), new Point(2, 0), new Point(0, 1), new Point(1, 1) },
                    { new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) }
            },

            // T-Piece
            {
                    { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(2, 1) },
                    { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(1, 2) },
                    { new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(1, 2) },
                    { new Point(1, 0), new Point(1, 1), new Point(2, 1), new Point(1, 2) }
            },

            // Z-Piece
            {
                    { new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
                    { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) },
                    { new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1) },
                    { new Point(1, 0), new Point(0, 1), new Point(1, 1), new Point(0, 2) }
            }

    };

    public final Color[] colors = {Color.blue, Color.CYAN, Color.green, Color.pink, Color.red, Color.yellow, Color.orange};

    public Point pointOrigin;
    public int currentPiece;
    public int rotation;
    public ArrayList<Integer> nextPieces = new ArrayList<>();
    public int score;
    public static boolean over = false;
    public Color[][] wall;
    public static Main game;



    public void init(){

        wall = new Color[numblocksPerRow][numOfRows+1];
        for (int i=0; i<numblocksPerRow; i++){
            for (int j=0; j<numOfRows; j++){
                if(i == 0 || i == numblocksPerRow-1 || j == numOfRows-1){
                    wall[i][j] = Color.GRAY;
                }
                else {
                    wall[i][j] = Color.BLACK;
                }
            }
        }
        newPiece();
    }

    public void newPiece(){

        pointOrigin = new Point(5,2);
        rotation = 0;
        if(nextPieces.isEmpty()){
            Collections.addAll(nextPieces, 0,1,2,3,4,5,6);
            Collections.shuffle(nextPieces);
        }
        currentPiece = nextPieces.get(0);
        nextPieces.remove(0);

        if(wall[pointOrigin.x][pointOrigin.y] != Color.BLACK){
            over = true;
        }

    }

    public void move(int i){
        if(!collideAt(pointOrigin.x+i, pointOrigin.y, rotation)){
            pointOrigin.x += i;
        }
        repaint();
    }

    public void rotate(int i){
        int newRotation = (rotation + i) % 4;
        if(newRotation < 0){
            newRotation = 3;
        }
        if(!collideAt(pointOrigin.x, pointOrigin.y, newRotation)){
            rotation = newRotation;
        }
        repaint();
    }

    public void dropDown(){
        if(!collideAt(pointOrigin.x, pointOrigin.y + 1, rotation)){
            pointOrigin.y+=1;
        }
        else{
            addToBorder();
        }
        repaint();
    }

    public boolean collideAt(int x, int y, int rotation) {
        for (Point point : shapes[currentPiece][rotation]) {
            if(wall[point.x + x][point.y +y] != Color.BLACK){
                return true;
            }
        }
        return false;
    }

    public void addToBorder(){
        for (Point point : shapes[currentPiece][rotation]){
            wall[point.x + pointOrigin.x][point.y + pointOrigin.y] = colors[currentPiece];
        }
        clearRows();
        newPiece();
    }

    public void deleteRow(int row){
        for (int i=0; i<numblocksPerRow; i++){
            for (int j = row - 1; j>0; j--){
                wall[i][j+1] = wall[i][j];
            }
        }
    }

    public void clearRows(){
        boolean gap;
        int numOfClears = 0;

        for (int j = numOfRows-2; j>0; j--){
            gap = false;
            for (int i = 0; i< numblocksPerRow; i++){
                if (wall[i][j] == Color.BLACK){
                    gap = true;
                    break;
                }
            }
            if (!gap){
                deleteRow(j);
                j+=1;
                numOfClears += 1;
            }
        }

        switch (numOfClears){
            case 1:
                score += 100;
                break;
            case 2:
                score += 300;
                break;
            case 3:
                score += 500;
                break;
            case 4:
                score += 800;
                break;
        }
    }

    public void drawPiece(Graphics g){
        g.setColor(colors[currentPiece]);
        for (Point point : shapes[currentPiece][rotation]){
            g.fillRect((point.x + pointOrigin.x)*blockSizeGraph, (point.y + pointOrigin.y)*blockSizeGraph, blockSizeGraph, blockSizeGraph);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if(!over){
            super.paintComponent(g);
            g.fillRect(0,0, jFrame.getWidth(), jFrame.getHeight());
            for (int i=0; i<numblocksPerRow; i++){
                for (int j=0; j<numOfRows; j++){
                    g.setColor(wall[i][j]);
                    g.fillRect(i*blockSizeGraph, j*blockSizeGraph, blockSizeGraph-1, blockSizeGraph-1);
                }
            }

            g.setColor(Color.white);
            g.drawString("" + score, 19*12, 25 );

            drawPiece(g);
        }
        else{
            super.paintComponent(g);
            String str = "GameOver!, press A to restart.";
            g.drawString(str, jFrame.getWidth()/3 - str.length(), jFrame.getHeight()/2);
        }
    }

    public static void main(String[] args){
        jFrame = new JFrame("Tetris");
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setSize(numblocksPerRow * blockSizeGraph + 15, numOfRows * blockSizeGraph + 25);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game = new Main();
        game.init();
        jFrame.add(game);
        jFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int i = e.getKeyCode();
                if(i == KeyEvent.VK_UP){
                    game.rotate(1);
                }
                if(i == KeyEvent.VK_DOWN){
                    game.rotate(-1);
                }
                if(i == KeyEvent.VK_RIGHT){
                    game.move(1);
                }
                if(i == KeyEvent.VK_LEFT){
                    game.move(-1);
                }
                if(i == KeyEvent.VK_SPACE){
                    game.dropDown();
                    game.score += 1;
                }
                if(over && i == KeyEvent.VK_A){
                    System.exit(0);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        new Thread() {
            @Override public void run(){
                while (!over){
                    try {
                        Thread.sleep(1000);
                        game.dropDown();
                    }
                    catch (InterruptedException e){}
                }
            }
        }.start();
    }
}
