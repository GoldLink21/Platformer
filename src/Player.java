import java.awt.*;
import java.util.ArrayList;

public class Player extends Entity {

    Player(int x,int y){
        super(x,y,10,10, Color.BLUE);
    }

    private void checkCollisions(){

    }

    private boolean touchingPlatform(){
        ArrayList<Entity> entities = Board.getEntities();
        for(int i=1;i<entities.size();i++){
            if(collidesWith(entities.get(i))&&entities.get(i)instanceof Platform){
                return true;
            }
        }
        return false;
    }

    @Override
    public void paint(Graphics g) {
        defaultColor(g);
    }

    @Override
    public void move(){

    }
}
