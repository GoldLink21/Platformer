import java.awt.*;
import java.util.ArrayList;

public class Player extends Entity {

    boolean onPlatform=false;

    final int SPEED=5;

    Player(int x,int y){
        super(x,y,10,10, Color.BLUE);
    }

    private void checkCollisions(){

    }

    private void checkNextCollision(){

    }

    private void goOnTopOf(Platform plat){
        y=plat.getY()-height;
        onPlatform=true;
    }

    private Rectangle getNextBounds(){
        return new Rectangle(x+dx,y+dy,width,height);
    }

    @Override
    public void paint(Graphics g) {
        defaultColor(g);
    }

    @Override
    public void move(){
        if(Data.isGamePlay()){
            if(Data.isLeft()){
                dx=-SPEED;
            }if(Data.isRight()){
                dx=SPEED;
            }
        }
    }
}
