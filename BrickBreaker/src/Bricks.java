import java.awt.*;

public class Bricks {
    public int map[][];
    public int width;
    public int height;
    public Bricks(int row, int col){
        map = new int [row] [col];
        for(int i=0; i<map.length; i++){
            for(int j=0; j< map[0].length; j++){
                map[i][j] = 1;
            }
        }

        width = 540/col;
        height = 150/row;

    }
    public void draw(Graphics2D g){
        for(int i=0; i<map.length; i++){
            for(int j=0; j< map[0].length; j++){
                if(map[i][j] > 0){
                    g.setColor(Color.white);
                    g.fillRect(j*width + 130, i*height + 50, width, height);

                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j*width + 130, i*height + 50, width, height);
                }
            }
        }
    }
    public void setBrickValue(int Value, int row, int col){
        map[row][col] = Value;
    }
}
