package com.company;

import java.awt.*;

public class Shape {

    public String shapeType;
    public Point[][] shapeTypeArray;

    public Shape(String shapeType){
        this.shapeType = shapeType;
        this.shapeTypeArray = getShape();
    }

    public Point[][] getShape() {
        Point[][] shape;
        if (shapeType == "lShape") {
            shape = new Point[][]{
                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1)},
                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3)},
                    {new Point(0, 1), new Point(1, 1), new Point(2, 1), new Point(3, 1)},
                    {new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(1, 3)}
            };

        } else {
            shape = null;
        }
        return shape;
    }
}
