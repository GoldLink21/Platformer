import java.awt.Graphics;
import java.awt.Color;

public class Platform extends Entity {

    Platform(int x,int y,int width,int height,Color color){
        super(x,y,width,height,color);
    }

    @Override
    public void paint(Graphics g) {
        defaultColor(g);
    }
}
