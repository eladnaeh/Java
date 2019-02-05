package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class RenderPanel extends JPanel {



    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.setColor(Color.black);
        Tetris tetris = Tetris.tetris;
        g.fillRect(0,0, tetris.jFrame.getWidth(), tetris.jFrame.getHeight());

        Point point = new Point(10,10);
        g.setColor(Color.red);

        for (int i=0; i<tetris.lShape.length; i++){
            //System.out.println(Arrays.toString(tetris.lShape));
            g.fillRect(tetris.lShape[i].x, tetris.lShape[i].y, tetris.blockWidth, tetris.blockHeight);
        }

    }
}
