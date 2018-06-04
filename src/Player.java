import java.awt.*;

public class Player extends Entity {

    Player(int x,int y){
        super(x,y,10,10, Color.BLUE);
    }

    @Override
    public void paint(Graphics g) {
        defaultColor(g);
    }

    @Override
    public void move(){

    }
}
