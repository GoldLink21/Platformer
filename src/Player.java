import java.awt.*;
import java.util.ArrayList;

public class Player extends Entity {

    int dx=0,dy=0;
    
    Player(int x,int y){
        super(x,y,10,10, Color.BLUE);
    }

    private void checkCollisions(){
        ArrayList<Entity> entities = Board.getEntities();
        for(int i=1;i<entities.size();i++){
            if(collidesWith(entities.get(i))&&entities.get(i)instanceof Platform){
                setPosition(entities.get(i).getY()+height,y);
            }
        }
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
        if(Data.isRight()){
            
        }if(Data.isLeft()){
            
        }
    }
}
