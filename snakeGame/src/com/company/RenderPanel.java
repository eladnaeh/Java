package com.company;

import javax.swing.*;
import java.awt.*;

public class RenderPanel extends JPanel {

    //public static int currentColor = 0;
    public static Color green = new Color(1666073);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //you should call the super in the first command
        g.setColor(green);
        Snake snake = Snake.snake;
        g.fillRect(0, 0, 800, 700);
        g.setColor(Color.BLUE);
        for (Point point : snake.snakeParts){
            g.fillRect(point.x * snake.SCALE, point.y * snake.SCALE, snake.SCALE, snake.SCALE);
        }
        g.fillRect(snake.head.x * snake.SCALE, snake.head.y * snake.SCALE, snake.SCALE, snake.SCALE);
        g.setColor(Color.RED);
        g.fillRect(snake.cherry.x * snake.SCALE, snake.cherry.y * snake.SCALE, snake.SCALE, snake.SCALE);
        String s = "Score: " + snake.score + ", Length: " + snake.tailLength + ", Time: " + snake.time / 20;
        g.setColor(Color.WHITE);
        g.drawString(s,(int)(getWidth() / 2 - s.length() * 2.5f), 10);
        s = "Game over!";
        if(snake.over){
            g.drawString(s, (int)(getWidth() / 2 - s.length() * 2.5f), (int)snake.dimension.getHeight() / 4);
        }
        s = "Paused!";
        if(snake.paused){
            g.drawString(s, (int)(getWidth() / 2 - s.length() * 2.5f), (int)snake.dimension.getHeight() / 4);
        }
    }

}
