import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity implements Movable{
    BufferedImage img;
    int x,y,width,height,dx=0,dy=0;
    private boolean remove;
    private Color color;

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

    public Rectangle getBounds(){return new Rectangle(x,y,width,height);}

    boolean collidesWith(Entity other){ return getBounds().intersects(other.getBounds());}

    void defaultColor(Graphics g){
        g.setColor(color);
        g.fillRect(x,y,width,height);
        g.setColor(Color.BLACK);
        g.drawRect(x,y,width,height);
    }

    void defaultImage(Graphics g){
        g.drawImage((img).getScaledInstance(width,height,Image.SCALE_SMOOTH),x,y,null);
    }

    boolean onScreen(){
        return(pointOnScreen(x,y)||pointOnScreen(x+width,y+height));
    }

    private boolean pointOnScreen(int x,int y){
        if(x>=(-Data.BOARD_SIZE/2)+Data.getX()&&x<=(Data.BOARD_SIZE/2)+Data.getX()){
            if(y>=(-Data.BOARD_SIZE/2)+Data.getY()&&y<=(Data.BOARD_SIZE/2)+Data.getY()){
                return true;
            }
        }
        return false;
    }

    int getX(){return x;}
    int getY(){return y;}
    int getWidth(){return width;}
    int getHeight(){return height;}

    @Override
    public void move(){}

    @Override
    public void setPosition(int x,int y){
        this.x=x+Data.BOARD_SIZE/2;
        this.y=y+Data.BOARD_SIZE/2;
    }
}
