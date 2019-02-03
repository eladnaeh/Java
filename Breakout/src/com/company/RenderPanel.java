package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class RenderPanel extends JPanel {

    public int blockWidth = 30;

    public int width = 800;
    public int height = 700;
    public int Hgap = 3;
    public int Vgap = 3;
    public int numOfBlocksPerRow = 10;
    public int sizeBlocks = Vgap * (numOfBlocksPerRow - 1) + numOfBlocksPerRow * blockWidth;
    public final int SCALE = 10;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //need to call the super first
        g.setColor(Color.black);
        Breakout breakout = Breakout.breakout;
        g.fillRect(0,0, width, height);
        g.setColor(Color.red);
        //System.out.println(breakout.playerPosX + ":" + breakout.playerPosY);
        g.fillRect(breakout.playerPosX, breakout.playerPosY, breakout.playerLength, breakout.playerWidth);
        g.setColor(Color.white);
        g.fillOval(breakout.ballPosX, breakout.ballPosY, breakout.ballHeight, breakout.ballWidth);
//        for (int i=0; i<5; i++){
//            for (int j=0; j<10; j++){
//                //System.out.println(width / 2 + sizeBlocks / 2 - (((breakout.blockWidth + Vgap) * j) + breakout.blockWidth));
//                //System.out.println(width + ":" + sizeBlocks + ":" + blockWidth + ":" + Vgap + "2");
//                g.drawRect(width / 2 + sizeBlocks / 2 - (((breakout.blockWidth + Vgap) * j) + breakout.blockWidth) ,20 + (breakout.blockHeight + Hgap)*i + breakout.blockHeight, breakout.blockHeight, breakout.blockWidth);
//            }
//        }
        //System.out.println(width + ":" + sizeBlocks + ":" + blockWidth + ":" + Vgap + "2");
        //System.out.println(breakout.positions.get(0));
        for (int i=0; i<breakout.positions.size(); i++){
            Map<Integer, Integer> tempMap = breakout.positions.get(i);
            for (int key : tempMap.keySet()){
                if(tempMap.get(key) == -1){
                    continue;
                }
                else{
                    g.fillRect(key , tempMap.get(key) , breakout.blockHeight, breakout.blockWidth);
                }
            }
        }
    }
}
