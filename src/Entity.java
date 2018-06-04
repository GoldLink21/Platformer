import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity implements Movable{
    BufferedImage img;
    int x,y,width,height;
    private boolean remove;
    Color color;

    Entity(int x,int y,int width,int height,String file){
        setPosition(x,y);
        this.width=width;
        this.height=height;
        img=ImageLoader.getImg(file);
    }

    Entity(int x,int y,int width,int height,Color color){
        setPosition(x,y);
        this.width=width;
        this.height=height;
        this.color=color;
    }

    void setToRemove(){remove=true;}

    boolean toRemove(){return remove;}

    private Rectangle getBounds(){return new Rectangle(x,y,width,height);}

    boolean collidesWith(Entity other){ return getBounds().intersects(other.getBounds());}

    void defaultColor(Graphics g){
        g.setColor(color);
        g.fillRect(x,y,width,height);
        g.setColor(Color.BLACK);
        g.drawRect(x,y,width,height);
    }

    @Override
    public void move(){}

    @Override
    public void setPosition(int x,int y){
        this.x=x;
        this.y=y;
    }
}
